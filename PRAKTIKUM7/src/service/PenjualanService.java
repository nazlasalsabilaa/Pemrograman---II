package service;

import DAO.PenjualanDAO;
import DAO.Impl.PenjualanDAOImpl;
import model.Penjualan;
import java.util.List;

public class PenjualanService {
    private final PenjualanDAO dao = new PenjualanDAOImpl();

    public void tambahPenjualan(Penjualan p) { dao.insert(p); }
    public void ubahPenjualan(Penjualan p) { dao.update(p); }
    public void hapusPenjualan(Penjualan p) { dao.delete(p); }
    public List<Penjualan> getSemuaPenjualan() { return dao.getAll(); }
}