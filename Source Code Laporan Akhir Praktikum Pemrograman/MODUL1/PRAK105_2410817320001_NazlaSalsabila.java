package PemrogramanII;

import java.util.Scanner;
import java.util.Locale;

public class PRAK105_2410817320001_NazlaSalsabila {
    public static void main(String[] args) {
        final double PHI = 3.14;
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        while (true) {
            System.out.print("Masukkan jari-jari: ");
            double r = Double.parseDouble(input.nextLine());

            System.out.print("Masukkan tinggi: ");
            double t = Double.parseDouble(input.nextLine());

            double volume = PHI * r * r * t;

            System.out.printf(
                "Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3\n",
                r, t, volume
            );

            input.nextLine(); 
            System.out.println(); 
        }
    }
}
