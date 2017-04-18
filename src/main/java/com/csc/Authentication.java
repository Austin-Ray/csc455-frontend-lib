package com.csc;

import com.csc.model.Customer;
import com.csc.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class Authentication {

  private CustomerWriter cWriter;
  private EmployeeWriter eWriter;

  public Authentication(SqlDatabase db) {
    cWriter = new CustomerWriter(db);
    eWriter = new EmployeeWriter(db);
  }

  public Object logIn(String username, String password) {
    try {
      List<Customer> customerList = cWriter.getAllCustomers();
      List<Employee> employeeList = eWriter.getAllEmployees();

      List<Customer> rs = customerList.stream()
          .filter(e -> e.getEmail().equalsIgnoreCase(username)
              && e.getPassword().equalsIgnoreCase(password))
          .collect(Collectors.toList());

      List<Employee> ers = employeeList.stream()
          .filter(e -> e.getEmail().equalsIgnoreCase(username)
              && e.getPassword().equalsIgnoreCase(password))
          .collect(Collectors.toList());

      if (rs.size() >= 1) {
        return rs.get(0);
      } else if (ers.size() >= 1) {
        return ers.get(0);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
