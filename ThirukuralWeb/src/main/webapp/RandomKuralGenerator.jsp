<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kuralin Kural - Random Kural Screen</title>
    <style>
        @charset "UTF-8";

        body {
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            height: 100vh; /* Full viewport height */
        }

        /* Column for Thiruvalluvar picture */
        .image-column {
            flex: 1; /* Take up half the space */
            display: flex;
            justify-content: center;
            align-items: center;
            position: relative;
            overflow: hidden;
            background-color: #e0f7fa; /* Light blue background */
        }

        .thiruvalluvar-image {
            height: 100%; /* Full height */
            width: auto; /* Maintain aspect ratio */
            animation: fadeIn 3s; /* Animation */
        }

        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }

        /* Column for Kural input */
        .input-column {
            flex: 1; /* Take up half the space */
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 20px;
            background-color: #f4f4f4; /* Light background for contrast */
        }

        .input-title {
            font-size: 24px;
            margin-bottom: 20px;
            color: #283593; /* Color for title */
            font-weight: bold; /* Bold title */
        }

        .submit-button {
            background-color: #283593;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            margin: 10px 5px; /* Increased margin for better spacing */
            transition: background-color 0.3s;
            width: 100%; /* Make buttons full width */
            max-width: 300px; /* Set max width for buttons */
            font-size: 16px; /* Increased font size */
        }

        .submit-button:hover {
            background-color: #1a237e; /* Darker shade on hover */
        }

        .kural-display {
            margin-top: 20px;
            font-size: 20px;
            text-align: center;
            color: #333;
            padding: 10px; /* Add padding */
            border: 1px solid #ccc; /* Border for the display area */
            border-radius: 5px; /* Rounded corners */
            background-color: #ffffff; /* White background for contrast */
        }

        .error-message {
            color: red;
            margin-top: 10px;
        }

        /* Responsive styles */
        @media (max-width: 600px) {
            body {
                flex-direction: column; /* Stack columns on small screens */
            }

            .image-column, .input-column {
                flex: none;
                width: 100%; /* Full width on small screens */
                height: auto; /* Auto height */
            }

            .thiruvalluvar-image {
                height: auto; /* Auto height for image */
                max-width: 100%; /* Limit width to 100% */
            }
        }
    </style>
</head>
<body>
    <div class="image-column">
        <img src="https://d18x2uyjeekruj.cloudfront.net/wp-content/uploads/2021/01/th.jpg" alt="Thiruvalluvar" class="thiruvalluvar-image">
    </div>
	
    <div class="input-column">
        <form id="kural-form" action="random" method="post">
            <div class="input-title">Random Thirukural</div>
            <button id="submit-button" class="submit-button" type="button">Submit</button>
            <button class="submit-button" type="button" onclick="goBack()">Back</button>
            <div id="error-message" class="error-message" style="display:none;"></div> <!-- Error message -->
        </form>
    </div>

    <script>
        function goBack() {
            window.location.href = "Home.html"; // Change this to your actual home screen URL
        }

        async function fetchRandomKural() {
            try {
                const response = await fetch('RandomKuralServlet', { method: 'POST' }); // Ensure the correct servlet path
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const kural = await response.json();
                localStorage.removeItem('kuralDetails');
                localStorage.setItem('kuralDetails', JSON.stringify(kural));
                window.location.href = 'kural-display.html'; // Ensure this page exists
            } catch (error) {
                console.error('Error fetching random Kural:', error);
                displayError('Failed to fetch Kural. Please try again.'); // Show error in UI
            }
        }

        function displayError(message) {
            const errorMessageDiv = document.getElementById('error-message');
            errorMessageDiv.innerText = message;
            errorMessageDiv.style.display = 'block'; // Display the error message
        }

        // Fetch random Kural when Submit button is clicked
        document.getElementById('submit-button').onclick = function() {
            document.getElementById('error-message').style.display = 'none'; // Hide previous error message
            fetchRandomKural(); // Fetch and display random Kural
        };
    </script>
</body>
</html>
