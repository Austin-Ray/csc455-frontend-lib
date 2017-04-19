package com.csc;

import javax.xml.transform.Result;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SqlInteractor {
  protected SqlDatabase db;

  protected SqlInteractor(SqlDatabase db) {
    this.db = db;
  }

  public CallableStatement insertParameters(CallableStatement statement,
                                            Object[] parameters) throws SQLException {

    for (int i = 0; i < parameters.length; i++) {
      int pos = i + 1;

      if (parameters[i] == null) {
        statement.setNull(pos, Types.INTEGER);
      }
      else if (parameters[i] instanceof String) {
        statement.setString(pos, (String) parameters[i]);
      } else if (parameters[i] instanceof Integer) {
        statement.setInt(pos, (Integer) parameters[i]);
      } else if (parameters[i] instanceof Float) {
        statement.setFloat(pos, (Float) parameters[i]);
      } else if (parameters[i] == null) {
        statement.setNull(pos, Types.INTEGER);
      }
    }

    return statement;
  }

  protected CallableStatement executeReadStatement(String call, Object[] parameters)
      throws SQLException {
    CallableStatement statement = db.getConnection().prepareCall(formatCall(call));
    statement = insertParameters(statement, parameters);
    return statement;
  }

  protected void executeWriteStatement(String call, Object[] parameters) throws SQLException {
    CallableStatement statement = db.getConnection().prepareCall(formatCall(call));
    statement = insertParameters(statement, parameters);
    statement.execute();
    statement.close();
  }

  public int executeWriteStatementWithReturn(String call, Object[] parameters) throws SQLException {
    CallableStatement statement = db.getConnection().prepareCall(call);
    statement = insertParameters(statement, parameters);
    statement.execute();

    int aik = -1;

    ResultSet rs = statement.getGeneratedKeys();

    while (rs.next()) {
      aik = rs.getInt(1);
    }

    return aik;
  }

  private String formatCall(String call) {
    return "{call " + call + "}";
  }
}
