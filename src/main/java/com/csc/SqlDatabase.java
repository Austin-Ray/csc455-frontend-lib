package com.csc;

import com.csc.driver.LoadDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDatabase {

  private Connection conn;


  public SqlDatabase(String host, String db, String user, String password) throws SQLException {

    // Format the URL to create a proper URL
    String sqlUrl =
        String.format("jdbc:mysql://%s/%s?noAccessToProcedureBodies=true&user=%s&password=%s", host, db, user, password);

    // Load the com.csc.driver for the JDBC
    LoadDriver.load();

    // Create a connection to the database
    conn = DriverManager.getConnection(sqlUrl);
  }

  public Connection getConnection() {
    return conn;
  }
}
