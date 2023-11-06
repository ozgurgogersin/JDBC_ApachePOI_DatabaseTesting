# JDBC - Apache POI Database Test

This repository contains a Java project that demonstrates various data operations using JDBC (Java Database Connectivity) and Apache POI libraries. The project includes functionality for clearing Excel data, receiving data from a database to an Excel file, and sending data from an Excel file to a database.

## Powered by FreeSQLDatabase.com

To set up the database:
- I created a free database on [FreeSQLDatabase.com](https://www.freesqldatabase.com/).
- I established a "City" table within the database.
- The "City" table contains city information, which is used for data operations in the code.

This database functionality allows me to interact with the "City" table, retrieve data, and perform data operations using JDBC and Apache POI libraries.

## Sample Data from the "City" Table

Here is a sample of the data from the "City" table in the database. Please note that this table contains a total of 430 rows. Here, we are showing only 5 rows as a representative sample:

| ID | Name             | CountryCode | District       | Population |
| -- | ---------------- | ----------- | -------------- | ---------- |
| 1  | Kabul            | AFG         | Kabol          | 1,780,000  |
| 2  | Qandahar         | AFG         | Qandahar       | 237,500    |
| 3  | Herat            | AFG         | Herat          | 186,800    |
| 4  | Mazar-e-Sharif   | AFG         | Balkh          | 127,800    |
| 5  | Amsterdam        | NLD         | Noord-Holland  | 731,200    |

This table is a subset of the larger "City" table and provides a representative sample of the data used for data operations in the project.

## Table of Contents
- [Clear Received Excel Data](#clear-received-excel-data)
- [Receive Data from Database to Excel](#receive-data-from-database-to-excel)
- [Send Data from Excel File to Database](#send-data-from-excel-file-to-database)

## JDBC (Java Database Connectivity)

JDBC is a Java-based API that allows Java applications to interact with databases. It provides a standard interface for connecting to relational databases, executing SQL queries, and processing database results. In this project, I utilize JDBC to establish a connection to a database, retrieve data, and manipulate database records.

## Apache POI

Apache POI is a popular open-source library that provides Java APIs for working with various Microsoft document formats, including Excel spreadsheets (XLS and XLSX). In this project, I leverage Apache POI to read and write Excel files, enabling me to import data from a database into an Excel file and export data from an Excel file into a database.

## Assertions

The project includes assertions to validate the results of data operations. Assertions are critical for ensuring the integrity of data and the correctness of the program's functionality. I use assertions to confirm that the data imported from the database matches the data exported to an Excel file and vice versa. Assertions also help me check the number of rows in the database and compare specific values to expected values.

## Clear Received Excel Data

This part of the project clears the data in an Excel file.

### How to Use
1. Run the `clear_ReceivedExcelData.java` file.

## Receive Data from Database to Excel

This part of the project receives data from the "City" table in the database and writes it to an Excel file.

### How to Use
1. Run the `receiveDataFromDatabaseToExcel.java` file.

## Send Data from Excel File to Database

This part of the project sends data from an Excel file to the "employee" table in the database.

### How to Use
1. Run the `sendDataFromExcelFileToDatabase.java` file.

**Note:** Sensitive information such as database credentials has been hidden for privacy and security reasons. If you need the credentials or have any inquiries, please contact via[mail](mailto:ozgurgogersin@gmail.com).

Please ensure you have the necessary libraries and database connection configured before running the code.

If you have any questions or need further information, feel free to reach out.
