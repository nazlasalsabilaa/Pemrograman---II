package DAO;

import model.Pelanggan;
import java.util.List;

public interface PelangganDAO {
    void insert(Pelanggan pelanggan);
    void update(Pelanggan pelanggan);
    void delete(Pelanggan pelanggan);
    List<Pelanggan> getAll();
}