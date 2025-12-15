package model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Penjualan {
    private final StringProperty penjualanId;
    private final StringProperty bukuId;
    private final StringProperty pelangganId;
    private final IntegerProperty jumlah;
    private final IntegerProperty totalHarga;
    private final ObjectProperty<LocalDate> tanggal;

    public Penjualan(String penjualanId, String bukuId, String pelangganId, int totalHarga, int jumlah, LocalDate tanggal) {
        this.penjualanId = new SimpleStringProperty(penjualanId);
        this.bukuId = new SimpleStringProperty(bukuId);
        this.pelangganId = new SimpleStringProperty(pelangganId);
        this.totalHarga = new SimpleIntegerProperty(totalHarga);
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.tanggal = new SimpleObjectProperty<>(tanggal);
    }

    public String getPenjualanId() { return penjualanId.get(); }
    public void setPenjualanId(String id) { this.penjualanId.set(id); }
    public StringProperty penjualanIdProperty() { return penjualanId; }

    public String getBukuId() { return bukuId.get(); }
    public void setBukuId(String bukuId) { this.bukuId.set(bukuId); }
    public StringProperty bukuIdProperty() { return bukuId; }

    public String getPelangganId() { return pelangganId.get(); }
    public void setPelangganId(String pelangganId) { this.pelangganId.set(pelangganId); }
    public StringProperty pelangganIdProperty() { return pelangganId; }

    public int getJumlah() { return jumlah.get(); }
    public void setJumlah(int jumlah) { this.jumlah.set(jumlah); }
    public IntegerProperty jumlahProperty() { return jumlah; }

    public int getTotalHarga() { return totalHarga.get(); }
    public void setTotalHarga(int totalHarga) { this.totalHarga.set(totalHarga); }
    public IntegerProperty totalHargaProperty() { return totalHarga; }

    public LocalDate getTanggal() { return tanggal.get(); }
    public void setTanggal(LocalDate tanggal) { this.tanggal.set(tanggal); }
    public ObjectProperty<LocalDate> tanggalProperty() { return tanggal; }
}