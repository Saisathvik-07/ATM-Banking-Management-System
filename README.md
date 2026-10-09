# ATM Banking Management System

## Project Overview
The ATM Banking Management System is a desktop-based application developed using Core Java, Java Swing, JDBC, and MySQL. It simulates basic ATM operations and allows users to manage banking transactions through a graphical user interface.

## Features
- User Registration and Account Creation
- Login Authentication using Card Number and PIN
- Cash Deposit
- Cash Withdrawal
- Fast Cash Withdrawal
- Balance Enquiry
- Mini Statement
- PIN Change
- MySQL Database Connectivity

## Technologies Used
- **Programming Language:** Java
- **GUI:** Java Swing and AWT
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **JDBC Driver:** MySQL Connector/J
- **SQL Operations:** INSERT, SELECT, UPDATE

## Project Structure
- `Login.java` - User login
- `Conn.java` - Database connection
- `SignUpOne.java` - User registration
- `SignupTwo.java` - Additional user details
- `SignupThree.java` - Account details and card generation
- `Transactions.java` - Transaction menu
- `Deposit.java` - Deposit money
- `Withdrawl.java` - Withdraw money
- `FastCash.java` - Quick cash withdrawal
- `BalanceEnquiry.java` - Check account balance
- `MiniStatement.java` - View transaction history
- `PinChange.java` - Change account PIN

## Prerequisites
- Java Development Kit (JDK)
- MySQL Server
- MySQL Connector/J
- JCalendar library

## Database Setup
1. Install and start MySQL Server.
2. Create a database named `bankmanagementsystem`.
3. Create the required tables for registration, login, account details, and transactions.
4. Configure the database connection in `Conn.java`.
5. Add the required JDBC and JCalendar libraries.

## How to Run
1. Clone or download this repository.
2. Open the project in your preferred Java IDE.
3. Configure the MySQL database and required dependencies.
4. Run `Login.java` to start the application.

## Learning Outcomes
- Understanding Object-Oriented Programming in Java
- Building graphical interfaces using Java Swing
- Connecting Java applications to MySQL using JDBC
- Executing SQL queries from Java
- Implementing basic banking transaction workflows

## Author
Sai Sathvik
