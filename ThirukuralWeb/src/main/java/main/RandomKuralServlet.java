package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RandomKuralServlet") // Ensure the servlet is correctly mapped
public class RandomKuralServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Thirukural> kuralList;

    @Override
    public void init() throws ServletException {
        InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/resources/thirukkural.json");
        if (inputStream == null) {
            throw new ServletException("Input stream is null, file not found.");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            kuralList = objectMapper.readValue(inputStream,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Thirukural.class));
        } catch (IOException e) {
            throw new ServletException("Failed to load Thirukkural data.", e);
        } finally {
            try {
                inputStream.close(); // Ensure InputStream is closed after usage
            } catch (IOException e) {
                e.printStackTrace(); // Log this issue, but don't throw it since it's in finally
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set content type to application/json to return JSON response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Check if the kuralList is properly initialized
        if (kuralList == null || kuralList.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"No Kurals available.\"}");
            return;
        }

        // Get a random Thirukkural
        int randomIndex = ThreadLocalRandom.current().nextInt(kuralList.size());
        Thirukural randomKural = kuralList.get(randomIndex);

        // Convert to JSON and send it in the response
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(randomKural);
        response.getWriter().write(jsonResponse);
    }
}
