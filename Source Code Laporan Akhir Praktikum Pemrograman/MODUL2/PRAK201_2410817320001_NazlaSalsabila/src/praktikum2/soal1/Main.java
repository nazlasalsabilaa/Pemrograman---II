package praktikum2.soal1;

public class Main {
    public static void main(String[] args) {
        Buah apel = new Buah("Apel", 0.4, 7000, 40);
        apel.tampilkanInfo();

        Buah mangga = new Buah("mangga", 0.2, 3500, 15);
        mangga.tampilkanInfo();

        Buah alpukat = new Buah("alpukat", 0.25, 10000, 12);
        alpukat.tampilkanInfo();
    }
}