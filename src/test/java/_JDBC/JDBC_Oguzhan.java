package _JDBC;

import org.testng.annotations.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;

public class JDBC_Oguzhan extends JDBCParent {


    @Test
    public void Test1() {

//        -- 5. Calculate the average salary of all employees with gender "F"
//                -- "Kadın" cinsiyetindeki tüm çalışanların ortalama maaşını hesapla.

        String sorgu = "select avg(salary) \n" +
                " as KadınCalisanMaasOrtalama ,gender from salaries\n" +
                "left join employees ON employees.emp_no=salaries.emp_no where gender='F' ;";

        try {
            DBConnectionOpen();

            List<List<String>> tablo = getListData(sorgu);
            assertFalse(tablo.isEmpty(), "Sorgunun İçi Boştur");
            for (List<String> satir : tablo) {
                for (String sutun : satir)
                    System.out.println(sutun + "\t");
                System.out.println();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose();
        }

    }

    @Test
    public void test2(){

//        -- 6. List all employees in the "Sales" department with a salary greater than 70,000.
//                -- Maaşı 70.000'den yüksek olan "Satış" departmanındaki tüm çalışanları listele.


        String sorgu = "select dept_name, salary, dept_emp.emp_no from employees\n" +
                "left join salaries On salaries.emp_no=employees.emp_no\n" +
                "left join dept_emp On dept_emp.emp_no=salaries.emp_no\n" +
                "left join departments On dept_emp.dept_no=departments.dept_no\n" +
                " where salary > 70000 and dept_name= 'Sales' order by salary LIMIT 20;";


        try {
            DBConnectionOpen();

            List<List<String>> tablo = getListData(sorgu);
            assertFalse(tablo.isEmpty(), "Sorgunun İçi Boştur");
            for (List<String> satir : tablo) {
                for (String sutun : satir)
                    System.out.println(sutun + "\t");
                System.out.println();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose();
        }



    }

    @Test
    public void test3(){

//       17  -- Her departmandaki en yüksek ortalama maaşa sahip çalışanları belirle. Departman adını,
//        -- çalışanın adını, soyadını ve ortalama maaşı listele. Sonuçları departmanlarına göre azalan şekilde
//                -- sırala, sadece kendi departmanlarında en yüksek ortalama maaşa sahip olanları göster.


        String sorgu = "select dept_name, max(salary), first_name, last_name, employees.emp_no from employees\n" +
                "left join salaries On salaries.emp_no=employees.emp_no\n" +
                "left join dept_emp On dept_emp.emp_no=salaries.emp_no\n" +
                "left join departments On dept_emp.dept_no=departments.dept_no\n" +
                "group by dept_name order by salary desc;";


        try {
            DBConnectionOpen();

            List<List<String>> tablo = getListData(sorgu);
            assertFalse(tablo.isEmpty(), "Sorgunun İçi Boştur");
            for (List<String> satir : tablo) {
                for (String sutun : satir)
                    System.out.println(sutun + "\t");
                System.out.println();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose();
        }



    }

    @Test
    public void test4(){

//        -- 18. List the names, last names, and hire dates in alphabetical order of all employees hired before
//        -- January 01, 1990.
//                -- 1990-01-01 tarihinden önce işe alınan tüm çalışanların adlarını, soyadlarını ve işe alınma
//                -- tarihlerini alfabetik sırayla listele.


        String sorgu = "select first_name, last_name, hire_date from employees\n" +
                "where hire_date < '1990-01-01' order by first_name;";


        try {
            DBConnectionOpen();

            List<List<String>> tablo = getListData(sorgu);
            assertFalse(tablo.isEmpty(), "Sorgunun İçi Boştur");
            for (List<String> satir : tablo) {
                for (String sutun : satir)
                    System.out.println(sutun + "\t");
                System.out.println();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose();
        }



    }

    @Test
    public void test5(){

//        -- 29. List all employees working in the "Sales" department with the title "Manager"
//                -- "Satış" bölümünde "Yönetici" unvanıyla çalışan tüm çalışanları listele


        String sorgu = "select\n " +
                "dept_name,\n" +
                " first_name,\n" +
                " last_name,\n" +
                " dept_manager.emp_no\n" +
                " as Manager from employees\n" +
                "left join dept_manager On dept_manager.emp_no=employees.emp_no\n" +
                "left join departments On departments.dept_no=dept_manager.dept_no\n" +
                " where dept_name = 'Sales' order by dept_manager.emp_no;";


        try {
            DBConnectionOpen();

            List<List<String>> tablo = getListData(sorgu);
            assertFalse(tablo.isEmpty(), "Sorgunun İçi Boştur");
            for (List<String> satir : tablo) {
                for (String sutun : satir)
                    System.out.println(sutun + "\t");
                System.out.println();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose();
        }



    }

    @Test
    public void test6(){

//        -- 30. Find the department where employee with '10102' has worked the longest
//        -- '10102' numaralı çalışanın en uzun süre çalıştığı departmanı bul


        String sorgu = "select\n" +
                " employees.emp_no,\n" +
                " dept_name,\n" +
                " from_date,\n" +
                " to_date from employees\n" +
                "left join dept_emp On dept_emp.emp_no=employees.emp_no\n" +
                "left join departments On departments.dept_no=dept_emp.dept_no\n" +
                " where employees.emp_no = '10102' and max(from_date - to_date);";


        try {
            DBConnectionOpen();

            List<List<String>> tablo = getListData(sorgu);
            assertFalse(tablo.isEmpty(), "Sorgunun İçi Boştur");
            for (List<String> satir : tablo) {
                for (String sutun : satir)
                    System.out.println(sutun + "\t");
                System.out.println();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose();
        }



    }

    @Test
    public void test7(){

//        -- 39. Sort employees by their birth dates
//        -- Çalışanları doğum tarihlerine göre sıralama


        String sorgu = "select first_name, last_name, birth_date from employees order by birth_date;";


        try {
            DBConnectionOpen();

            List<List<String>> tablo = getListData(sorgu);
            assertFalse(tablo.isEmpty(), "Sorgunun İçi Boştur");
            for (List<String> satir : tablo) {
                for (String sutun : satir)
                    System.out.println(sutun + "\t");
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



