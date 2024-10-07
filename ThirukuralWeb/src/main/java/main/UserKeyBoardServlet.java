package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/keyboard")
public class UserKeyBoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Thirukural> kuralList;

    @Override
    public void init() throws ServletException {
        // Load the Thirukkural JSON file into memory during servlet initialization
        InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/resources/thirukkural.json");
        if (inputStream == null) {
            throw new ServletException("Unable to load Thirukkural JSON file: Input stream is null.");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Deserialize the JSON into a list of Thirukural objects
            kuralList = objectMapper.readValue(inputStream,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Thirukural.class));
        } catch (IOException e) {
            throw new ServletException("Error reading Thirukkural JSON file.", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json"); // Set response type to JSON
        response.setCharacterEncoding("UTF-8"); // Ensure proper character encoding

        // Retrieve query parameters
        String keywordParam = request.getParameter("kural-keyword");
        String numberParam = request.getParameter("kural-number");

        // If searching by keyword
        if (keywordParam != null && !keywordParam.trim().isEmpty()) {
            handleKeywordSearch(keywordParam, response);
        }
        // If searching by kural number
        else if (numberParam != null && !numberParam.trim().isEmpty()) {
            handleNumberSearch(numberParam, response);
        }
        // If neither keyword nor number is provided, return a bad request
        else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No valid search parameter provided.");
        }
    }

    // Method to handle keyword search
    private void handleKeywordSearch(String keywordParam, HttpServletResponse response) throws IOException {
        String keyword = keywordParam.toLowerCase(); // Convert the keyword to lowercase for case-insensitive search

        // Filter the kuralList for matching keywords in transliteration1 or transliteration2
        List<Thirukural> matchedKurals = kuralList.stream()
                .filter(kural -> kural.getTransliteration1().toLowerCase().contains(keyword)
                        || kural.getTransliteration2().toLowerCase().contains(keyword))
                .collect(Collectors.toList());

        // If no matching kural is found, return 404
        if (matchedKurals.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No Kural found containing the keyword.");
        } else {
            writeJsonResponse(response, matchedKurals); // Write the matching results as JSON response
        }
    }

    // Method to handle search by kural number
    private void handleNumberSearch(String numberParam, HttpServletResponse response) throws IOException {
        try {
            int number = Integer.parseInt(numberParam); // Parse the kural number

            // Find the kural with the given number
            Thirukural foundKural = kuralList.stream()
                    .filter(kural -> kural.getnumber() == number)
                    .findFirst()
                    .orElse(null);

            // If no kural with the given number is found, return 404
            if (foundKural == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "No Kural found with that number.");
            } else {
                writeJsonResponse(response, foundKural); // Write the found kural as JSON response
            }

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Kural number format.");
        }
    }

    // Utility method to write the JSON response
    private void writeJsonResponse(HttpServletResponse response, Object data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(data); // Convert the object to JSON string
        response.getWriter().write(jsonResponse); // Write the JSON string to the response
    }
}
