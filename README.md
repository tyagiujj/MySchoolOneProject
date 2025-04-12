# MySchoolOne Web Automation Project 🏫

This project automates functional test cases for the **MySchoolOne** school management web application.  
Test cases are written using **Selenium WebDriver**, **Java**, and **TestNG**, following best practices in test automation.

## 🔧 Tech Stack

- 🧠 Java
- 🤖 Selenium WebDriver
- ✅ TestNG Framework
- 🧱 Maven (if used)
- 🌍 ChromeDriver
- 📋 Excel or Properties file for test data

## 🧪 Modules Automated

- 🔐 Login (valid & invalid credentials)
- 👨‍🎓 Student Record Access
- 📅 Attendance & Timetable Verification
- 🚪 Logout Functionality

## 📁 Project Structure
MySchoolOneProject/ │ ├── src/test/java/ │ ├── testcases/ │ │ ├── LoginTest.java │ │ ├── AttendanceTest.java │ │ └── FeePaymentTest.java │ │ │ ├── pages/ │ │ ├── LoginPage.java │ │ ├── DashboardPage.java │ │ └── FeePage.java │ │ │ ├── base/ │ │ └── BaseTest.java │ │ │ └── utilities/ │ ├── ExcelReader.java │ └── ConfigReader.java │ ├── testng.xml ├── pom.xml └── README.md

