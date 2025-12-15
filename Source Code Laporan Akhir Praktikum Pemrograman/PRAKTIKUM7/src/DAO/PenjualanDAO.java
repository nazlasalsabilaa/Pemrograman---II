package DAO;

import model.Penjualan;
import java.util.List;

public interface PenjualanDAO {
    void insert(Penjualan penjualan);
    void update(Penjualan penjualan);
    void delete(Penjualan penjualan);
    List<Penjualan> getAll();
}