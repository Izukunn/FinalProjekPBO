package benda_geometri;

public class BelahKetupat implements Benda2D, Runnable {

    private double diagonal1;
    private double diagonal2;
    private double sisi;

    private double luas;
    private double keliling;

    public BelahKetupat() {
        this.diagonal1 = 1.0;
        this.diagonal2 = 1.0;
        this.sisi = 1.0;
        hitungLuas();
        hitungKeliling();
    }

    public BelahKetupat(double diagonal1, double diagonal2, double sisi) throws InvalidInputException {
        setDiagonal1(diagonal1);
        setDiagonal2(diagonal2);
        setSisi(sisi);
        hitungLuas();
        hitungKeliling();
    }

    public double getDiagonal1() {
        return diagonal1;
    }

    public void setDiagonal1(double diagonal1) throws InvalidInputException {
        if (diagonal1 < 0) {
            throw new InvalidInputException("Diagonal 1 tidak boleh negatif!");
        }
        this.diagonal1 = diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    public void setDiagonal2(double diagonal2) throws InvalidInputException {
        if (diagonal2 < 0) {
            throw new InvalidInputException("Diagonal 2 tidak boleh negatif!");
        }
        this.diagonal2 = diagonal2;
    }

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) throws InvalidInputException {
        if (sisi < 0) {
            throw new InvalidInputException("Sisi tidak boleh negatif!");
        }
        this.sisi = sisi;
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
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
        return "=== BELAH KETUPAT ===\n" +
               "Diagonal 1\t: " + diagonal1 + "\n" +
               "Diagonal 2\t: " + diagonal2 + "\n" +
               "Sisi\t\t: " + sisi + "\n" +
               "Luas\t\t: " + luas + "\n" +
               "Keliling\t: " + keliling;
    }

    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        System.out.println(tampilkanInfo());
    }
}
