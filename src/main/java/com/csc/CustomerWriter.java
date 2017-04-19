package com.csc;

import com.csc.model.Customer;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerWriter extends UserWriter {
  private final static String insertCustomer = "CustomerInsert(?, ?, ?, ?, ?, ?, ?)";
  private final static String allCustomer = "CustomerSelectAll()";
  private final static String customerById = "CustomerSelectByID(?)";

  public CustomerWriter(SqlDatabase db) {
    super(db);
  }

  public List<Customer> getAllCustomers() throws SQLException {
    List<Customer> customers = new ArrayList<>();

    CallableStatement executedStatement = super.executeReadStatement(allCustomer, new Object[]{});

    boolean hasResults = executedStatement.execute();
    ResultSet rs;

    while (hasResults) {
      rs = executedStatement.getResultSet();

      while (rs != null && rs.next()) {
        int cid = rs.getInt(1);
        String address = rs.getString(2);
        int uid = rs.getInt(3);
        int zip = rs.getInt(4);
        String phone = rs.getString(5);
        String lastName = rs.getString(6);
        String firstName = rs.getString(7);
        String email = rs.getString(8);
        String ps = rs.getString(9);

        customers.add(new Customer(firstName, lastName, email, ps, uid, cid, address, zip, phone));
      }

      hasResults = executedStatement.getMoreResults();
    }

    return customers;
  }

  public Customer getCustomersByCid(int cid) throws SQLException {
    Customer customer = null;
    Object[] parameters = { cid };
    CallableStatement statement = super.executeReadStatement(customerById, parameters);

    boolean hasResults = statement.execute();

    while(hasResults) {
      ResultSet rs = statement.getResultSet();

      while (rs != null && rs.next()) {
        String address = rs.getString(2);
        int uid = rs.getInt(3);
        int zip = rs.getInt(4);
        String phone = rs.getString(5);
        String lastName = rs.getString(6);
        String firstName = rs.getString(7);
        String email = rs.getString(8);
        String ps = rs.getString(9);

        customer = new Customer(firstName, lastName, email, ps, uid, cid, address, zip, phone);
      }

      hasResults = statement.getMoreResults();
    }

    return customer;
  }

  public void insertCustomer(Customer customer) throws SQLException {

    Object[] parameters = { customer.getLastName(), customer.getFirstName(), customer.getEmail(), customer.getPassword(),
                            customer.getAddress(), customer.getZipcode(), customer.getPhone()};

    super.executeWriteStatement(insertCustomer, parameters);
  }

  public void updateCustomer(Customer c) {

  }
}
