package main;

//____________________________________________________________________________

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//____________________________________________________________________________

@WebServlet("/thirukural")
public class ThirukuralServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String FINAL_PATH = "path/to/thirukkural.json"; // Update with the actual path
	private List<Thirukural> thirukkuralList;

	public void init() throws ServletException {
		super.init();
		thirukkuralList = new ArrayList<>();
		try {
			byte[] jsonData = Files.readAllBytes(Paths.get(FINAL_PATH));
			ObjectMapper objectMapper = new ObjectMapper();
			thirukkuralList = objectMapper.readValue(jsonData, new TypeReference<List<Thirukural>>() {
			});
			System.out.println("Successfully loaded Thirukural data.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServletException("Error loading Thirukural JSON data. Please check the file path and format.", e);
		}
	}

//____________________________________________________________________________

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNumber = Integer.parseInt(request.getParameter("page"));
		int itemsPerPage = 12; // Number of items per page

		int startIndex = (pageNumber - 1) * itemsPerPage;
		int endIndex = Math.min(startIndex + itemsPerPage, thirukkuralList.size());

		List<Thirukural> responseList = thirukkuralList.subList(startIndex, endIndex);
		response.setContentType("thirukkural/json");
		response.getWriter().write(new ObjectMapper().writeValueAsString(responseList));
	}
}
