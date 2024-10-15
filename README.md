# Selenium Automation Project for Demo QA

This project is designed to automate several functionalities of the Demo QA website using Selenium WebDriver. The automation framework is built with scalability, reusability, and maintainability in mind, leveraging key testing concepts such as the Page Object Model (POM), TestNG, and data-driven testing with Excel integration.

## Key Features

### 1. Page Object Model (POM)
The framework follows the Page Object Model design pattern to ensure separation of concerns. Each web page is represented by a dedicated class, encapsulating its web elements and user interactions. This structure enhances the maintainability and reusability of the test code.

### 2. TestNG
TestNG is used as the test management framework for:
- Organizing and running test cases
- Managing test setup and teardown (`@BeforeMethod`, `@AfterMethod`)
- Parallel test execution
- Generating detailed test reports

### 3. Data-Driven Testing
The framework implements data-driven testing using TestNG’s `@DataProvider`. This allows tests to be executed with multiple sets of input data, improving test coverage and flexibility.

### 4. Excel Integration
For data-driven tests, test data is stored in Excel sheets. The **Apache POI** library is used to read and write data from Excel files, enabling dynamic test execution with various input data directly from the spreadsheet.

## Technologies and Tools

- **Selenium WebDriver**: Browser automation
- **Java**: Programming language
- **TestNG**: Test management and reporting
- **Apache POI**: For reading/writing Excel files
- **Page Object Model (POM)**: Framework design pattern for maintainability

## Automated Functionalities

- **Login functionality**: Automating login process using valid and invalid credentials
- **Form submission**: Filling out and submitting web forms
- **Element verification**: Asserting the presence and visibility of web elements


## Getting Started

### Prerequisites

- Java JDK
- Maven
- ChromeDriver or other WebDriver executables
- IDE (Eclipse, IntelliJ)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/selenium-demo-qa.git
2. Install dependencies using Maven:
   mvn install
3. Run tests with TestNG:
   mvn test
