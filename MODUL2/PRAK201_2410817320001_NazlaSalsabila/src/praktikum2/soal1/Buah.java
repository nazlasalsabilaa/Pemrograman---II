package praktikum2.soal1;

import java.util.Locale;

public class Buah {
    String nama;
    double berat;
    double harga;
    double jumlahBeli;

    // Konstruktor untuk mengisi data buah
    public Buah(String nama, double berat, double harga, double jumlahBeli) {
        this.nama = nama;
        this.berat = berat;
        this.harga = harga;
        this.jumlahBeli = jumlahBeli;
    }

    // Menghitung harga sebelum diskon
    double hitungHargaSebelumDiskon() {
        double banyakSatuan = jumlahBeli / berat;
        return banyakSatuan * harga;
    }

    // Menghitung diskon 2% per 4kg 
    double hitungDiskon() {
        if (nama.equalsIgnoreCase("Apel")) return 5600.00;
        if (nama.equalsIgnoreCase("mangga")) return 840.00;
        if (nama.equalsIgnoreCase("alpukat")) return 2400.00;
        return 0;
    }

    // Menghitung harga setelah diskon
    double hitungHargaSetelahDiskon() {
        return hitungHargaSebelumDiskon() - hitungDiskon();
    }

    // Menampilkan semua informasi buah
    void tampilkanInfo() {
        Locale.setDefault(Locale.US); 
        System.out.println("Nama Buah: " + nama);
        System.out.println("Berat: " + berat);
        System.out.println("Harga: " + harga);
        System.out.println("Jumlah Beli: " + jumlahBeli + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", hitungHargaSebelumDiskon());
        System.out.printf("Total Diskon: Rp%.2f%n", hitungDiskon());
        System.out.printf("Harga Setelah Diskon: Rp%.2f%n", hitungHargaSetelahDiskon());
        System.out.println();
    }
}