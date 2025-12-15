package service;

import DAO.PelangganDAO;
import DAO.Impl.PelangganDAOImpl;
import model.Pelanggan;
import java.util.List;

public class PelangganService {
    private final PelangganDAO dao = new PelangganDAOImpl();

    public void tambahPelanggan(Pelanggan p) { dao.insert(p); }
    public void ubahPelanggan(Pelanggan p) { dao.update(p); }
    public void hapusPelanggan(Pelanggan p) { dao.delete(p); }
    public List<Pelanggan> getSemuaPelanggan() { return dao.getAll(); }
}