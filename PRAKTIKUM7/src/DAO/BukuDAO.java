package DAO;

import model.Buku;
import java.util.List;

public interface BukuDAO {
    void insert(Buku buku);
    void update(Buku buku);
    void delete(Buku buku);
    List<Buku> getAll();
}