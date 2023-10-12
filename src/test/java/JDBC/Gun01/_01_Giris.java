package JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {
    @Test
    public void test1() throws SQLException {
        // bir sorgunun çalışması için yapılanlar
        String hostURL = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        // 1- bağlantı bilgilerini girdik : connection bilgileri set edildi.
        Connection baglanti = DriverManager.getConnection(hostURL, username, password);

        // 2- db seçtik : HostURL ye bu bilgi eklendi.

        // 3- sorgu ekranını açtık
        Statement sorguEkrani = baglanti.createStatement();

        // 4- Sorgu ekranına sorguyu yazdım, çalıştırdım
        ResultSet sonucTablosu = sorguEkrani.executeQuery("select * from customer");

        // 5- alttta sonuçlar gözüktü
        sonucTablosu.next(); // şu anda ilk satıra geldim

        String ad = sonucTablosu.getString("first_name");
        String soyad = sonucTablosu.getString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        sonucTablosu.next(); // 2. satıra gittim

        ad = sonucTablosu.getString("first_name");
        soyad = sonucTablosu.getString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);


        baglanti.close();
    }
}
