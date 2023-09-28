package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/*
Mainden bir metod çağırmak suretiyle, henüz oluşturulmamış
path i verilen bir excel için, program her çalıştıkça içine "Merhaba Dünya"
yazısını ekleyen metodu yazınız.
Dosya yoksa oluştur ilk satıra yaz, sonra dosya oluşacağı için
dosya varsa en son satırın altına yaz.
 */
public class _12_Soru {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/SenaryoSonuclari.xlsx";
        String bilgi = "test passed";

        writeInExcel(path, bilgi);
    }

    public static void writeInExcel(String path, String bilgi) {
        // dosya yok ise oluştur ilk satıra verilen bilgiyi yaz var ise, son satıra bilgiyi yaz
        FileInputStream inputStream = null;
        Workbook workbook = null;
        Sheet sheet = null;

        File file = new File(path);

        if (file.exists()) { // dosya var ise
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            } catch (IOException e) {
                System.out.println("e = " + e.getMessage());
            }

            Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());
            Cell cell = row.createCell(0);
            cell.setCellValue(bilgi);
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("e = " + e.getMessage());
            }


            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                System.out.println("e = " + e.getMessage());
            }

        } else {
            XSSFWorkbook workbook2 = new XSSFWorkbook();
            XSSFSheet sheet2 = workbook2.createSheet("Sayfa1");

            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue(bilgi);

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                System.out.println("e = " + e.getMessage());
            }
        }
    }
}
