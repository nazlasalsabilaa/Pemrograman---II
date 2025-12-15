package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Buku {
    private final StringProperty bukuId;
    private final StringProperty judul;
    private final StringProperty penulis;
    private final IntegerProperty harga;
    private final IntegerProperty stok;

    public Buku(String bukuId, String judul, String penulis, int harga, int stok) {
        this.bukuId = new SimpleStringProperty(bukuId);
        this.judul = new SimpleStringProperty(judul);
        this.penulis = new SimpleStringProperty(penulis);
        this.harga = new SimpleIntegerProperty(harga);
        this.stok = new SimpleIntegerProperty(stok);
    }

    public String getBukuId() { return bukuId.get(); }
    public void setBukuId(String bukuId) { this.bukuId.set(bukuId); }
    public StringProperty bukuIdProperty() { return bukuId; }

    public String getJudul() { return judul.get(); }
    public void setJudul(String judul) { this.judul.set(judul); }
    public StringProperty judulProperty() { return judul; }

    public String getPenulis() { return penulis.get(); }
    public void setPenulis(String penulis) { this.penulis.set(penulis); }
    public StringProperty penulisProperty() { return penulis; }

    public int getHarga() { return harga.get(); }
    public void setHarga(int harga) { this.harga.set(harga); }
    public IntegerProperty hargaProperty() { return harga; }

    public int getStok() { return stok.get(); }
    public void setStok(int stok) { this.stok.set(stok); }
    public IntegerProperty stokProperty() { return stok; }

    @Override
    public String toString() { return getJudul(); }
}