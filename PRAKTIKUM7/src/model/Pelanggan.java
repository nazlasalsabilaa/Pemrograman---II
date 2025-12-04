package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pelanggan {
    private final StringProperty pelangganId;
    private final StringProperty nama;
    private final StringProperty email;
    private final StringProperty telepon;

    public Pelanggan(String pelangganId, String nama, String email, String telepon) {
        this.pelangganId = new SimpleStringProperty(pelangganId);
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon);
    }

    public String getPelangganId() { return pelangganId.get(); }
    public void setPelangganId(String id) { this.pelangganId.set(id); }
    public StringProperty pelangganIdProperty() { return pelangganId; }

    public String getNama() { return nama.get(); }
    public void setNama(String nama) { this.nama.set(nama); }
    public StringProperty namaProperty() { return nama; }

    public String getEmail() { return email.get(); }
    public void setEmail(String email) { this.email.set(email); }
    public StringProperty emailProperty() { return email; }

    public String getTelepon() { return telepon.get(); }
    public void setTelepon(String telepon) { this.telepon.set(telepon); }
    public StringProperty teleponProperty() { return telepon; }

    @Override
    public String toString() { return getNama(); }
}
