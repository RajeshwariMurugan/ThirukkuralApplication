# ThirukkuralApplication

# Kuralin Kural - Thirukkural Web Application

**Kuralin Kural** is a web application designed to explore, navigate, and study the ancient Tamil literary work, **Thirukkural**, written by the poet and philosopher Thiruvalluvar. The app provides an intuitive way to browse, search, and discover individual Kurals (verses) either randomly or by using various filtering options like searching by chapter (Athigaram) or specific keywords.

The Thirukkural, a timeless masterpiece, covers various topics such as ethics, politics, love, and social justice. This application makes it easier for users to dive into these profound teachings and explore Kurals in an interactive manner.


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



## Known Issues and Improvements

- **Search Functionality**: Improve the search feature by adding fuzzy matching or auto-complete suggestions.
- **Translations**: Add multiple language translations for each Kural.
- **Commentaries**: Future versions could include expert commentaries on each Kural for more in-depth understanding.

## Contact

For any questions, suggestions, or feedback, feel free to contact us at:
- Email: rajeshwarimp1830@gmail.com
- GitHub: 

---

