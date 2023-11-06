package JDBC.Sending;

import Utilities.DBUtilities;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class sendDatafromExcelFileToDatabase extends DBUtilities {
    @Test
    public void test() throws IOException, SQLException {
        String path = "src/test/java/ExcelFiles/Sending/NewEmployeeTable.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        String sql = "insert into newEmployee (id, first_name, last_name, birthday, email) values (?,?,?,?)";
        String deleteDB = "truncate employee";
        PreparedStatement ps = connection.prepareStatement(deleteDB);
        ps.executeUpdate(deleteDB);

        ResultSet rs = statement.executeQuery("select * from employee");
        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(i+"-"+rsmd.getColumnName(i)+"|");
            //I checked the table actual column names here.
        }


        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            //I checked the table alignment here.
            int id = (int) row.getCell(0).getNumericCellValue();
            String first_name = row.getCell(1).getStringCellValue();
            String last_name = row.getCell(2).getStringCellValue();
            String birthday = row.getCell(3).getStringCellValue();
            String email = row.getCell(4).getStringCellValue();
            System.out.println(id);
            sql = "insert into employee values('" + id + "','" + first_name + "','" + last_name + "','" + birthday + "','" + email + "')";
            ps.execute(sql);
            ps.execute("commit");

        }

        //Assertion Example - No.1
        int expectedRowCount = sheet.getPhysicalNumberOfRows() - 1; // subtract 1 for header
        ResultSet resultSet = statement.executeQuery("select count(*) from employee");
        int actualRowCount = 0;

        if (resultSet.next()) {
            actualRowCount = resultSet.getInt(1);
        }
        System.out.println(actualRowCount);
        Assert.assertEquals(actualRowCount, expectedRowCount, "Row count in the database should match the number of rows in the Excel file.");

        //Assertion Example - No.2
        int expectedId = 1;
        String expectedFirstName = "EmployeeName1";
        String expectedLastName = "EmployeeLastname1";

        ResultSet result = statement.executeQuery("select * from employee where id = " + expectedId);

        if (result.next()) {
            String actualFirstName = result.getString("first_name");
            String actualLastName = result.getString("last_name");

            Assert.assertEquals(actualFirstName, expectedFirstName, "First name doesn't match.");
            Assert.assertEquals(actualLastName, expectedLastName, "Last name doesn't match.");
        }
    }


}
