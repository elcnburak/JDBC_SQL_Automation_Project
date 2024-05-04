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

        String sorgu = "select dept_emp.emp_no,max(salary),\n" +
                "departments.dept_name from departments \n" +
                "left join dept_emp ON departments.dept_no=dept_emp.dept_no\n" +
                "left join salaries ON salaries.emp_no=dept_emp.emp_no where dept_name='Research';";

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
    public void Test4() {
        /*
        -- SORGU 16 :
    -- For each department, identify the employee with the highest single salary ever recorded.
    -- List the department name, employee's first name, last name, and the peak salary amount.
    -- Order the results by the peak salary in descending order.
    -- Her departman için, kaydedilmiş en yüksek tek maaşı belirle.
    -- Departman adını, çalışanın adını,soyadını ve en yüksek maaş tutarını listele.
    -- Sonuçları en yüksek maaşa göre azalan şekilde sırala.
         */

        String sorgu = "select dept_name , first_name , last_name , max(salary) from departments\n" +
                "left join dept_emp ON dept_emp.dept_no=departments.dept_no\n" +
                "left join employees ON employees.emp_no=dept_emp.emp_no\n" +
                "left join salaries ON salaries.emp_no=employees.emp_no group by departments.dept_name\n" +
                "order by MAX(salary) desc;";

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
    public void Test5() {

        /*
        -- SORGU 27 : List all employees and managers in the D005 department.
        -- D005 bölümündeki tüm çalışanları ve yöneticileri listele.
         */

        String sorgu ="select departments.dept_no , first_name, last_name from departments\n" +
                "left join dept_emp ON dept_emp.dept_no=departments.dept_no\n" +
                "left join employees ON employees.emp_no=dept_emp.emp_no where departments.dept_no='d005';";

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
    public void Test6(){
        /*
        -- SORGU 28 : List all employees hired after '1994-02-24' and earning more than 50,000.
        -- '1994-02-24' tarihinden sonra işe alınan ve 50.000'den fazla kazanan tüm çalışanları listele.
         */

        String sorgu ="select hire_date , salary from employees \n" +
                "left join salaries ON salaries.emp_no=employees.emp_no\n" +
                "where hire_date>'1994-02-24' and salary>'50.000' \n" +
                "order by salary desc;";

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
    public void Test7(){

        /*
        -- SORGU 38 : Find the first and last names of managers in department 'D005'.
        -- 'D005' bölümündeki yöneticilerin adını ve soyadını bulma.
         */

        String sorgu ="select departments.dept_no, dept_manager.emp_no, first_name, last_name\n" +
                "from departments\n" +
                "left join dept_manager ON departments.dept_no=dept_manager.dept_no\n" +
                "left join employees ON employees.emp_no=dept_manager.emp_no \n" +
                "where departments.dept_no='d005';";

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

    public static List<List<String>> getListData(String sorgu) throws SQLException {
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


