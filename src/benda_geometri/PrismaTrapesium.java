package benda_geometri;

public class PrismaTrapesium extends Trapesium implements Benda3D {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public PrismaTrapesium(double sisiAtas, double sisiBawah, double sisiKiri, double sisiKanan, double tinggiAlas, double tinggi) throws InvalidInputException {
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
    return "=== PRISMA TRAPESIUM ===\n"
            + "Sisi Atas\t: " + sisiAtas + "\n"
            + "Sisi Bawah\t: " + sisiBawah + "\n"
            + "Sisi Kiri\t: " + sisiKiri + "\n"
            + "Sisi Kanan\t: " + sisiKanan + "\n"
            + "Tinggi Alas\t: " + tinggiAlas + "\n"
            + "Tinggi Prisma\t: " + tinggi + "\n"
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
