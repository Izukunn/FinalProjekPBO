package benda_geometri;

public class LimasPersegi extends Persegi implements Benda3D {

    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public LimasPersegi(double sisi, double tinggi) throws InvalidInputException {
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
        volume = (1.0 / 3.0) * super.luas * tinggi;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungLuas();
        super.hitungKeliling();
        double tinggiSegitiga = Math.sqrt((tinggi * tinggi) + Math.pow((sisi / 2), 2));
        double luasSegitiga = 0.5 * sisi * tinggiSegitiga;
        luasPermukaan = super.luas + 4 * luasSegitiga;
    }

    @Override
    public String tampilkanInfo() {
    return "=== LIMAS PERSEGI ===\n"
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
