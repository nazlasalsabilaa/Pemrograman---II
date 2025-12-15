package praktikum2.soal3; 

//Pada baris ini terjadi error karena nama class berbeda dengan file.
//File bernama Pegawai.java, tapi class bernama Employee, Java mengharuskan nama class sama dengan nama file
//public class Employee {
public class Pegawai {

    public String nama;

    //Pada baris ini terjadi error karena tipe data char hanya satu karakter,
    //sementara data yang dimaksud adalah string "Kingdom of Orvel"
    //public char asal;
    public String asal;

    public String jabatan;

    //Pada baris ini perlu diisi default umur sesuai output (17)
    public int umur = 17;

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;  // asal sudah diubah menjadi String
    }

    //Pada baris ini terjadi error karena method setJabatan tidak menerima parameter,
    //sementara main memanggil setJabatan("Assasin")
    //public void setJabatan() { this.jabatan = j; }
    public void setJabatan(String j) {
        this.jabatan = j;
    }
}