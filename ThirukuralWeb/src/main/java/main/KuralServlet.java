package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/KuralServlet")
public class KuralServlet extends jakarta.servlet.http.HttpServlet {

    // Example data for demonstration
    ArrayList<Thirukural> kuralList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
    	InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/resources/thirukkural.json");
		if (inputStream == null) {
			throw new IllegalArgumentException("Input stream is null, file not found.");
		}

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			kuralList = objectMapper.readValue(inputStream,
					objectMapper.getTypeFactory().constructCollectionType(List.class, Thirukural.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adikaram = request.getParameter("adikaram");
        int adikaramIndex = Integer.parseInt(adikaram);

        // Get the Kurals for the selected Adikaram
        ArrayList<Thirukural> kuralsForAdikaram = new ArrayList<>();
        for (int i = adikaramIndex * 10; i < (adikaramIndex * 10) + 10 && i < kuralList.size(); i++) {
            kuralsForAdikaram.add(kuralList.get(i));
        }

        // Convert the list to JSON and return it
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(kuralsForAdikaram);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }

}

