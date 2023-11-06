package JDBC.Receiving;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class clear_ReceivedExcelData {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/ExcelFiles/Receiving/recievedData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("City");

        for (Row row : sheet) {
            for (Cell cell : row) {
                cell.setCellValue("");
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/java/ExcelFiles/Receiving/recievedData.xlsx");
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
        System.out.println("Recieved Excel Data Cleared");
    }
}
