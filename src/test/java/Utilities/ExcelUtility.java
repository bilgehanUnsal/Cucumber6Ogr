package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtility {

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

    public static void writeInExcel(String path, Scenario scenario) {
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
            cell.setCellValue(scenario.getName());

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(scenario.getStatus().toString());
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
            cell.setCellValue(scenario.getName());

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(scenario.getStatus().toString());

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
