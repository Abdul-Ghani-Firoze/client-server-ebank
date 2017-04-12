/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebank_services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author AbdulGhani
 */
@WebService(serviceName = "EmployeeService")
public class EmployeeService {
    Connection c = null;
            
    @WebMethod(operationName = "createEmp")
    public void createEmp(@WebParam(name = "_name") String _name, 
            @WebParam(name = "pos") String pos, 
            @WebParam(name = "_uName") String _uName, 
            @WebParam(name = "pass") String pass) {
        Employee emp = new Employee(_name, pos, _uName, pass);
        insertEmp(emp);
    }
    
    @WebMethod(operationName = "deleteEmp")
    public void deleteEmp(@WebParam(name = "_uName") String  _uName) {
        delEmp(_uName);
    }
    
    @WebMethod(operationName = "editEmp")
    public void editEmp(@WebParam(name = "_name") String _name, 
            @WebParam(name = "pos") String pos, 
                @WebParam(name = "_uName") String _uName, 
                @WebParam(name = "pass") String pass) {
            updateEmp(_name, pos, _uName, pass);
    }
    
    //run this method from the client at the start of the application
    protected void initDB() {
      String jdbcDriver = "com.mysql.jdbc.Driver";
      String dbURL = "jdbc:mysql://localhost/";
      String dbUserId = "abc";
      String dbPassword = "123";
      c = null;
                
      try {    
        Class.forName(jdbcDriver);
      } catch (ClassNotFoundException exp) {
        System.err.println("Could not load the JDBC driver " + jdbcDriver);
        return;
      }
        
      try {
        c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);     
        c.close();
      } catch (SQLException sqlexp) {
        System.err.println("Failed to connect to the database.");
        System.err.println(sqlexp.getMessage());
      }
    }
    
    protected void insertEmp(Employee emp) {
        try {
          Statement s = c.createStatement();
          s.addBatch("INSERT INTO employee VALUES ('" + emp.getName() +"', '" +
                  emp.getPosition() + "', '" + emp.getuName() + "', '" 
                  + emp.getPassword() + "')");
          System.out.println("Insert successfull");
          } catch (SQLException sqlexp) {
            System.err.println("Failed to execute one of the statements.");
            System.err.println(sqlexp.getMessage());
        }
    }
    
    protected void delEmp(String _uName) {
          try {
          Statement s = c.createStatement();
          s.addBatch("DELETE FROM employee WHERE username = '" + _uName + "'");
          System.out.println("Deleted Succssfully");
          
          } catch (SQLException sqlexp) {
            System.err.println("Failed to execute one of the statements.");
            System.err.println(sqlexp.getMessage());
        }
    }
    
    protected void updateEmp(String _name, String pos, String _uName, String pass) {
        try {
            Statement s = c.createStatement();
            s.addBatch("UPDATE employee SET name = " + _name + ", position = "
                    + pos + ", username = " + _uName + ", pass = " + pass
                    + "WHERE username = '" + _uName + "'");
            System.out.println("updated Succssfully");

        } catch (SQLException sqlexp) {
            System.err.println("Failed to execute one of the statements.");
            System.err.println(sqlexp.getMessage());
        }
    }
}
