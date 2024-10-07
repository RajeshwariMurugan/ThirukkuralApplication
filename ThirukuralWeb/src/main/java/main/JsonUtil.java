package main;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class JsonUtil {

	private static String FINAL_PATH = "C:\\Users\\Raji\\eclipse-workspace\\ThirukuralManagementSystem\\src\\resources\\thirukkural.json";

	private static List<Thirukural> thirukuralList;
	public static List<Thirukural> loadThirukkuralData() {

		try {

			byte[] objectsjson = Files.readAllBytes(Paths.get(FINAL_PATH));
			ObjectMapper objectMapper = new ObjectMapper();

			thirukuralList = objectMapper.readValue(objectsjson, new TypeReference<List<Thirukural>>() {});

			if (thirukuralList != null && !thirukuralList.isEmpty()) {
				System.out.println("Successfully loaded Thirukkural data.");

				return thirukuralList;
			} else {
				System.err.println("No quotes found in the JSON file.");
				return null;
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error reading or parsing the JSON file: " + e.getMessage());
			return null;
		}
	}
}

	