package soal3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Mahasiswa> daftar = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilih = sc.nextInt(); sc.nextLine();

            switch (pilih) {
                case 1 -> {
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String nim = sc.nextLine();

                    boolean ada = daftar.stream().anyMatch(m -> m.getNim().equals(nim));
                    if (ada)
                        System.out.println("NIM sudah digunakan!");
                    else {
                        daftar.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa " + nama + " ditambahkan.");
                    }
                }

                case 2 -> {
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimHapus = sc.nextLine();
                    boolean removed = daftar.removeIf(m -> m.getNim().equals(nimHapus));
                    System.out.println(removed
                            ? "Mahasiswa dengan NIM " + nimHapus + " dihapus."
                            : "Mahasiswa tidak ditemukan.");
                }

                case 3 -> {
                    System.out.print("Masukkan NIM yang ingin dicari: ");
                    String nimCari = sc.nextLine();
                    daftar.stream()
                          .filter(m -> m.getNim().equals(nimCari))
                          .findFirst()
                          .ifPresentOrElse(
                              m -> System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama()),
                              () -> System.out.println("Mahasiswa tidak ditemukan.")
                          );
                }

                case 4 -> {
                    if (daftar.isEmpty())
                        System.out.println("Belum ada data mahasiswa.");
                    else {
                        System.out.println("Daftar Mahasiswa:");
                        daftar.forEach(m -> System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama()));
                    }
                }

                case 0 -> {
                    System.out.println("Terima kasih!");
                    daftar.clear(); 
                }

                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 0);
        
        sc.close();
        
    }
}