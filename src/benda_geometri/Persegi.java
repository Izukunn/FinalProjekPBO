package benda_geometri;

public class Persegi implements Benda2D, Runnable {

    public double sisi;
    public double luas;
    public double keliling;

    public Persegi(double sisi) throws InvalidInputException {
        if (sisi < 0) {
            throw new InvalidInputException("Sisi tidak boleh negatif!");
        }
        this.sisi = sisi;
        hitungLuas();
        hitungKeliling();
    }

    @Override
    public void hitungLuas() {
        luas = sisi * sisi;
    }

    @Override
    public void hitungKeliling() {
        keliling = 4 * sisi;
    }

    @Override
    public String tampilkanInfo() {
    return "=== PERSEGI ===\n"
            + "Sisi\t: " + sisi + "\n"
            + "Luas\t: " + luas + "\n"
            + "Keliling\t: " + keliling;
}

    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        tampilkanInfo();
    }
}
