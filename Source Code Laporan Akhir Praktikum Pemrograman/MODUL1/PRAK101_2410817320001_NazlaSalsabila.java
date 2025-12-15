package PemrogramanII;

import java.util.Scanner;

public class PRAK101_2410817320001_NazlaSalsabila {

    public static void main(String[] args) {
        String[] namaBulan = {"", "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.forLanguageTag("id-ID"));

        System.out.print("Masukkan Nama Lengkap: ");
        String namaLengkap = scanner.nextLine();

        System.out.print("Masukkan Tempat Lahir: ");
        String tempatLahir = scanner.nextLine();

        System.out.print("Masukkan Tanggal Lahir: ");
        int tanggalLahir = Integer.parseInt(scanner.nextLine());

        System.out.print("Masukkan Bulan Lahir: ");
        int bulanLahir = Integer.parseInt(scanner.nextLine());

        System.out.print("Masukkan Tahun Lahir: ");
        int tahunLahir = Integer.parseInt(scanner.nextLine());

        System.out.print("Masukkan Tinggi Badan: ");
        int tinggiBadan = Integer.parseInt(scanner.nextLine());

        System.out.print("Masukkan Berat Badan: ");
        double beratBadan = Double.parseDouble(scanner.nextLine());

        System.out.println("Nama Lengkap " + namaLengkap + ", Lahir di " + tempatLahir + 
            " pada Tanggal " + tanggalLahir + " " + namaBulan[bulanLahir] + " " + tahunLahir);
        System.out.println("Tinggi Badan " + tinggiBadan + " cm dan Berat Badan " + 
            beratBadan + " kilogram");

        scanner.close();
    }

}