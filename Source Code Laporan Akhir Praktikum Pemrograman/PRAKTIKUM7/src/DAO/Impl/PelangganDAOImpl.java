package DAO.Impl;

import DAO.PelangganDAO;
import model.Pelanggan;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PelangganDAOImpl implements PelangganDAO {

    @Override
    public void insert(Pelanggan pelanggan) {
        String SQL = "INSERT INTO pelanggan (pelanggan_id, nama, email, telepon) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, pelanggan.getPelangganId());
            pstmt.setString(2, pelanggan.getNama());
            pstmt.setString(3, pelanggan.getEmail());
            pstmt.setString(4, pelanggan.getTelepon());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pelanggan pelanggan) {
        String SQL = "UPDATE pelanggan SET nama=?, email=?, telepon=? WHERE pelanggan_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, pelanggan.getNama());
            pstmt.setString(2, pelanggan.getEmail());
            pstmt.setString(3, pelanggan.getTelepon());
            pstmt.setString(4, pelanggan.getPelangganId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Pelanggan pelanggan) {
        String SQL = "DELETE FROM pelanggan WHERE pelanggan_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, pelanggan.getPelangganId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pelanggan> getAll() {
        List<Pelanggan> list = new ArrayList<>();
        String SQL = "SELECT pelanggan_id, nama, email, telepon FROM pelanggan";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                list.add(new Pelanggan(
                        rs.getString("pelanggan_id"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("telepon")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}