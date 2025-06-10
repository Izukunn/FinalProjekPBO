package benda_geometri;

public class LimasJajaranGenjang extends JajaranGenjang implements Benda3D {

    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasJajaranGenjang() {
        super(8, 5, 6);
        this.tinggiLimas = 12;
        hitungVolume();
        hitungLuasPermukaan();
    }

    public LimasJajaranGenjang(double alas, double tinggiJajar, double sisiMiring, double tinggiLimas) throws InvalidInputException {
        super(alas, tinggiJajar, sisiMiring);
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
        // Luas segitiga sisi = 1/2 * (panjang sisi alas) * tinggiSisi
        double tinggiSisi = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow((super.getAlas() / 2), 2));
        double luasSisi = 0.5 * (super.getAlas()) * tinggiSisi;
        luasPermukaan = super.hitungLuasReturn() + (4 * luasSisi);
    }

    @Override
    public String tampilkanInfo() {
        return "=== LIMAS JAJARAN GENJANG ===\n"
                + "Alas\t: " + getAlas() + "\n"
                + "Tinggi Jajar\t: " + getTinggi() + "\n"
                + "Sisi Miring\t: " + getSisiMiring() + "\n"
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
