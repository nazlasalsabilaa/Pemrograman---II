package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Buku;
import model.Pelanggan;
import model.Penjualan;
import service.BukuService;
import service.PelangganService;
import service.PenjualanService;

import java.time.LocalDate;
import java.util.UUID;

public class MainController {

    // buku
    @FXML private TextField txtJudul, txtPenulis, txtHarga, txtStok;
    @FXML private TableView<Buku> tblBuku;
    @FXML private TableColumn<Buku, String> colBukuID, colJudul, colPenulis;
    @FXML private TableColumn<Buku, Integer> colHarga, colStok;
    private final BukuService bukuService = new BukuService();
    private final ObservableList<Buku> bukuList = FXCollections.observableArrayList();

    // pelanggan
    @FXML private TextField txtNama, txtEmail, txtTelepon;
    @FXML private TableView<Pelanggan> tblPelanggan;
    @FXML private TableColumn<Pelanggan, String> colPelangganID, colNama, colEmail, colTelepon;
    private final PelangganService pelangganService = new PelangganService();
    private final ObservableList<Pelanggan> pelangganList = FXCollections.observableArrayList();

    // penjualan
    @FXML private TextField txtPenjualanJumlah;
    @FXML private ComboBox<Pelanggan> cbPelanggan;
    @FXML private ComboBox<Buku> cbBuku;
    @FXML private Label lblTotalHarga;
    @FXML private DatePicker dpTanggalPenjualan;
    @FXML private TableView<Penjualan> tblPenjualan;
    @FXML private TableColumn<Penjualan, String> colPenjualanID, colBukuIDJual, colPelangganIDJual;
    @FXML private TableColumn<Penjualan, Integer> colJumlahJual, colTotalHargaJual;
    @FXML private TableColumn<Penjualan, LocalDate> colTanggalJual;
    private final PenjualanService penjualanService = new PenjualanService();
    private final ObservableList<Penjualan> penjualanList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colBukuID.setCellValueFactory(c -> c.getValue().bukuIdProperty());
        colJudul.setCellValueFactory(c -> c.getValue().judulProperty());
        colPenulis.setCellValueFactory(c -> c.getValue().penulisProperty());
        colHarga.setCellValueFactory(c -> c.getValue().hargaProperty().asObject());
        colStok.setCellValueFactory(c -> c.getValue().stokProperty().asObject());
        tblBuku.setItems(bukuList);
        loadBuku();

        colPelangganID.setCellValueFactory(c -> c.getValue().pelangganIdProperty());
        colNama.setCellValueFactory(c -> c.getValue().namaProperty());
        colEmail.setCellValueFactory(c -> c.getValue().emailProperty());
        colTelepon.setCellValueFactory(c -> c.getValue().teleponProperty());
        tblPelanggan.setItems(pelangganList);
        loadPelanggan();

        colPenjualanID.setCellValueFactory(c -> c.getValue().penjualanIdProperty());
        colBukuIDJual.setCellValueFactory(c -> c.getValue().bukuIdProperty());
        colPelangganIDJual.setCellValueFactory(c -> c.getValue().pelangganIdProperty());
        colJumlahJual.setCellValueFactory(c -> c.getValue().jumlahProperty().asObject());
        colTotalHargaJual.setCellValueFactory(c -> c.getValue().totalHargaProperty().asObject());
        colTanggalJual.setCellValueFactory(c -> c.getValue().tanggalProperty());
        tblPenjualan.setItems(penjualanList);
        loadPenjualan();

        cbBuku.setItems(bukuList);
        cbPelanggan.setItems(pelangganList);

