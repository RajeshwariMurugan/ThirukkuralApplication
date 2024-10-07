package main;

//____________________________________________________________________________

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/Usernumber")
public class UserSelectNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Thirukural> kuralList;

//____________________________________________________________________________

	@Override
	public void init() throws ServletException {
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

	// ____________________________________________________________________________

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("/WEB-INF/resources/thirukkural.json");

		String kuralNumberParam = request.getParameter("kural-number");
		if (kuralNumberParam == null || kuralNumberParam.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Kural number is missing");
			return;
		}

		int kuralNumber = Integer.parseInt(kuralNumberParam);
		if (kuralNumber < 1 || kuralNumber > kuralList.size()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Kural number out of range");
			return;
		}

		Thirukural kural = kuralList.get(kuralNumber - 1);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = objectMapper.writeValueAsString(kural);
		response.getWriter().write(jsonResponse);
	}
}
