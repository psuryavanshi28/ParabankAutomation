# 🧪 Parabank Full Stack Automation Framework

This is a **Full Stack Automation Project** built with self-learning and hands-on practice. It automates both **UI and API** flows of the [Parabank Application](https://parabank.parasoft.com/), with integration-ready structure for **CI/CD pipelines**. 
It covers 30+ test cases and demonstrates framework design, execution flow.

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
ParaBank Framework/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/         # BaseTest, BasePage, DriverFactory
│   │       ├── pages/        # LoginPage, TransferPage, etc.
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

  ### 🔹 API Automation (Mock Server)

- ✅ Login Endpoint (POST `/login`)
- 💸 Transfer Funds (POST `/transfer`)
- 📂 Get Account List (GET `/accounts`)

  All API endpoints are tested using a **Postman Mock Server**.

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

# ParaBank Automation

This repo contains:
- Selenium UI tests for ParaBank
- API automation tests using Rest Assured and Postman mock server

## Structure

- `ui/`: Selenium tests
- `api/`: API tests for Login, Transfer Funds, and Accounts
  

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
