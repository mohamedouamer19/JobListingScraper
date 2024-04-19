# JobListingScraper

JobListingScraper est un projet basé sur Java qui utilise la bibliothèque Jsoup pour extraire et analyser les offres d'emploi du site `https://candidat.francetravail.fr`. Le projet est structuré autour des principes de la Programmation Orientée Objet (POO) et comprend plusieurs classes, chacune responsable d'une fonctionnalité spécifique.

## Fonctionnalités clés

- **JobListingExtractor** : Cette classe est responsable de l'envoi de requêtes HTTP au site web et de l'extraction du contenu HTML de la page. Elle analyse le contenu HTML pour extraire les détails de chaque offre d'emploi et les encapsule dans des objets `JobListing`.

- **JobListingLocalHtmlParser** : Cette classe est utilisée pour analyser un fichier HTML local et en extraire les offres d'emploi. Elle crée des objets `JobListing` pour chaque offre d'emploi trouvée dans le fichier.

- **JobPostingScraper** : Cette classe est utilisée pour extraire des informations détaillées sur une offre d'emploi spécifique. Elle envoie une requête HTTP à l'URL de l'offre d'emploi, extrait le contenu HTML et l'analyse pour créer un objet `JobDetails`.

- **JobListing et JobDetails** : Ce sont des classes de données qui encapsulent les détails d'une offre d'emploi et d'une offre d'emploi, respectivement.

Le projet est construit avec Maven, ce qui facilite la gestion des dépendances et la construction du projet.

## Comment exécuter

Pour exécuter le projet, vous devez avoir Java et Maven installés sur votre machine. Vous pouvez ensuite cloner le dépôt et exécuter la méthode `main` dans la classe `JobListingExtractor`, `JobListingLocalHtmlParser`, ou `JobPostingScraper`, selon ce que vous voulez faire.

Veuillez noter que ce projet est à des fins éducatives et ne doit pas être utilisé pour surcharger ou spammer le site `https://candidat.francetravail.fr` avec des requêtes. Respectez toujours le fichier robots.txt du site et les conditions d'utilisation.

#Version En Anglais:
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
