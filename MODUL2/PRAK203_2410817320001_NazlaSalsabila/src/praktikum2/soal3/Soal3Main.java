package praktikum2.soal3; 

public class Soal3Main {
    public static void main(String[] args) {
        Pegawai p1 = new Pegawai();

        //Pada baris ini terjadi error karena kurangnya titik koma (;) di akhir statement
        //p1.nama = "Roi"
        p1.nama = "Roi";

        p1.asal = "Kingdom of Orvel";

        //Sudah sesuai setelah setJabatan di Pegawai diperbaiki
        p1.setJabatan("Assasin");

      //Pada baris ini tidak ada error, tapi teks output disesuaikan agar sesuai instruksi soal (tanpa kata “Pegawai”)
      //System.out.println("Nama Pegawai: " + p1.getNama());
        System.out.println("Nama: " + p1.getNama());
        System.out.println("Asal: " + p1.getAsal());
        System.out.println("Jabatan: " + p1.jabatan);
        System.out.println("Umur: " + p1.umur + " tahun");
    }
}