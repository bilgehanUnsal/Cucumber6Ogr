package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


/*
Mainden bir metod çağırmak süretiyle path i ve sheet name i verilen excelden istenilen sütun kadar veriyi okuyup
bir List e atınız.

 */
public class _11_Soru {
    public static void main(String[] args) throws IOException {


        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        String sheetName="testCitizen";
        int sutunSayisi=3;

        ArrayList<ArrayList<String>> veriler = getData(path, sheetName, sutunSayisi);
        System.out.println(veriler);

    }
    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int Sutun){
        ArrayList<ArrayList<String>> data = new ArrayList<>();

        Sheet sheet = null;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e){
            System.out.println("e = " + e.getMessage());
        }


        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            ArrayList<String> satir = new ArrayList<>();

            for (int j = 0; j < Sutun; j++) {
                satir.add(sheet.getRow(i).getCell(j).toString());
            }

            data.add(satir);

        }

        return data;
    }
}
