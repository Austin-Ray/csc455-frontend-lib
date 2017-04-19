package com.csc;


import com.csc.model.Vehicle;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportWriter extends SqlInteractor {

  private final String selectAllTransport = "TransportSelectAll()";
  private final String updateMilage = "TransportUpdateMileage(?, ?)";
  private final String selectById = "TransportSelectByVehicleID(?)";
  private final String insert = "TransportInsert(?,?)";

  public TransportWriter(SqlDatabase db) {
    super(db);
  }

  public Vehicle getVehicleById(int vid) throws SQLException {
    Object[] parameters = { vid };
    CallableStatement statement = super.executeReadStatement(selectById, parameters);

    boolean hasResults = statement.execute();

    while (hasResults) {
      ResultSet rs = statement.getResultSet();

      while (rs.next()) {
        String vType = rs.getString(2);
        int mileage = rs.getInt(3);
        return new Vehicle(vid, vType, mileage);
      }
    }

    return null;
  }

  public List<Vehicle> getAllVehicles() throws SQLException {
    List<Vehicle> vehicles = new ArrayList<>();
    CallableStatement statement = super.executeReadStatement(selectAllTransport, new Object[]{});

    boolean hasResults = statement.execute();

    while (hasResults) {
      ResultSet rs = statement.getResultSet();

      while (rs.next()) {
        int vid = rs.getInt(1);
        String vType = rs.getString(2);
        int mileage = rs.getInt(3);

        vehicles.add(new Vehicle(vid, vType, mileage));
      }

      hasResults = statement.getMoreResults();
    }

    return vehicles;
  }

  public void insertVehicle(Vehicle vec) throws SQLException {
//    Object[] parameters = { vec.getType(), vec.getMileage() };

    String query = "INSERT INTO Transport (VehicleType, Mileage) values (?, ?)";
    PreparedStatement statement = db.getConnection().prepareStatement(query);
    statement.setString(1, vec.getType());
    statement.setInt(2, vec.getMileage());
    statement.execute();
    statement.close();
//    super.executeWriteStatement(insert, parameters);
  }

  public void updateMilage(int vid, int mileage) throws SQLException {
    Object[] parameters = { vid, mileage };
    super.executeWriteStatement(updateMilage, parameters);
  }
}
