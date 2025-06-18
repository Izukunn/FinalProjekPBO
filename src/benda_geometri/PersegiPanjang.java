package benda_geometri;

public class PersegiPanjang implements Benda2D, Runnable {

    public double panjang;
    public double lebar;
    public double luas;
    public double keliling;

    public PersegiPanjang(double panjang, double lebar) throws InvalidInputException {
        if (panjang < 0) {
            throw new InvalidInputException("Panjang tidak boleh negatif!");
        }
        if (lebar < 0) {
            throw new InvalidInputException("Lebar tidak boleh negatif!");
        }
        this.panjang = panjang;
        this.lebar = lebar;
        hitungLuas();
        hitungKeliling();
    }

    @Override
    public void hitungLuas() {
        luas = panjang * lebar;
    }

    @Override
    public void hitungKeliling() {
        keliling = 2 * (panjang + lebar);
    }

    @Override
    public String tampilkanInfo() {
    return "=== PERSEGI PANJANG ===\n"
            + "Panjang\t: " + panjang + "\n"
            + "Lebar\t: " + lebar + "\n"
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
