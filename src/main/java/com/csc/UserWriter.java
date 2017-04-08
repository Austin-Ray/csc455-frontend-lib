package com.csc;

import java.sql.SQLException;

public class UserWriter extends SqlInteractor {

  private final static String deleteUser = "DeleteUser(?)";

  public UserWriter(SqlDatabase db) {
    super(db);
  }

  public void deleteUser(int uid) throws SQLException {
    Object[] parameters = {uid};
    super.executeWriteStatement(deleteUser, parameters);
  }
}
