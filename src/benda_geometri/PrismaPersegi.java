package benda_geometri;

public class PrismaPersegi extends Persegi implements Benda3D, Runnable {

    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public PrismaPersegi(double sisi, double tinggi) throws InvalidInputException {
        super(sisi);
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
        hitungVolume();
        hitungLuasPermukaan();
    }

    @Override
    public void hitungVolume() {
        super.hitungLuas();
        volume = super.luas * tinggi;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungLuas();
        super.hitungKeliling();
        luasPermukaan = 2 * super.luas + (super.keliling * tinggi);
    }

    @Override
    public String tampilkanInfo() {
    return "=== PRISMA PERSEGI ===\n"
            + "Sisi Alas\t: " + sisi + "\n"
            + "Tinggi\t: " + tinggi + "\n"
            + "Volume\t: " + volume + "\n"
            + "Luas Permukaan\t: " + luasPermukaan;
}

    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }
}
