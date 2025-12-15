package PemrogramanII;

import java.util.Scanner;

public class PRAK103_2410817320001_NazlaSalsabila {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            int N = input.nextInt();
            int bilAwal = input.nextInt();

            if (bilAwal % 2 == 0) {
                bilAwal++;
            }

            int count = 0;
            int bil = bilAwal;

            do {
                System.out.print(bil);
                count++;
                if (count < N) {
                    System.out.print(", ");
                }
                bil += 2;
            } while (count < N);

            System.out.println();
            input.nextLine(); 
        }
    }
}
