package com.csc;

import com.csc.model.Employee;

import java.sql.SQLException;

public class EmployeeWriter extends UserWriter {

  private final String employeeInsert = "EmployeeInsert(?, ?, ?, ?, ?, ?)";

  public EmployeeWriter(SqlDatabase db) {
    super(db);
  }

  public void insertEmployee(Employee employee) throws SQLException {

    Object[] parameters = { employee.getLastName(), employee.getFirstName(), employee.getEmail(), employee.getPassword(),
                            employee.getRoleid(), employee.getVehicleType() };

    executeWriteStatement(employeeInsert, parameters);
  }
}
