package service;

import DAO.BukuDAO;
import DAO.Impl.BukuDAOImpl;
import model.Buku;
import java.util.List;

public class BukuService {
    private final BukuDAO dao = new BukuDAOImpl();

    public void tambahBuku(Buku buku) { dao.insert(buku); }
    public void ubahBuku(Buku buku) { dao.update(buku); }
    public void hapusBuku(Buku buku) { dao.delete(buku); }
    public List<Buku> getSemuaBuku() { return dao.getAll(); }
}