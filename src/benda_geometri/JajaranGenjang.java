package benda_geometri;

public class JajaranGenjang implements Benda2D, Runnable {

    private double alas;
    private double tinggi;
    private double sisiMiring;
    private double luas;
    private double keliling;

    public JajaranGenjang() {
        this.alas = 8;
        this.tinggi = 5;
        this.sisiMiring = 6;
        hitungLuas();
        hitungKeliling();
    }

    public JajaranGenjang(double alas, double tinggi, double sisiMiring) throws InvalidInputException {
        if (alas < 0 || tinggi < 0 || sisiMiring < 0) {
            throw new InvalidInputException("Nilai tidak boleh negatif!");
        }
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
        hitungLuas();
        hitungKeliling();
    }

    public double getAlas() {
        return alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiMiring() {
        return sisiMiring;
    }

    @Override
    public void hitungLuas() {
        luas = alas * tinggi;
    }

    @Override
    public void hitungKeliling() {
        keliling = 2 * (alas + sisiMiring);
    }

    @Override
    public String tampilkanInfo() {
        return "=== JAJARAN GENJANG ===\n"
                + "Alas\t: " + alas + "\n"
                + "Tinggi\t: " + tinggi + "\n"
                + "Sisi Miring: " + sisiMiring + "\n"
                + "Luas\t: " + luas + "\n"
                + "Keliling: " + keliling;
    }

    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        tampilkanInfo();
    }

    public double hitungLuasReturn() {
        return alas * tinggi;
    }

    public double hitungKelilingReturn() {
        return 2 * (alas + sisiMiring);
    }
}
