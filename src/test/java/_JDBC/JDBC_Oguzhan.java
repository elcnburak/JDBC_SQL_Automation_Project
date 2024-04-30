package _JDBC;


import Utilities.DBUtility;
import org.testng.annotations.Test;
import java.sql.*;
import java.util.List;

public class JDBC_Oguzhan extends JDBCParent {

    @Test
    public void Test1 (){

//        -- 5. Calculate the average salary of all employees with gender "F"
//                -- "Kadın" cinsiyetindeki tüm çalışanların ortalama maaşını hesapla.

        String sorgu = "select avg(salary) \n" +
                " as KadınCalisanMaasOrtalama ,gender from salaries\n" +
                "left join employees ON employees.emp_no=salaries.emp_no where gender='F' ;";

        try {
            DBConnectionOpen();

            List<List<String>> tablo = getListData(sorgu);
            for (List<String> satir : tablo) {
                for (String sutun : satir)
                    System.out.println(sutun + "\n");
                System.out.println();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose();
        }

    }





























    }



