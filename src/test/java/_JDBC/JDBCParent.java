package _JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCParent {

    public static Connection baglanti;
    public static Statement sorguEkrani;

    // Veritabanına bağlantıyı açan metod
    public static void DBConnectionOpen() {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/employees";
        String kullaniciAdi = "root";
        String sifre = "'\"-LhCB'.%k[4S]z";

        try {
            baglanti = DriverManager.getConnection(url, kullaniciAdi, sifre);
            sorguEkrani = baglanti.createStatement();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    // Veritabanı bağlantısını kapatan metod
    public static void DBConnectionClose() {
        try {
            baglanti.close();
        } catch (SQLException e) {
            System.out.println("ex.getMessage() = " + e.getMessage());
        }
    }

    public static List<List<String>> getListData(String sorgu) throws SQLException {
        List<List<String>> tablo = new ArrayList<>();

        try {
            DBConnectionOpen();
            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd = rs.getMetaData(); // sütun sayısı

            // Sütun isimlerini tablonun ilk satırına ekler
            ArrayList<String> kolonSatiri = new ArrayList<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                kolonSatiri.add(rsmd.getColumnName(i));
            tablo.add(kolonSatiri);

            while (rs.next()) {

                ArrayList<String> satir = new ArrayList<>();
                // Bu satırdaki elemanları satır listesine ekler
                // rs.getString(1); // 1. sütun
                // rs.getString(2); // 2. sütun
                for (int i = 1; i <= rsmd.getColumnCount(); i++)
                    satir.add(rs.getString(i));

                // Satıra ekleme bittiğinde tabloya ekler
                tablo.add(satir);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose();  // Hata olsa da olmasa da bağlantıyı kapatır
        }

        return tablo;
    }
}
