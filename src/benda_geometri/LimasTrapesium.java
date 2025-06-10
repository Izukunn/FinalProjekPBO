package benda_geometri;

public class LimasTrapesium extends Trapesium implements Benda3D {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public LimasTrapesium(double sisiAtas, double sisiBawah, double sisiKiri, double sisiKanan, double tinggiAlas, double tinggi) throws InvalidInputException {
        super(sisiAtas, sisiBawah, sisiKiri, sisiKanan, tinggiAlas);
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
        double tinggiSegitigaAtas = Math.sqrt(Math.pow((sisiBawah - sisiAtas) / 2, 2) + Math.pow(tinggi, 2));
        double tinggiSegitigaKiri = Math.sqrt(Math.pow((sisiKanan - sisiKiri) / 2, 2) + Math.pow(tinggi, 2));
        double luasSegitigaAtas = sisiAtas * tinggiSegitigaAtas / 2;
        double luasSegitigaBawah = sisiBawah * tinggiSegitigaAtas / 2;
        double luasSegitigaKiri = sisiKiri * tinggiSegitigaKiri / 2;
        double luasSegitigaKanan = sisiKanan * tinggiSegitigaKiri / 2;
        luasPermukaan = super.luas + luasSegitigaAtas + luasSegitigaBawah + luasSegitigaKiri + luasSegitigaKanan;
    }

    @Override
    public String tampilkanInfo() {
    return "=== LIMAS TRAPESIUM ===\n"
            + "Sisi Atas\t: " + sisiAtas + "\n"
            + "Sisi Bawah\t: " + sisiBawah + "\n"
            + "Sisi Kiri\t: " + sisiKiri + "\n"
            + "Sisi Kanan\t: " + sisiKanan + "\n"
            + "Tinggi Alas\t: " + tinggiAlas + "\n"
            + "Tinggi Limas\t: " + tinggi + "\n"
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
