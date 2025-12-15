package PRAK202_2410817320001_NazlaSalsabila;

public class Kopi {

    public String namaKopi;
    public String ukuran;
    public double harga;
    private String pembeli;

    // Menampilkan info kopi
    public void info() {
        System.out.println("Nama Kopi: " + namaKopi);
        System.out.println("Ukuran: " + ukuran);
        System.out.println("Harga: Rp. " + harga);
    }

    public void setPembeli(String namaPembeli) {
        this.pembeli = namaPembeli;
    }

    public String getPembeli() {
        return pembeli;
    }

    public double getPajak() {
        return harga * 0.11;
    }

    // Main method
    public static void main(String[] args) {
        // Objek 1
        Kopi kopi1 = new Kopi();
        kopi1.namaKopi = "Espresso";
        kopi1.ukuran = "Medium";
        kopi1.harga = 25000;
        kopi1.setPembeli("Alice");
        kopi1.info();
        System.out.println("Pembeli Kopi: " + kopi1.getPembeli());
        System.out.println("Pajak Kopi: Rp. " + kopi1.getPajak());
        System.out.println();

        // Objek 2
        Kopi kopi2 = new Kopi();
        kopi2.namaKopi = "Latte";
        kopi2.ukuran = "Large";
        kopi2.harga = 30000;
        kopi2.setPembeli("Bob");
        kopi2.info();
        System.out.println("Pembeli Kopi: " + kopi2.getPembeli());
        System.out.println("Pajak Kopi: Rp. " + kopi2.getPajak());
        System.out.println();

        // Objek 3
        Kopi kopi3 = new Kopi();
        kopi3.namaKopi = "Cappuccino";
        kopi3.ukuran = "Small";
        kopi3.harga = 20000;
        kopi3.setPembeli("Charlie");
        kopi3.info();
        System.out.println("Pembeli Kopi: " + kopi3.getPembeli());
        System.out.println("Pajak Kopi: Rp. " + kopi3.getPajak());
    }
}
