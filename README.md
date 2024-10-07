# ThirukkuralApplication

Writing a good `README.md` file for your **Thirukkural Application (Kuralin Kural)** is essential to provide clear information about what your application does, how to use it, and how it works. Here's an example of what you could include:

---

# Kuralin Kural - Thirukkural Web Application

## Overview

**Kuralin Kural** is a web application designed to explore, navigate, and study the ancient Tamil literary work, **Thirukkural**, written by the poet and philosopher Thiruvalluvar. The app provides an intuitive way to browse, search, and discover individual Kurals (verses) either randomly or by using various filtering options like searching by chapter (Athigaram) or specific keywords.

The Thirukkural, a timeless masterpiece, covers various topics such as ethics, politics, love, and social justice. This application makes it easier for users to dive into these profound teachings and explore Kurals in an interactive manner.

---

## Features

1. **Random Kural**: 
   - Allows users to explore a random Thirukkural.
   - The Kural is fetched from a JSON file containing all 1330 verses.
   
2. **Search by Athigaram (Chapter)**:
   - Users can browse Thirukkural by Athigarams (Chapters), which are grouped into three main themes: Aram (Virtue), Porul (Wealth), and Inbam (Love).
   
3. **Search by Kural Number**:
   - Users can directly search for a Kural by its specific number, providing a quick way to find particular verses.
   
4. **Search by Keyword**:
   - A search feature that allows users to look for Kurals containing specific words or phrases.
   
5. **User-friendly Interface**:
   - Simple, clean, and minimalistic design that makes navigating the app easy and enjoyable.
   
---

## Tech Stack

**Backend**:
- Java Servlet-based architecture
- Uses **Jakarta Servlet API** for handling HTTP requests
- **Jackson** library for JSON parsing

**Frontend**:
- HTML, CSS, JavaScript
- AJAX (Asynchronous requests for fetching data without reloading the page)
- LocalStorage for storing and managing session-specific data

**Data**:
- The application uses a pre-loaded JSON file that contains all 1330 Thirukkural verses.

---

## Installation

To set up the Thirukkural application locally, follow these steps:

### Prerequisites
- Java Development Kit (JDK) installed (version 8 or later)
- Apache Tomcat (or any other compatible servlet container)
- Maven (for dependencies and build)
- Web browser for accessing the application

### Steps

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/thirukkural-app.git
   ```
   
2. **Build the application**:
   ```bash
   cd thirukkural-app
   mvn clean install
   ```

3. **Deploy to Tomcat**:
   - Copy the generated `.war` file from the `target/` directory to your Tomcat `webapps/` folder.
   - Start the Tomcat server.

4. **Access the application**:
   Open your browser and navigate to:
   ```
   http://localhost:8080/thirukkural-app/
   ```

---

## How to Use

1. **Homepage**: The homepage features a menu with options to:
   - Get a random Kural
   - Search by Athigaram (chapter)
   - Search for a Kural by its number
   - Search Kurals by keywords

2. **Random Kural**: Clicking the "Random Kural" button will display a random verse along with its translation and meaning.

3. **Search**:
   - Use the **Athigaram** button to explore Thirukkural chapters.
   - Use **Search by Number** if you already know the Kural's number.
   - Use **Search by Keyword** to find verses containing specific words or phrases.

4. **Back Navigation**: Use the 'Back' button to return to the main screen at any time.

---

## Example Code

Here’s an example of how the random Kural feature is implemented:

```java
private void random(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    if (kuralList == null || kuralList.isEmpty()) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.getWriter().write("{\"error\":\"No Kurals available.\"}");
        return;
    }

    int randomIndex = ThreadLocalRandom.current().nextInt(kuralList.size());
    Thirukural randomKural = kuralList.get(randomIndex);

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonResponse = objectMapper.writeValueAsString(randomKural);
    response.getWriter().write(jsonResponse);
}
```

---

## Contributing

We welcome contributions from the community. Here's how you can contribute:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/your-feature-name`).
3. Commit your changes (`git commit -m 'Add your message'`).
4. Push to the branch (`git push origin feature/your-feature-name`).
5. Open a pull request.

---

## Known Issues and Improvements

- **Search Functionality**: Improve the search feature by adding fuzzy matching or auto-complete suggestions.
- **Translations**: Add multiple language translations for each Kural.
- **Commentaries**: Future versions could include expert commentaries on each Kural for more in-depth understanding.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Contact

For any questions, suggestions, or feedback, feel free to contact us at:
- Email: your-email@example.com
- GitHub: [Your GitHub Profile](https://github.com/your-username)

---

By following this format, you’ll ensure that your `README.md` is comprehensive and helps other developers or users understand the purpose and functionality of your **Thirukkural Application (Kuralin Kural)**. It also encourages contributions and makes the installation process straightforward.
