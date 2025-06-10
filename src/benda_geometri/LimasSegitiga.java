package benda_geometri;

public class LimasSegitiga extends Segitiga implements Benda3D {

    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasSegitiga() {
        super(6, 4);
        this.tinggiLimas = 10;
        hitungVolume();
        hitungLuasPermukaan();
    }

    public LimasSegitiga(double alas, double tinggiSegitiga, double tinggiLimas) throws InvalidInputException {
        super(alas, tinggiSegitiga);
        if (tinggiLimas < 0) {
            throw new InvalidInputException("Tinggi limas tidak boleh negatif!");
        }
        this.tinggiLimas = tinggiLimas;
        hitungVolume();
        hitungLuasPermukaan();
    }

    @Override
    public void hitungVolume() {
        volume = (1.0 / 3.0) * super.hitungLuasReturn() * tinggiLimas;
    }

    @Override
    public void hitungLuasPermukaan() {
        double kelilingAlas = super.hitungKelilingReturn();
        // Luas segitiga sisi samping = 1/2 * (kelilingAlas / 3) * tinggiSisi
        double tinggiSisi = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow((super.getAlas() / 2), 2));
        double luasSisi = 0.5 * (super.getAlas() / 2) * tinggiSisi;
        luasPermukaan = super.hitungLuasReturn() + (3 * luasSisi);
    }

    @Override
    public String tampilkanInfo() {
        return "=== LIMAS SEGITIGA ===\n"
                + "Alas\t: " + getAlas() + "\n"
                + "Tinggi Segitiga: " + getTinggi() + "\n"
                + "Tinggi Limas\t: " + tinggiLimas + "\n"
                + "Volume\t: " + volume + "\n"
                + "Luas Permukaan: " + luasPermukaan;
    }

    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }
}
