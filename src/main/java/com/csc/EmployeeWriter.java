package com.csc;

import com.csc.model.Employee;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeWriter extends UserWriter {

  private final String employeeInsert = "EmployeeInsert(?, ?, ?, ?, ?, ?)";

  public EmployeeWriter(SqlDatabase db) {
    super(db);
  }

  public void insertEmployee(Employee employee) throws SQLException {

    Object[] parameters = { employee.getLastName(), employee.getFirstName(), employee.getEmail(),
        employee.getPassword(), employee.getRoleid(), employee.getVehicleType() };

    executeWriteStatement(employeeInsert, parameters);
  }

  public List<Employee> getAllEmployees() throws SQLException {
    List<Employee> list = new ArrayList<>();
    CallableStatement statement = db.getConnection()
        .prepareCall("SELECT * FROM Employees NATURAL JOIN Users;");

    boolean hasResults = statement.execute();

    if (hasResults) {
      ResultSet rs = statement.getResultSet();

      while (rs.next()) {
        int uid = rs.getInt("UserID");
        int eid = rs.getInt("EmployeeID");
        int roleId = rs.getInt("RoleID");
        String vehicleType = rs.getString("VehicleType");
        String lastName = rs.getString("LastName");
        String firstName = rs.getString("FirstName");
        String email = rs.getString("Email");
        String password = rs.getString("password");

        list.add(new Employee(firstName, lastName, email, password, uid, roleId, vehicleType,eid));
      }
    }

    return list;
  }
}
