package soal2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Negara> daftarNegara = new LinkedList<>();

        // HashMap untuk daftar nama bulan
        HashMap<Integer, String> bulan = new HashMap<>();
        bulan.put(1, "Januari");
        bulan.put(2, "Februari");
        bulan.put(3, "Maret");
        bulan.put(4, "April");
        bulan.put(5, "Mei");
        bulan.put(6, "Juni");
        bulan.put(7, "Juli");
        bulan.put(8, "Agustus");
        bulan.put(9, "September");
        bulan.put(10, "Oktober");
        bulan.put(11, "November");
        bulan.put(12, "Desember");

        int jumlah = input.nextInt();
        input.nextLine(); // membersihkan newline

        for (int i = 0; i < jumlah; i++) {
            String nama = input.nextLine();
            String jenis = input.nextLine();
            String pemimpin = input.nextLine();

            if (jenis.equalsIgnoreCase("monarki")) {
                // Jika monarki, tidak ada tanggal kemerdekaan
                Negara negara = new Negara(nama, jenis, pemimpin);
                daftarNegara.add(negara);
            } else {
                int tanggal = input.nextInt();
                int bulanK = input.nextInt();
                int tahun = input.nextInt();
                input.nextLine(); // membersihkan newline
                Negara negara = new Negara(nama, jenis, pemimpin, tanggal, bulanK, tahun);
                daftarNegara.add(negara);
            }
        }

        // Output
        for (Negara n : daftarNegara) {
            if (n.getJenisKepemimpinan().equalsIgnoreCase("monarki")) {
                System.out.println("Negara " + n.getNama() + " mempunyai Raja bernama " + n.getNamaPemimpin() + " \n");
            } else {
                // Menentukan jenis pemimpin (kapital di awal)
                String jenisFormatted = Character.toUpperCase(n.getJenisKepemimpinan().charAt(0)) 
                                        + n.getJenisKepemimpinan().substring(1);
                System.out.println("Negara " + n.getNama() + " mempunyai " + jenisFormatted 
                                   + " bernama " + n.getNamaPemimpin());
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " + n.getTanggalKemerdekaan() + " "
                                   + bulan.get(n.getBulanKemerdekaan()) + " " + n.getTahunKemerdekaan() + " \n");
            }
        }

        input.close();
    }
}