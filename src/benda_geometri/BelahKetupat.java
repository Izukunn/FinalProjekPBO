package benda_geometri;

public class BelahKetupat implements Benda2D, Runnable {

    public double diagonal1;
    public double diagonal2;
    public double sisi;
    public double luas;
    public double keliling;

    public BelahKetupat(double diagonal1, double diagonal2, double sisi) throws InvalidInputException {
        if (diagonal1 < 0 || diagonal2 < 0 || sisi < 0) {
            throw new InvalidInputException("Nilai tidak boleh negatif!");
        }
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi = sisi;
        hitungLuas();
        hitungKeliling();
    }

    @Override
    public void hitungLuas() {
        luas = (diagonal1 * diagonal2) / 2.0;
    }

    @Override
    public void hitungKeliling() {
        keliling = 4 * sisi;
    }

    @Override
    public String tampilkanInfo() {
        return "=== BELAH KETUPAT ===\n"
               + "Diagonal 1\t: " + diagonal1 + "\n"
               + "Diagonal 2\t: " + diagonal2 + "\n"
               + "Sisi\t\t: " + sisi + "\n"
               + "Luas\t\t: " + luas + "\n"
               + "Keliling\t: " + keliling;
    }

    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        tampilkanInfo();
    }
}
