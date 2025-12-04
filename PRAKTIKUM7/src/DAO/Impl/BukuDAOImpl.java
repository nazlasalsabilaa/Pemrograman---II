package DAO.Impl;

import DAO.BukuDAO;
import model.Buku;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuDAOImpl implements BukuDAO {

    @Override
    public void insert(Buku buku) {
        String SQL = "INSERT INTO buku (buku_id, judul, penulis, harga, stok) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, buku.getBukuId());
            pstmt.setString(2, buku.getJudul());
            pstmt.setString(3, buku.getPenulis());
            pstmt.setInt(4, buku.getHarga());
            pstmt.setInt(5, buku.getStok());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Buku buku) {
        String SQL = "UPDATE buku SET judul=?, penulis=?, harga=?, stok=? WHERE buku_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, buku.getJudul());
            pstmt.setString(2, buku.getPenulis());
            pstmt.setInt(3, buku.getHarga());
            pstmt.setInt(4, buku.getStok());
            pstmt.setString(5, buku.getBukuId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Buku buku) {
        String SQL = "DELETE FROM buku WHERE buku_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, buku.getBukuId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Buku> getAll() {
        List<Buku> list = new ArrayList<>();
        String SQL = "SELECT buku_id, judul, penulis, harga, stok FROM buku";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                list.add(new Buku(
                        rs.getString("buku_id"),
                        rs.getString("judul"),
                        rs.getString("penulis"),
                        rs.getInt("harga"),
                        rs.getInt("stok")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}