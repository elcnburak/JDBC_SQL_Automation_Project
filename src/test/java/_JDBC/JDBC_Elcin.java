package _JDBC;

import org.testng.annotations.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;

public class JDBC_Elcin extends JDBCParent {

    @Test
    public void Test1() { //-- This query retrieves employees who have salaries between 50000 and 100000.

        String sorgu = "SELECT *\n" +
                "FROM employees\n" +
                "INNER JOIN salaries ON employees.emp_no = salaries.emp_no\n" +
                "WHERE salaries.salary BETWEEN 50000 AND 100000\n" +
                "LIMIT 20;"; // Sorguya LIMIT ekleyerek sadece ilk 20 satırı alıyoruz

        try {
            DBConnectionOpen();
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
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
    public void Test2() {//-- List the names, last names, hire dates of all employees hired between January 01, 1985 and December 31, 1989, sorted by hire date.

        String sorgu = "SELECT " +
                "departments.dept_name AS department, " +
                "AVG(salaries.salary) AS average_salary " +
                "FROM " +
                "departments " +
                "INNER JOIN dept_emp ON departments.dept_no = dept_emp.dept_no " +
                "INNER JOIN salaries ON dept_emp.emp_no = salaries.emp_no " +
                "GROUP BY " +
                "departments.dept_name " +
                "LIMIT 20;";
        try {
            DBConnectionOpen();
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
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
    public void Test3() {//-- List the names, last names, hire dates, and salaries of all employees in the Sales department who were hired between January 01, 1985 and December 31, 1989, sorted by salary in descending order.

        String sorgu = "SELECT \n" +
                "    first_name,\n" +
                "    last_name,\n" +
                "    hire_date\n" +
                "FROM \n" +
                "    employees\n" +
                "WHERE \n" +
                "    hire_date BETWEEN '1985-01-01' AND '1989-12-31'\n" +
                "ORDER BY \n" +
                "    hire_date\n" +
                "LIMIT 20;";
        try {
            DBConnectionOpen();
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
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
    public void Test4() {//-- List the names, last names, hire dates, and salaries of all employees in the Sales department who were hired between January 01, 1985 and December 31, 1989, sorted by salary in descending order.

        String sorgu = "SELECT \n" +
                "    employees.first_name, \n" +
                "    employees.last_name, \n" +
                "    employees.hire_date, \n" +
                "    salaries.salary \n" +
                "FROM \n" +
                "    employees \n" +
                "INNER JOIN \n" +
                "    dept_emp ON employees.emp_no = dept_emp.emp_no \n" +
                "INNER JOIN \n" +
                "    salaries ON employees.emp_no = salaries.emp_no \n" +
                "INNER JOIN \n" +
                "    departments ON dept_emp.dept_no = departments.dept_no \n" +
                "WHERE \n" +
                "    employees.hire_date BETWEEN '1985-01-01' AND '1989-12-31' \n" +
                "    AND departments.dept_name = 'Sales' \n" +
                "ORDER BY \n" +
                "    salaries.salary DESC \n" +
                "LIMIT 20;\n";
        try {
            DBConnectionOpen();
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
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
    public void Test5() {//-- Find the highest paid employee in department D004
        String sorgu = "SELECT \n" +
                "    employees.first_name,\n" +
                "    employees.last_name,\n" +
                "    salaries.salary\n" +
                "FROM \n" +
                "    employees\n" +
                "JOIN \n" +
                "    dept_emp ON employees.emp_no = dept_emp.emp_no\n" +
                "JOIN \n" +
                "    salaries ON employees.emp_no = salaries.emp_no\n" +
                "WHERE \n" +
                "    dept_emp.dept_no = 'D004'\n" +
                "ORDER BY \n" +
                "    salaries.salary DESC\n" +
                "LIMIT 1;";
        try {
            DBConnectionOpen();
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
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
    public void Test6() {//-- Find the entire position history for employee with emp. no '10102'
        String sorgu = "SELECT \n" +
                "    employees.first_name,\n" +
                "    employees.last_name,\n" +
                "    titles.title,\n" +
                "    titles.from_date,\n" +
                "    titles.to_date\n" +
                "FROM \n" +
                "    employees\n" +
                "INNER JOIN \n" +
                "    titles ON employees.emp_no = titles.emp_no\n" +
                "WHERE \n" +
                "    employees.emp_no = '10102'\n" +
                "    AND titles.from_date > employees.hire_date;";
        try {
            DBConnectionOpen();
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
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
    public void Test8() {//-- List employees hired in April 1992

        String sorgu = "SELECT *\n" +
                "FROM employees\n" +
                "WHERE hire_date BETWEEN '1992-04-01' AND '1992-04-30';";
        try {
            DBConnectionOpen();
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
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

