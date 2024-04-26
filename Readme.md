# JDBC Framework 
This project provides a framework for executing queries on MySQL database using JDBC (Java Database Connectivity) in Java. With this framework, you can connect to the database, send queries, and retrieve results.

# SQL Summary

This table provides an overview of contributors for each SQL number.

| SQL No.                  | Contributors           |
|--------------------------|------------------------|
| SQL-7-8-9-19-20-31-32-40 | Elcin Burak            |
| SQL-5-6-17-18-29-30-39   | Oğuzhan Aydın          |
| SQL-1-2-13-14-25-26-37   | Aslı Çelik             |
| SQL-3-4-15-16-27-28-38   | Mert Özmen             |
| SQL-11-12-23-24-35-36    | Ulvi Süleyman          |
| SQL-9-10-21-22-33-34-41  | Zehra Koroğlu          |

# Project Technologies and Tools

Technologies and tools used in this project:

- **TestNG** (${testng.version}): TestNG testing framework.
- **Cucumber-Java** (${cucumber.version}): Cucumber BDD (Behavior-Driven Development) framework.
- **Cucumber-TestNG** (${cucumber.version}): Cucumber for running tests with TestNG.
- **MySQL Connector/J** (${mysql.connector.version}): JDBC driver for interacting with MySQL database.

These tools have been used for testing purposes and interacting with the MySQL database in the project.

# Employees Schema
This README file contains various SQL queries for a sample `employees` schema. The queries can be adapted to your database schema and needs.
# Employees Schema

This README file contains various SQL queries for a sample employees schema. The queries can be adapted to your database schema and needs.

## MySQL Employee Structure

### Employees Table                    | ### Departments Table
| Column Name | Description           |   | Column Name | Description       |
|-------------|-----------------------|   |-------------|-------------------|
| emp_no      | Employee number       |   | dept_no     | Department number |
| first_name  | First name            |   | dept_name   | Department name   |
| last_name   | Last name             |   |             |                   |
| birth_date  | Birth date            |   |             |                   |
| gender      | Gender                |   |             |                   |
| hire_date   | Hire date             |   |             |                   |

### Dept_Manager Table               | ### Titles Table
| Column Name | Description           |   | Column Name | Description           |
|-------------|-----------------------|   |-------------|-----------------------|
| emp_no      | Employee number       |   | emp_no      | Employee number       |
| dept_no     | Department number     |   | title       | Job title             |
| from_date   | Start date of management | | from_date   | Start date of job title |
| to_date     | End date of management   | | to_date     | End date of job title   |

### Salaries Table
| Column Name | Description           |
|-------------|-----------------------|
| emp_no      | Employee number       |
| salary      | Salary                |
| from_date   | Start date of salary  |
| to_date     | End date of salary    |

[MySQL Employee Structure](https://dev.mysql.com/doc/employee/en/sakila-structure.html)

![employees-schema.png](src/main/resources/img/employees-schema.png)

