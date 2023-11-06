package Utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtilities {
    protected Connection connection;
    protected static Statement statement;

    @BeforeTest
    public void DBConnectionCreate() {

        String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11658042";
        // Sensitive information has been hidden for privacy reasons.
        String username = "*******";//Username
        String password = "*******";//Password

        try {

            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    @AfterTest
    public void DBConnectionClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    public List<List<String>> getData(String query) {
        List<List<String>> table = new ArrayList<>();
        DBConnectionCreate();
        ResultSet rs;

        try {
            rs = statement.executeQuery(query);

            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 0; i < columnCount; i++) {
                    String columnValue = rs.getString(i);
                    row.add(columnValue);
                }
                table.add(row);
            }
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        DBConnectionClose();
        return table;
    }


}


