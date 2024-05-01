package _JDBC;


import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;

public class JDBC_Mert extends JDBCParent {

    @Test
    public void Test1() {

      /*
      -- SORGU 3 :

      -- Calculate the average salary of all employees.
      -- Tüm çalışanların ortalama maaşını hesapla.

       */

        String sorgu =
                "select avg(salary) as CalisanOrtalamaMaas from salaries;";

        try {
            DBConnectionOpen();
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "The query is not empty.");
            for (List<String> satir : donenTablo) {
                for (String kolon : satir)
                    System.out.print(kolon + "\t");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose();
        }

    }

    @Test
    public void Test2() {

        /*
        -- SORGU 4 :

        -- Calculate the average salary of all employees with gender "M".
        -- "Erkek" cinsiyetindeki tüm çalışanların ortalama maaşını hesapla.
        */


        String sorgu = "select avg(salary) as ErkekCalisanMaasOrtalama ,gender from salaries\n" +
                "left join employees ON employees.emp_no=salaries.emp_no where gender='M' ;";


        try {
            DBConnectionOpen();
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "The query is not empty.");
            for (List<String> satir : donenTablo) {
                for (String kolon : satir)
                    System.out.print(kolon + "\t");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose();
        }
    }

    @Test
    public void Test3() {

        /*
-- SORGU 15 :
-- Find the employee with the highest salary in the Research Department
-- Araştırma Departmanındaki En Yüksek Maaşlı Çalışanı Bul.
         */
    }

    public List<List<String>> getListData(String sorgu) throws SQLException {
        List<List<String>> tablo = new ArrayList<>();

        ResultSet rs = sorguEkrani.executeQuery(sorgu);
        ResultSetMetaData rsmd = rs.getMetaData();

        ArrayList<String> kolonSatiri = new ArrayList<>();
        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            kolonSatiri.add(rsmd.getColumnName(i));
        tablo.add(kolonSatiri);

        int satirSayisi = 0; // İlk 10 satırı saymak için bir sayaç tanımlıyoruz
        while (rs.next() && satirSayisi < 20) { // İlk 20 satırı almak için döngüyü ayarlıyoruz
            ArrayList<String> satir = new ArrayList<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                satir.add(rs.getString(i));
            tablo.add(satir);
            satirSayisi++; // Her döngüde sayaçı arttırıyoruz
        }
        return tablo;
    }


}


