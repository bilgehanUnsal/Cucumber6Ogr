package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        FileInputStream inputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // çalışma sayfasındaki fiziksel kullanılan toplam satır sayısını veriyor.
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount; i++) { // satır sayısı
            // şimdi burada her bir satırın kaç hücresi var onu bulup ona kadar
            // hücreleri alacağım

            Row row = sheet.getRow(i);
            int cellCount = row.getPhysicalNumberOfCells(); // sütun sayisi

            for (int j = 0; j < cellCount; j++) { // zoo[i].length
                Cell cell = row.getCell(j); // j sütun
                System.out.println(cell + "\t");
            }
            System.out.println();
        }

        System.out.println("****************************");

        // 2.yol
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                System.out.println(sheet.getRow(i).getCell(j) + "\t");
            }
            System.out.println();
        }
    }
}
