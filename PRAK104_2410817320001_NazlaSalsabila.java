package PemrogramanII;

import java.util.Scanner;

public class PRAK104_2410817320001_NazlaSalsabila {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Tangan Abu: ");
            String[] abu = new String[3];
            for (int i = 0; i < 3; i++) {
                abu[i] = input.next();
            }

            System.out.print("Tangan Bagas: ");
            String[] bagas = new String[3];
            for (int i = 0; i < 3; i++) {
                bagas[i] = input.next();
            }

            int skorAbu = 0, skorBagas = 0;

            for (int i = 0; i < 3; i++) {
                String a = abu[i];
                String b = bagas[i];

                if (a.equals(b)) {
                    continue;
                }

                if ((a.equals("B") && b.equals("G")) ||
                    (a.equals("G") && b.equals("K")) ||
                    (a.equals("K") && b.equals("B"))) {
                    skorAbu++;
                } else {
                    skorBagas++;
                }
            }

            if (skorAbu > skorBagas) {
                System.out.println("Abu");
            } else if (skorBagas > skorAbu) {
                System.out.println("Bagas");
            } else {
                System.out.println("Seri");
            }

            input.nextLine(); 
            input.nextLine(); 
        }
    }
}