package com.bridgelabz.repository;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.exception.DatabaseException;
import com.bridgelabz.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementDatabaseRepository implements IQuantityMeasurementRepository {

    @Override
    public void save(QuantityMeasurementEntity entity) {

        String sql = "INSERT INTO quantity_measurement(value, unit, operation, result) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, entity.getValue());
            ps.setString(2, entity.getUnit());
            ps.setString(3, entity.getOperation());
            ps.setDouble(4, entity.getResult());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new DatabaseException("Save failed", e);
        }
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {

        List<QuantityMeasurementEntity> list = new ArrayList<>();

        String sql = "SELECT * FROM quantity_measurement";

        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new QuantityMeasurementEntity(
                        rs.getDouble("value"),
                        rs.getString("unit"),
                        rs.getString("operation"),
                        rs.getDouble("result")
                ));
            }

        } catch (Exception e) {
            throw new DatabaseException("Fetch failed", e);
        }

        return list;
    }

    @Override
    public void deleteAll() {

        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("DELETE FROM quantity_measurement");

        } catch (Exception e) {
            throw new DatabaseException("Delete failed", e);
        }
    }

    @Override
    public List<QuantityMeasurementEntity> findByOperation(String operation) {

        List<QuantityMeasurementEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM quantity_measurement WHERE operation=?";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, operation);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new QuantityMeasurementEntity(
                        rs.getDouble("value"),
                        rs.getString("unit"),
                        rs.getString("operation"),
                        rs.getDouble("result")
                ));
            }

        } catch (Exception e) {
            throw new DatabaseException("Fetch by operation failed", e);
        }

        return list;
    }

    @Override
    public List<QuantityMeasurementEntity> findByUnit(String unit) {

        List<QuantityMeasurementEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM quantity_measurement WHERE unit=?";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, unit);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new QuantityMeasurementEntity(
                        rs.getDouble("value"),
                        rs.getString("unit"),
                        rs.getString("operation"),
                        rs.getDouble("result")
                ));
            }

        } catch (Exception e) {
            throw new DatabaseException("Fetch by unit failed", e);
        }

        return list;
    }

    @Override
    public int getTotalCount() {

        String sql = "SELECT COUNT(*) FROM quantity_measurement";

        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) return rs.getInt(1);

        } catch (Exception e) {
            throw new DatabaseException("Count failed", e);
        }

        return 0;
    }
}