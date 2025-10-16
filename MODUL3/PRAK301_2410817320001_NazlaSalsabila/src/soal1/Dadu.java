package soal1;

import java.util.Random;

public class Dadu {
    private int nilai; 

    public Dadu() {
        acakNilai();
    }

    public void acakNilai() {
        Random rand = new Random();
        this.nilai = rand.nextInt(6) + 1; // hasil antara 1–6
    }

    public int getNilai() {
        return nilai;
    }
}