        txtPenjualanJumlah.textProperty().addListener((obs, oldVal, newVal) -> updateTotalHarga());
        cbBuku.valueProperty().addListener((obs, oldVal, newVal) -> updateTotalHarga());
    }

    private void updateTotalHarga() {
        Buku buku = cbBuku.getValue();
        int jumlah = 0;
        try { jumlah = Integer.parseInt(txtPenjualanJumlah.getText()); } catch (NumberFormatException ignored) {}
        lblTotalHarga.setText(String.valueOf(buku != null ? jumlah * buku.getHarga() : 0));
    }

    private void loadBuku() { bukuList.setAll(bukuService.getSemuaBuku()); }
    private void loadPelanggan() { pelangganList.setAll(pelangganService.getSemuaPelanggan()); }
    private void loadPenjualan() { penjualanList.setAll(penjualanService.getSemuaPenjualan()); }

    @FXML
    private void addBuku() {
        if (txtJudul.getText().isEmpty() || txtPenulis.getText().isEmpty() ||
            txtHarga.getText().isEmpty() || txtStok.getText().isEmpty()) {
            showAlert("Data Buku harus lengkap!");
            return;
        }
        Buku b = new Buku(UUID.randomUUID().toString().substring(0, 10),
                txtJudul.getText(), txtPenulis.getText(),
                Integer.parseInt(txtHarga.getText()),
                Integer.parseInt(txtStok.getText()));
        bukuService.tambahBuku(b);
        loadBuku();
        clearBukuForm();
        showSuccess("Data buku berhasil ditambahkan!");
    }

    @FXML
    private void editBuku() {
        Buku selected = tblBuku.getSelectionModel().getSelectedItem();
        if (selected == null) { showAlert("Pilih Buku terlebih dahulu!"); return; }
        selected.setJudul(txtJudul.getText());
        selected.setPenulis(txtPenulis.getText());
        selected.setHarga(Integer.parseInt(txtHarga.getText()));
        selected.setStok(Integer.parseInt(txtStok.getText()));
        bukuService.ubahBuku(selected);
        loadBuku();
        clearBukuForm();
        showSuccess("Data buku berhasil diedit!");
    }

    @FXML
    private void deleteBuku() {
        Buku selected = tblBuku.getSelectionModel().getSelectedItem();
        if (selected == null) { showAlert("Pilih Buku terlebih dahulu!"); return; }
        try {
            bukuService.hapusBuku(selected);
            loadBuku();
            clearBukuForm();
            showSuccess("Data buku berhasil dihapus!");
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().toLowerCase().contains("foreign key")) {
                showAlert("Data buku tidak bisa dihapus! Masih ada transaksi penjualan terkait.");
            } else {
                showAlert("Terjadi kesalahan saat menghapus buku: " + e.getMessage());
            }
        }
    }

    private void clearBukuForm() { txtJudul.clear(); txtPenulis.clear(); txtHarga.clear(); txtStok.clear(); }

    @FXML
    private void addPelanggan() {
        if (txtNama.getText().isEmpty() || txtEmail.getText().isEmpty() || txtTelepon.getText().isEmpty()) {
            showAlert("Data Pelanggan harus lengkap!"); return;
        }
        Pelanggan p = new Pelanggan(UUID.randomUUID().toString().substring(0, 10),
                txtNama.getText(), txtEmail.getText(), txtTelepon.getText());
        pelangganService.tambahPelanggan(p);
        loadPelanggan();
        clearPelangganForm();
        showSuccess("Data pelanggan berhasil ditambahkan!");
    }

    @FXML
    private void editPelanggan() {
        Pelanggan selected = tblPelanggan.getSelectionModel().getSelectedItem();
        if (selected == null) { showAlert("Pilih Pelanggan terlebih dahulu!"); return; }
        selected.setNama(txtNama.getText());
        selected.setEmail(txtEmail.getText());
        selected.setTelepon(txtTelepon.getText());
        pelangganService.ubahPelanggan(selected);
        loadPelanggan();
        clearPelangganForm();
        showSuccess("Data pelanggan berhasil diedit!");
    }

    @FXML
    private void deletePelanggan() {
        Pelanggan selected = tblPelanggan.getSelectionModel().getSelectedItem();
        if (selected == null) { showAlert("Pilih Pelanggan terlebih dahulu!"); return; }
        try {
            pelangganService.hapusPelanggan(selected);
            loadPelanggan();
            clearPelangganForm();
            showSuccess("Data pelanggan berhasil dihapus!");
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().toLowerCase().contains("foreign key")) {
                showAlert("Data pelanggan tidak bisa dihapus! Masih ada transaksi penjualan terkait.");
            } else {
                showAlert("Terjadi kesalahan saat menghapus pelanggan: " + e.getMessage());
            }
        }
    }

    private void clearPelangganForm() { txtNama.clear(); txtEmail.clear(); txtTelepon.clear(); }

    @FXML
    private void addPenjualan() {
        if (cbPelanggan.getValue() == null || cbBuku.getValue() == null ||
            txtPenjualanJumlah.getText().isEmpty() || dpTanggalPenjualan.getValue() == null) {
            showAlert("Data Penjualan harus lengkap!"); return;
        }
        Buku buku = cbBuku.getValue();
        Pelanggan pelanggan = cbPelanggan.getValue();
        int jumlah = Integer.parseInt(txtPenjualanJumlah.getText());
        int totalHarga = buku.getHarga() * jumlah;
        LocalDate tanggal = dpTanggalPenjualan.getValue();
        Penjualan p = new Penjualan(UUID.randomUUID().toString().substring(0, 10),
                buku.getBukuId(), pelanggan.getPelangganId(), totalHarga, jumlah, tanggal);
        penjualanService.tambahPenjualan(p);
        loadPenjualan();
        clearPenjualanForm();
        showSuccess("Data penjualan berhasil ditambahkan!");
    }

    @FXML
    private void editPenjualan() {
        Penjualan selected = tblPenjualan.getSelectionModel().getSelectedItem();
        if (selected == null) { showAlert("Pilih Penjualan terlebih dahulu!"); return; }
        Buku buku = cbBuku.getValue();
        Pelanggan pelanggan = cbPelanggan.getValue();
        int jumlah = Integer.parseInt(txtPenjualanJumlah.getText());
        int totalHarga = buku.getHarga() * jumlah;
        LocalDate tanggal = dpTanggalPenjualan.getValue();
        selected.setBukuId(buku.getBukuId());
        selected.setPelangganId(pelanggan.getPelangganId());
        selected.setJumlah(jumlah);
        selected.setTotalHarga(totalHarga);
        selected.setTanggal(tanggal);
        penjualanService.ubahPenjualan(selected);
        loadPenjualan();
        clearPenjualanForm();
        showSuccess("Data penjualan berhasil diedit!");
    }

    @FXML
    private void deletePenjualan() {
        Penjualan selected = tblPenjualan.getSelectionModel().getSelectedItem();
        if (selected == null) { showAlert("Pilih Penjualan terlebih dahulu!"); return; }
        penjualanService.hapusPenjualan(selected);
        loadPenjualan();
        clearPenjualanForm();
        showSuccess("Data penjualan berhasil dihapus!");
    }

    private void clearPenjualanForm() {
        txtPenjualanJumlah.clear();
        cbBuku.getSelectionModel().clearSelection();
        cbPelanggan.getSelectionModel().clearSelection();
        lblTotalHarga.setText("0");
        dpTanggalPenjualan.setValue(null);
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Peringatan");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void showSuccess(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Berhasil");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}