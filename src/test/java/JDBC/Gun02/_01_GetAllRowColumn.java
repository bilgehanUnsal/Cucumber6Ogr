package JDBC.Gun02;

import JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _01_GetAllRowColumn extends JDBCParent {
    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select city_id, city, country_id from city");

        rs.last();

        String id = rs.getString(1); // 1. kolon city_id
        System.out.println("id = " + id);

        // eğer field in tipi uyuyor ise ilgili dönüşüm ile alınabilir.
        int intID = rs.getInt(1);
        System.out.println("intID = " + intID);
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from city");

        ResultSetMetaData rsmd = rs.getMetaData(); // veri harici diğer bilgiler

        int columnCount = rsmd.getColumnCount();

        rs.next(); // ilk satıra gittim
        for (int i = 1; i < columnCount; i++) {
            System.out.println(rs.getString(i));
        }

        for (int i = 1; i < columnCount; i++) { // kolonların isimlerini ve tiplerini aldım
            System.out.println(rsmd.getColumnName(i) + "\t" + rsmd.getColumnTypeName(i));
        }
    }

    @Test
    public void test3() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            System.out.printf("%-20s", rsmd.getColumnName(i));
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-20s", rs.getString(i));
            }
            System.out.println();
        }
        // % : değişkenin değerini işaret eder
        // - : sola dayalı yazdırır, default sağa dayalı
        // 20: kaç hane kullanılacak herzaman onun bilgisi
        // s : string değerler içis , sayısal değerler için d kullanılır
        // "%5.2f" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane
    }

    @Test
    public void test4() throws SQLException {
        // bir metoda sorguyu("select * from language") gönderiniz,
        // metod size sorgunun datasını bir ArrayList olarak döndürsün

        String sorgu="select * from language";
        List<List<String>>  donenList =getListData(sorgu);
        System.out.println("donenList = " + donenList);
    }

    public List<List<String>> getListData(String sorgu){
        List<List<String>> tablo=new ArrayList<>();

        try {
            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd=rs.getMetaData();

            while (rs.next()) {
                List<String> satir=new ArrayList<>();
                for (int i = 1; i < rsmd.getColumnCount(); i++) {
                    satir.add(rs.getString(i));
                }

                tablo.add(satir);
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return tablo;
    }
}
