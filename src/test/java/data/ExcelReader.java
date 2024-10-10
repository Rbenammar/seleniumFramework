package data;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream fis = null;

    public static FileInputStream getFisInputStream() {

        String filepath = System.getProperty("user.dir") + "/src/test/java/data/UserData4.xlsx";
        File srcFile = new File(filepath);
        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found.Terminating Process !! : Check file path of Test Data");
            System.exit(0);
        }
        return fis;
    }

    public Object[][] getExcelData() {
        fis = getFisInputStream();
        try {
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            int totalNumberOfRows = sheet.getLastRowNum() + 1;
            int totalNumberOfCols = 5; // Update to match the actual column count
            Object[][] arrayExcelData = new Object[totalNumberOfRows][totalNumberOfCols];
            // Formats cells as Strings
            DataFormatter formatter = new DataFormatter();

            for (int i = 0; i < totalNumberOfRows; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < totalNumberOfCols; j++) {
                    if (row != null && row.getCell(j) != null) {
                        arrayExcelData[i][j] = formatter.formatCellValue(row.getCell(j)); // Ensures string formatting
                    } else {
                        arrayExcelData[i][j] = ""; // Fill empty cells with an empty string
                    }
                }
            }
            wb.close();
            return arrayExcelData;

        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + e.getMessage());
        }
    }
}
