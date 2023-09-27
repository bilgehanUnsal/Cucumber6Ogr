package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInTheExcel {
    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";

        FileInputStream inputStream = new FileInputStream(path); // okuma yönüne açıldı
        Workbook workbook = WorkbookFactory.create(inputStream); // hafızaya kopyası oluşturuldu
        Sheet sheet = workbook.getSheetAt(0);

        // hafızada yazma işlemine başlıyorum
        int sonSatirIndex = sheet.getPhysicalNumberOfRows();
        Row yeniSatir = sheet.createRow(sonSatirIndex);
        Cell yeniHucre = yeniSatir.createCell(0); // ilk hücre oluşturuldu
        yeniHucre.setCellValue("Merhaba Dünya");
        // yazma işim bitti
        // okuma kanalını kapat
        inputStream.close();

        // dosyaya kaydetmeye geçiyorum
        // bunun için dosyayı yazma yönünde aç
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("İşlem bitti...");


    }
}
