# Parabank Automation Framework

This is a real-world automation testing framework developed using **Selenium WebDriver**, **Java**, **TestNG**, and **Maven**, built on the **Page Object Model (POM)** design pattern.  
It covers 30+ test cases for the SauceDemo e-commerce site and demonstrates framework design, execution flow, reporting, and CI/CD integration.

---

## Tech Stack

- **Programming Language**: Java  
- **Automation Tool**: Selenium WebDriver  
- **Test Framework**: TestNG  
- **Build Tool**: Maven  
- **Design Pattern**: Page Object Model (POM)  
- **Reporting**: ExtentReports  
- **CI/CD Integration**: Jenkins  
- **Version Control**: Git & GitHub  

---

## Project Structure

```
SauceDemoAutomationFramework/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/         # BaseTest, BasePage, DriverFactory
│   │       ├── pages/        # LoginPage, InventoryPage, etc.
│   │       ├── utils/        # ScreenshotUtil, ConfigReader, WaitHelper
│   │       └── listeners/    # TestListener for ExtentReports & Screenshots
│   └── test/
│       └── java/
│           └── tests/        # LoginTest, AccountOpening etc
├── testng.xml                # TestNG suite file
├── pom.xml                   # Maven configuration
├── screenshots/              # Captured screenshots on test failure
└── README.md                 # Project documentation
```

---

## ✅ Features

- 🚀 30+ real-world automated test cases  
- 🔄 Modular Page Object Model (POM) structure  
- 📸 Screenshots on failure using TestNG listeners  
- 📊 ExtentReports for rich HTML reporting  
- ⚙️ Wait handling and reusable utility methods  
- 🧪 TestNG suite for execution control  
- 🔁 Ready for integration with Jenkins or GitHub Actions  

---

## ▶️ How to Run Locally

### Prerequisites

- Java 17+
- Maven
- Chrome browser

### Run All Tests

```bash
mvn clean test
```

---

## 🔄 Jenkins CI/CD Integration

This project supports Jenkins integration for continuous test execution.

### Jenkins Job Setup

1. Create a **Freestyle Project**
2. Configure **Git** under Source Code Management:  
   `https://github.com/psuryavanshi28/ParabankAutomation.git`  
3. In **Build > Execute shell**, use:

```bash
mvn clean test
```

4. Add post-build actions to archive:
   - HTML reports from `test-output/ExtentReports/`
   - Screenshots from `screenshots/` directory
