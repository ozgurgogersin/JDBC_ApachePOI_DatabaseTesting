package JDBC.Receiving;
import Utilities.DBUtilities;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import static org.testng.AssertJUnit.assertEquals;

public class recieveDataFromDatabaseToExcel extends DBUtilities {
    @Test
    public void test() throws SQLException, IOException {

        ResultSet rs = statement.executeQuery("select * from city");
        ResultSetMetaData rsmd = rs.getMetaData();

        int columntCount = rs.getMetaData().getColumnCount();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("City");
        Row newRow = sheet.createRow(0);
        for (int i = 0; i < columntCount; i++) {
            Cell newCell = newRow.createCell(i);
            newCell.setCellValue(rsmd.getColumnName(i + 1));
        }
        int count = 1;
        while (rs.next()) {
            newRow = sheet.createRow(count);
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                Cell newCell = newRow.createCell(i);
                newCell.setCellValue(rs.getString(i + 1));
            }
            count++;
        }

        String newExcelPath = "src/test/java/ExcelFiles/Receiving/recievedData.xlsx";
        FileOutputStream outputStream = new FileOutputStream(newExcelPath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("recievedData.xlsx: Excel file with data of city table has been created.");

        //Assertion Example - No.1
        int actualColumnCount = rsmd.getColumnCount();
        int expectedColumnCount=5;
        assertEquals ("Expected column count", expectedColumnCount, actualColumnCount);

        //Assertion Example - No.2
        int expectedRowCount = count;
        int actualRowCount=sheet.getPhysicalNumberOfRows();
        System.out.println("expectedRowCount = " + expectedRowCount);
        System.out.println("actualRowCount = " + actualRowCount);
        assertEquals("Expected row count", expectedRowCount,actualRowCount );
    }
}
