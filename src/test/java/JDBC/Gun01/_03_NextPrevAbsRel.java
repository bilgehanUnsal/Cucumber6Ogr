package JDBC.Gun01;

import JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_NextPrevAbsRel extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from language");

        rs.next();
        System.out.println("1. Satır = " + rs.getString(2)); // 2. Column index değil - ing

        rs.next();
        System.out.println("1. Satır = " + rs.getString(2)); // 2. Column index değil - itl

        rs.previous(); // bir adım geri
        System.out.println("1. Satır = " + rs.getString(2)); // 2. Column index değil - ing
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from film");

        rs.absolute(10); // 10. satıra direkt git
        System.out.println("10. satırın title ı = " + rs.getString("title"));

        rs.absolute(5); // 5. satıra direkt git
        System.out.println("5. satırın title ı = " + rs.getString("title"));

        rs.relative(5); // en son neredeysen, oradan itibaren 5 git
        System.out.println("10. satırın title ı = " + rs.getString("title"));

        rs.next(); // 11 e gider
    }
    /*
    rs.next() : sonraki satır
    rs. previous() : önceki satır
    rs.absolute(10) : baştan itibaren 10. satıra gider
    rs.relative(10) : bulunduğu yerden 10 ileri gider
    rs.absolute(-10) : - (eksi) sondan demektir, sondan 10. satıra gider
    rs.relative(-10) : - (eksi) bulunduğu yerden 5 satır geri gider
     */
}
