/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebank_services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author AbdulGhani
 */
@WebService(serviceName = "CustomerService")
public class CustomerService {

    List customers = new ArrayList();
    Connection c = null;

    @WebMethod(operationName = "createCust")
    public void createEmp(@WebParam(name = "_name") String _name,
            @WebParam(name = "_bDate") String _bDate,
            @WebParam(name = "_add") String _add,
            @WebParam(name = "_mob") String _mob,
            @WebParam(name = "_email") String _email,
            @WebParam(name = "_type") String _type,
            @WebParam(name = "_no") long _no,
            @WebParam(name = "_sortCode") String _sortCode,
            @WebParam(name = "_bal") double _bal,
            @WebParam(name = "_card") long _card) {

        Customer cust = new Customer(_name, _bDate, _add, _mob, _email);
        Account ac = new Account(_type, _no, _sortCode, _bal, _card);
        insertCust(cust, ac);

    }

    @WebMethod(operationName = "editCust")
    public void editCust(@WebParam(name = "_name") String _name,
            @WebParam(name = "_bDate") String _bDate,
            @WebParam(name = "_add") String _add,
            @WebParam(name = "_mob") String _mob,
            @WebParam(name = "_email") String _email,
            @WebParam(name = "_type") String _type,
            @WebParam(name = "_no") long _no,
            @WebParam(name = "_sortCode") String _sortCode,
            @WebParam(name = "_bal") double _bal,
            @WebParam(name = "_card") long _card) {

        updateCust(_name, _bDate, _add, _mob, _email, _type, _no, _sortCode, _bal, _card);

    }

    @WebMethod(operationName = "displayCustList")
    public List displayCustList() {
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM CUSTOMER");
            while (rs.next()) {
                String name = rs.getString("name");
                Long acNo = rs.getLong("accountNo");

                String details = name + " " + acNo;
                customers.add(details);
            }
        } catch (SQLException sqlexp) {
            System.err.println("Failed to execute one of the statements.");
            System.err.println(sqlexp.getMessage());
        }
        return customers;
    }

    protected void insertCust(Customer cust, Account ac) {
        try {
            Statement s = c.createStatement();
            s.addBatch("INSERT INTO customer VALUES ('" + cust.getName() + "', '"
                    + cust.getbDate() + "', '" + cust.getAdd() + "', '"
                    + cust.getMob() + "', '" + cust.getEmail() + "')");
            s.addBatch("INSERT INTO account VALUES ('" + ac.getAcType() + "', '"
                    + ac.getAcNo() + "', '" + ac.getSortCode() + "', '"
                    + ac.getBalance() + "', '" + ac.getCard());
            System.out.println("Insert successfull");
        } catch (SQLException sqlexp) {
            System.err.println("Failed to execute one of the statements.");
            System.err.println(sqlexp.getMessage());
        }
    }

    protected void delCust(String _mob) {
        try {
            Statement s = c.createStatement();
            s.addBatch("DELETE FROM customer WHERE mobile = '" + _mob + "'");
            s.addBatch("DELETE FROM account WHERE mobile = '" + _mob + "'");

            System.out.println("Deleted Succssfully");

        } catch (SQLException sqlexp) {
            System.err.println("Failed to execute one of the statements.");
            System.err.println(sqlexp.getMessage());
        }
    }

    protected void updateCust(String _name, String _bDate, String _add,
            String _mob, String _email, String _type, long _no, String _sortCode,
            double _bal, long _card) {
        try {
            Statement s = c.createStatement();
            s.addBatch("UPDATE customer SET name = " + _name + ", bdate = "
                    + _bDate + ", address = " + _add + ", mobile = " + _mob
                    + ", email = " + _email + "WHERE mobile = '" + _mob + "'");
            s.addBatch("UPDATE account SET actype = " + _type + ", acno = "
                    + _no + ", sortcode = " + _sortCode + ", bal = " + _bal
                    + ", card = " + _card);
            System.out.println("updated Succssfully");
        } catch (SQLException sqlexp) {
            System.err.println("Failed to execute one of the statements.");
            System.err.println(sqlexp.getMessage());
        }
    }
}
