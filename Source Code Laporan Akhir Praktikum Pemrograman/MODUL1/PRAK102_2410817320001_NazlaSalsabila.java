package PemrogramanII;

import java.util.Scanner;

public class PRAK102_2410817320001_NazlaSalsabila {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean tanpaSpasi = true;

        while (true) {
            int angka = sc.nextInt();
            sc.nextLine();

            int count = 0;
            while (count < 11) {
                int output = angka;

                if (angka % 5 == 0) {
                    output = (angka / 5) - 1;
                }

                if (count < 10) {
                    if (tanpaSpasi) {
                        System.out.print(output + ",");
                    } else {
                        System.out.print(output + ", ");
                    }
                } else {
                    System.out.print(output);
                }

                angka++;
                count++;
            }

            System.out.println();
            sc.nextLine();
            tanpaSpasi = !tanpaSpasi;
        }
    }
}
