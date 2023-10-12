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
        System.out.println("1. Satır = " + rs.getString(2)); // 2. Column index değil

        rs.next();
        System.out.println("1. Satır = " + rs.getString(2)); // 2. Column index değil

        rs.previous();
        System.out.println("1. Satır = " + rs.getString(2)); // 2. Column index değil
    }
}
