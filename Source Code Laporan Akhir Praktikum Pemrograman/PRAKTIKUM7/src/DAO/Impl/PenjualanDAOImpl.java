package DAO.Impl;

import DAO.PenjualanDAO;
import model.Penjualan;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenjualanDAOImpl implements PenjualanDAO {

    @Override
    public void insert(Penjualan p) {
        String SQL = "INSERT INTO penjualan (penjualan_id, buku_id, pelanggan_id, total_harga, jumlah, tanggal) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, p.getPenjualanId());
            pstmt.setString(2, p.getBukuId());
            pstmt.setString(3, p.getPelangganId());
            pstmt.setInt(4, p.getTotalHarga());
            pstmt.setInt(5, p.getJumlah());
            pstmt.setDate(6, Date.valueOf(p.getTanggal()));

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Penjualan p) {
        String SQL = "UPDATE penjualan SET buku_id=?, pelanggan_id=?, total_harga=?, jumlah=?, tanggal=? WHERE penjualan_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, p.getBukuId());
            pstmt.setString(2, p.getPelangganId());
            pstmt.setInt(3, p.getTotalHarga());
            pstmt.setInt(4, p.getJumlah());
            pstmt.setDate(5, Date.valueOf(p.getTanggal()));
            pstmt.setString(6, p.getPenjualanId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Penjualan p) {
        String SQL = "DELETE FROM penjualan WHERE penjualan_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, p.getPenjualanId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Penjualan> getAll() {
        List<Penjualan> list = new ArrayList<>();
        String SQL = "SELECT penjualan_id, buku_id, pelanggan_id, total_harga, jumlah, tanggal FROM penjualan";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Penjualan p = new Penjualan(
                        rs.getString("penjualan_id"),
                        rs.getString("buku_id"),
                        rs.getString("pelanggan_id"),
                        rs.getInt("total_harga"),
                        rs.getInt("jumlah"),
                        rs.getDate("tanggal").toLocalDate()
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}