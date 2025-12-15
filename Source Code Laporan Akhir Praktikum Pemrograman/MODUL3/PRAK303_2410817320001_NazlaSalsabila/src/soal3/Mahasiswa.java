package soal3;

public class Mahasiswa {
    // 🔹 Atribut dienkapsulasi (private)
    private String nama;
    private String nim;

    // 🔹 Konstruktor untuk inisialisasi atribut
    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // 🔹 Getter untuk mengambil nilai nama
    public String getNama() {
        return nama;
    }

    // 🔹 Getter untuk mengambil nilai NIM
    public String getNim() {
        return nim;
    }
}