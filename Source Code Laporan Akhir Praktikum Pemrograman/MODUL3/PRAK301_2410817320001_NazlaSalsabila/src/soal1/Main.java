package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Dadu> daftarDadu = new LinkedList<>();

        int jumlah = input.nextInt(); 

        int total = 0;

        for (int i = 0; i < jumlah; i++) {
            Dadu dadu = new Dadu();
            daftarDadu.add(dadu);
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + dadu.getNilai());
            total += dadu.getNilai();
        }

        System.out.println("Total nilai dadu keseluruhan " + total);
        input.close();
    }
}