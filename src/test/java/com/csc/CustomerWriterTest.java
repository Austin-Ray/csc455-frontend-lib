package com.csc;

import com.csc.model.Customer;
import csc455.BuildConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerWriterTest {
/*
  private SqlDatabase  db;
  private CustomerWriter writer;

  @Before
  public void setup() throws SQLException {
    db = new SqlDatabase(BuildConfig.MY_SQL_URL, BuildConfig.MY_SQL_DB,BuildConfig.MY_SQL_USER,
        BuildConfig.MY_SQL_PS);

    writer = new CustomerWriter(db);
  }

  @Test
  public void getAllCustomers() throws Exception {
    nukeTable();

    insertTestUser();
    List<Customer> list = new ArrayList<>(writer.getAllCustomers());
    assertEquals(1, list.size());
  }

  @Test
  public void insertCustomer() throws Exception {
    nukeTable();

    insertTestUser();
    List<Customer> list = writer.getAllCustomers();
    assertEquals(1, list.size());
  }

  @Test
  public void getCustomersByCid() throws Exception {
    nukeTable();
    insertTestUser();

    List<Customer> all = writer.getAllCustomers();

    all.forEach((Customer e) -> {
      Customer test = null;
      try {
        test = writer.getCustomersByCid(e.getCid());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      assertNotNull(e);
      assert test != null;
      assertEquals(e.getCid(), test.getCid());
    });
  }

  private void insertTestUser() throws SQLException {
    writer.insertCustomer(new Customer("Austin", "Ray", "TET",
        "TEST", "TEST", 28403, "9196067886"));
  }

  private void nukeTable() throws SQLException {
    List<Customer> list = writer.getAllCustomers();
    list.forEach(e -> {
      try {
        writer.deleteUser(e.getUid());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    });
  }*/
}