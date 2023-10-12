package JDBC.Gun01;

import JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_FirstLastGetRowgetType extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select city from city");

        rs.last(); // son satıra gider
        System.out.println("son şehrin adı = " + rs.getString(1));

        rs.first(); // ilk satıra gider
        System.out.println("ilk şehrin adı = " + rs.getString(1));

        rs.last();
        int kacinciSatir = rs.getRow(); // kaçıncı satırdayım
        System.out.println("kacinciSatir = " + kacinciSatir);
    }
}
