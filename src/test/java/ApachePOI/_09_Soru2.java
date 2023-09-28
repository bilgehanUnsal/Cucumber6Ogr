package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _09_Soru2 {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Carpim Tablosu");

        int satirIndex = 0;

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                Row row = sheet.createRow(satirIndex++);
                Cell cell1 = row.createCell(0); cell1.setCellValue(i);
                Cell cell2 = row.createCell(1); cell2.setCellValue("x");
                Cell cell3 = row.createCell(2); cell3.setCellValue(j);
                Cell cell4 = row.createCell(3); cell4.setCellValue("=");
                Cell cell5 = row.createCell(4); cell5.setCellValue(i*j);
            }
            Row freeRow = sheet.createRow(satirIndex++);
        }

        String path = "src/test/java/ApachePOI/resource/YeniExcel2.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
