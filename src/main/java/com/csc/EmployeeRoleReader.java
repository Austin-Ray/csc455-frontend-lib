package com.csc;

import com.csc.model.Employee;
import com.csc.model.EmployeeRole;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRoleReader extends SqlInteractor {
  public EmployeeRoleReader(SqlDatabase db) {
    super(db);
  }

  public List<EmployeeRole> readRoles() throws SQLException {
    List<EmployeeRole> list = new ArrayList<>();
    CallableStatement statement = db.getConnection()
        .prepareCall("SELECT * FROM EmployeeRole");

    boolean hasResults = statement.execute();

    if (hasResults) {
      ResultSet rs = statement.getResultSet();

      while (rs.next()) {
        int roleId = rs.getInt("RoleID");
        String desc = rs.getString("Description");
        list.add(new EmployeeRole(roleId, desc));
      }
    }

    return list;
  }
}
