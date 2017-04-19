package com.csc;

import com.csc.model.Order;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderWriter extends SqlInteractor {

  private final String orderByEmp = "OrderSelectAllHandledByEmployee(?)";
  private final String orderInsert = "OrderInsert(?,?,?,?,?)";
  private final String orderByDesto = "OrderSelectByDestination(?)";
  private final String orderByStatus = "OrderSelectByStatus(?)";
  private final String ordersByDatePlaced = "OrdersSelectByDatePlaced(?)";
  private final String ordersByDateShipped = "OrdersSelectByDateShipped(?)";
  private final String orderUpdateEid = "OrderUpdateEmployeeID(?,?)";
  private final String orderUpdateShipDate = "OrderUpdateShipDate(?,?)";
  private final String orderUpdateStatus = "OrderUpdateStatus(?, ?)";
  private final String customerOrder = "CustomerOrderHistory(?)";
  private final String parcelInsert = "ParcelInsert(?, ?, ?, ?, ?);";

  public OrderWriter(SqlDatabase db) {
    super(db);
  }

  public List<Order> allOrdersByEmployee(int eid) throws SQLException {
    Object[] parameters = { eid };
    return processResults(super.executeReadStatement(orderByEmp, parameters));
  }

  public List<Order> allOrdersByDestination(int dZip) throws SQLException {
    Object[] parameters = { dZip };
    return processResults(super.executeReadStatement(orderByDesto, parameters));
  }

  public List<Order> allOrdersByStatus(String status) throws SQLException {
    Object[] parameters = { status };
    return processResults(super.executeReadStatement(orderByStatus, parameters));
  }

  public List<Order> allOrdersByDatePlaced(Date date) throws SQLException {
    return allOrdersByDate(ordersByDatePlaced, date);
  }

  public List<Order> allOrdersByDateShipped(Date date) throws SQLException {
    return allOrdersByDate(ordersByDateShipped, date);
  }

  private List<Order> allOrdersByDate(String call, Date date) throws SQLException {
    Object[] parameters = { date };
    return processResults(super.executeReadStatement(orderByStatus, parameters));
  }

  public List<Order> allOrdersByCustomer(int cid) throws SQLException {
    Object[] parameters = { cid };
    CallableStatement statement = super.executeReadStatement(customerOrder, parameters);
    return processResults(statement);
  }

  public void parcelInsert(float weight, String size, float price, int quantity, int oid) throws SQLException {
    Object[] parameters = { weight, size, price, quantity, oid };
    super.executeWriteStatement(parcelInsert, parameters);
  }

  public void updateOrder(int eid, int oid) throws SQLException {
    Object[] parameters = { eid, oid };
    super.executeWriteStatement(orderUpdateEid, parameters);
  }

  public void updateOrderShipDate(int oid, Date date) throws SQLException {
    Object[] parameters = { date, oid };
    super.executeWriteStatement(orderUpdateShipDate, parameters);
  }

  public void setOrderUpdateStatus(int oid, String status) throws SQLException {
    Object[] parameters = { status, oid };
    super.executeWriteStatement(orderUpdateStatus, parameters);
  }

  public void insertOrder(int cid, int eid, int oZip, int aZip, int dZip) throws SQLException {
    Object[] parameters = { cid, eid, oZip, aZip, dZip };
    super.executeWriteStatement(orderInsert, parameters);
  }

  public int insertOrder(int cid, int oZip, int dZip) throws SQLException {
    Object[] parameters = { cid, -1, oZip, oZip, dZip };
    return super.executeWriteStatementWithReturn(orderInsert, parameters);
  }

  private List<Order> processResults(CallableStatement statement) throws SQLException {
    List<Order> orders = new ArrayList<>();
    boolean hasResults = statement.execute();

    while (hasResults) {
      ResultSet rs = statement.getResultSet();

      while (rs.next()) {
        int oid = rs.getInt("OrderID");
        int cid = rs.getInt("CustomerID");
        int eid = rs.getInt("EmployeeID");
        int oZip = rs.getInt("OriginZip");
        int aZip = rs.getInt("ActualZip");
        int dZip = rs.getInt("DestinationZip");
        String status = rs.getString("Status");
        Date rDate = rs.getDate("Received_Date");
        Date sDate = rs.getDate("Shipped_Date");

        orders.add(new Order(oid, cid, eid, oZip, aZip, dZip, status, rDate, sDate));
      }

      hasResults = statement.getMoreResults();
    }

    return orders;
  }
}
