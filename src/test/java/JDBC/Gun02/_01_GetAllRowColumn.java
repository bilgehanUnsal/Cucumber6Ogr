package JDBC.Gun02;

import JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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
}
