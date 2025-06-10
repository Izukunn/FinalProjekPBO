package benda_geometri;

public class Trapesium implements Benda2D {

    public double sisiAtas;
    public double sisiBawah;
    public double sisiKiri;
    public double sisiKanan;
    public double tinggiAlas;
    public double luas;
    public double keliling;

    public Trapesium(double sisiAtas, double sisiBawah, double sisiKiri, double sisiKanan, double tinggi) throws InvalidInputException {
        if (sisiAtas < 0) {
            throw new InvalidInputException("Sisi atas tidak boleh negatif!");
        }
        if (sisiBawah < 0) {
            throw new InvalidInputException("Sisi bawah tidak boleh negatif!");
        }
        if (sisiKiri < 0) {
            throw new InvalidInputException("Sisi kiri tidak boleh negatif!");
        }
        if (sisiKanan < 0) {
            throw new InvalidInputException("Sisi kanan tidak boleh negatif!");
        }
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.sisiAtas = sisiAtas;
        this.sisiBawah = sisiBawah;
        this.sisiKiri = sisiKiri;
        this.sisiKanan = sisiKanan;
        this.tinggiAlas = tinggi;
        hitungLuas();
        hitungKeliling();
    }

    @Override
    public void hitungLuas() {
        luas = 0.5 * (sisiAtas + sisiBawah) * tinggiAlas;
    }

    @Override
    public void hitungKeliling() {
        keliling = sisiAtas + sisiBawah + sisiKiri + sisiKanan;
    }

    @Override
    public String tampilkanInfo() {
    return "=== TRAPESIUM ===\n"
            + "Sisi Atas\t: " + sisiAtas + "\n"
            + "Sisi Bawah\t: " + sisiBawah + "\n"
            + "Sisi Kiri\t: " + sisiKiri + "\n"
            + "Sisi Kanan\t: " + sisiKanan + "\n"
            + "Tinggi\t: " + tinggiAlas + "\n"
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
