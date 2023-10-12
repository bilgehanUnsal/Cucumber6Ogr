package JDBC.Gun01;

import JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _06_ToDo extends JDBCParent {
    // TODO : city tablosundaki tüm satırlardaki şehir isimlerini absolute ile yazdırınız
    // TODO : city tablosundaki tüm satırlardaki şehir isimlerini relative ile yazdırınız
    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from city");
        rs.last();
        int satir = rs.getRow();

        for (int i = 1; i <= satir; i++) {
            rs.absolute(i);
            System.out.println(rs.getString("city"));
        }
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from city");
        rs.last();
        int satir = rs.getRow();
        rs.absolute(0);

        for (int i = 1; i <= satir; i++) {
           rs.relative(1);
            System.out.println(rs.getString("city"));
        }
    }
}
