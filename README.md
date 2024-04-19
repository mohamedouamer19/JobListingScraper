# JobListingScraper

JobListingScraper is a Java-based project that utilizes the Jsoup library to scrape and parse job listings from the `https://candidat.francetravail.fr` website. The project is structured around the principles of Object-Oriented Programming (OOP) and includes several classes each responsible for a specific functionality.

## Key Features

- **JobListingExtractor**: This class is responsible for sending HTTP requests to the website and extracting the HTML content of the page. It parses the HTML content to extract details of each job listing and encapsulates them into `JobListing` objects.

- **JobListingLocalHtmlParser**: This class is used to parse a local HTML file and extract job listings from it. It creates `JobListing` objects for each job listing found in the file.

- **JobPostingScraper**: This class is used to scrape detailed information about a specific job posting. It sends an HTTP request to the job posting's URL, extracts the HTML content, and parses it to create a `JobDetails` object.

- **JobListing and JobDetails**: These are data classes that encapsulate the details of a job listing and a job posting, respectively.

The project is built with Maven, which makes it easy to manage dependencies and build the project.

## How to Run

To run the project, you need to have Java and Maven installed on your machine. You can then clone the repository and run the `main` method in the `JobListingExtractor`, `JobListingLocalHtmlParser`, or `JobPostingScraper` class, depending on what you want to do.

Please note that this project is for educational purposes and should not be used to overload or spam the `https://candidat.francetravail.fr` website with requests. Always respect the website's robots.txt file and terms of service.
