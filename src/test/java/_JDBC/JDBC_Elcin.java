package _JDBC;

import org.testng.annotations.Test;
import java.sql.*;
import java.util.List;

import static org.testng.Assert.assertFalse;

public class JDBC_Elcin extends JDBCParent {

    @Test
    public void test1() { //-- This query retrieves employees who have salaries between 50000 and 100000.

        String sorgu = "SELECT * FROM employees INNER JOIN salaries ON employees.emp_no = salaries.emp_no WHERE salaries.salary BETWEEN 50000 AND 100000 LIMIT 20";

        try {
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
            for (List<String> satir : donenTablo) {
                for (String kolon : satir)
                    System.out.print(kolon + "\t");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void test2() {//-- List the names, last names, hire dates of all employees hired between January 01, 1985 and December 31, 1989, sorted by hire date.

        String sorgu = "SELECT departments.dept_name AS department, AVG(salaries.salary) AS average_salary FROM departments INNER JOIN dept_emp ON departments.dept_no = dept_emp.dept_no INNER JOIN salaries ON dept_emp.emp_no = salaries.emp_no GROUP BY departments.dept_name LIMIT 20";

        try {
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
            for (List<String> satir : donenTablo) {
                for (String kolon : satir)
                    System.out.print(kolon + "\t");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void test3() {//-- List the names, last names, hire dates, and salaries of all employees in the Sales department who were hired between January 01, 1985 and December 31, 1989, sorted by salary in descending order.

        String sorgu = "SELECT first_name, last_name, hire_date FROM employees WHERE hire_date BETWEEN '1985-01-01' AND '1989-12-31' ORDER BY hire_date LIMIT 20";

        try {
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
            for (List<String> satir : donenTablo) {
                for (String kolon : satir)
                    System.out.print(kolon + "\t");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void test4() {//-- List the names, last names, hire dates, and salaries of all employees in the Sales department who were hired between January 01, 1985 and December 31, 1989, sorted by salary in descending order.

        String sorgu = "SELECT employees.first_name, employees.last_name, employees.hire_date, salaries.salary FROM employees INNER JOIN dept_emp ON employees.emp_no = dept_emp.emp_no INNER JOIN salaries ON employees.emp_no = salaries.emp_no INNER JOIN departments ON dept_emp.dept_no = departments.dept_no WHERE employees.hire_date BETWEEN '1985-01-01' AND '1989-12-31' AND departments.dept_name = 'Sales' ORDER BY salaries.salary DESC LIMIT 20";

        try {
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
            for (List<String> satir : donenTablo) {
                for (String kolon : satir)
                    System.out.print(kolon + "\t");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void test5() {//-- Find the highest paid employee in department D004
        String sorgu = "SELECT employees.first_name, employees.last_name, salaries.salary FROM employees JOIN dept_emp ON employees.emp_no = dept_emp.emp_no JOIN salaries ON employees.emp_no = salaries.emp_no WHERE dept_emp.dept_no = 'D004' ORDER BY salaries.salary DESC LIMIT 1";

        try {
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
            for (List<String> satir : donenTablo) {
                for (String kolon : satir)
                    System.out.print(kolon + "\t");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void test6() {//-- Find the entire position history for employee with emp. no '10102'
        String sorgu = "SELECT employees.first_name, employees.last_name, titles.title, titles.from_date, titles.to_date FROM employees INNER JOIN titles ON employees.emp_no = titles.emp_no WHERE employees.emp_no = '10102' AND titles.from_date > employees.hire_date";

        try {
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
            for (List<String> satir : donenTablo) {
                for (String kolon : satir)
                    System.out.print(kolon + "\t");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void test7() {//-- Write a query to find the manager of each department along with their department name.

        String sorgu = "SELECT departments.dept_name, employees.first_name, employees.last_name FROM departments JOIN dept_manager ON departments.dept_no = dept_manager.dept_no JOIN employees ON dept_manager.emp_no = employees.emp_no";

        try {
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
            for (List<String> satir : donenTablo) {
                for (String kolon : satir)
                    System.out.print(kolon + "\t");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void test8() {//-- List employees hired in April 1992

        String sorgu = "SELECT * FROM employees WHERE hire_date BETWEEN '1992-04-01' AND '1992-04-30'";

        try {
            List<List<String>> donenTablo = getListData(sorgu);
            assertFalse(donenTablo.isEmpty(), "Sorgu sonucu boş olmamalıdır.");
            for (List<String> satir : donenTablo) {
                for (String kolon : satir)
                    System.out.print(kolon + "\t");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
