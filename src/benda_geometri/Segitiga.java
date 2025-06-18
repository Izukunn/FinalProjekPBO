package benda_geometri;

public class Segitiga implements Benda2D, Runnable {

    private double alas;
    private double tinggi;
    private double luas;
    private double keliling;

    public Segitiga() {
        this.alas = 10;
        this.tinggi = 5;
        hitungLuas();
        hitungKeliling();
    }

    public Segitiga(double alas, double tinggi) throws InvalidInputException {
        if (alas < 0 || tinggi < 0) {
            throw new InvalidInputException("Alas dan tinggi tidak boleh negatif!");
        }
        this.alas = alas;
        this.tinggi = tinggi;
        hitungLuas();
        hitungKeliling();
    }

    public double getAlas() {
        return alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    @Override
    public void hitungLuas() {
        luas = 0.5 * alas * tinggi;
    }

    @Override
    public void hitungKeliling() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggi, 2));
        keliling = alas + 2 * sisiMiring;
    }

    @Override
    public String tampilkanInfo() {
        return "=== SEGITIGA ===\n"
                + "Alas\t: " + alas + "\n"
                + "Tinggi\t: " + tinggi + "\n"
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
        return 0.5 * alas * tinggi;
    }

    public double hitungKelilingReturn() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggi, 2));
        return alas + 2 * sisiMiring;
    }
}
