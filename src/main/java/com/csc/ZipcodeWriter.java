package com.csc;

import com.csc.model.Zipcode;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZipcodeWriter extends SqlInteractor {
  private final String selectAllZip = "ZipCodeSelectAll()";
  private final String zipByZip = "ZipCodeSelectAllByZip(?)";
  private final String zipByCity = "ZipCodeSelectAllByCity(?)";

  public ZipcodeWriter(SqlDatabase db) {
    super(db);
  }

  public List<Zipcode> getAllZipcodes() throws SQLException {
    CallableStatement statement = super.executeReadStatement(selectAllZip, new Object[]{});
    return processResults(statement);
  }

  public List<Zipcode> getAllZipsByCity(String city) throws SQLException {
    Object[] parameters = { city };

    CallableStatement statement = super.executeReadStatement(zipByCity, parameters);

    return processResults(statement);
  }

  public List<Zipcode> getZipcodeByZip(int zip) throws SQLException {
    List<Zipcode> zipcodes = new ArrayList<>();
    Object[] parameters = { zip };

    CallableStatement statement = super.executeReadStatement(zipByZip, parameters);

    return processResults(statement);
  }

  private List<Zipcode> processResults(CallableStatement statement) throws SQLException {
    List<Zipcode> zipcodes = new ArrayList<>();

    boolean hasResults = statement.execute();

    while (hasResults) {
      ResultSet rs = statement.getResultSet();

      while (rs.next()) {
        int zipCode = rs.getInt(1);
        String city = rs.getString(2);

        zipcodes.add(new Zipcode(zipCode, city));
      }

      hasResults = statement.getMoreResults();
    }

    return zipcodes;
  }
}
