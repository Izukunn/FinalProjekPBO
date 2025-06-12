package benda_geometri;

public class LimasLayangLayang extends LayangLayang implements Benda3D {

    public double tinggiPrisma;
    public double volume;
    public double luasPermukaan;

    public LimasLayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang, double tinggiPrisma) 
            throws InvalidInputException {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
        if (tinggiPrisma < 0) {
            throw new InvalidInputException("Tinggi prisma tidak boleh negatif!");
        }
        this.tinggiPrisma = tinggiPrisma;
        hitungVolume();
        hitungLuasPermukaan();
    }

    @Override
    public void hitungVolume() {
        volume = (1.0 / 3) * luas * tinggiPrisma;
    }

    @Override
    public void hitungLuasPermukaan() {
        double tinggiSegitiga = Math.sqrt(Math.pow(tinggiPrisma, 2) + Math.pow(sisiPanjang, 2) / 4);
        double luasSelimut = 4 * (0.5 * sisiPanjang * tinggiSegitiga);
        luasPermukaan = luas + luasSelimut;
    }

    @Override
    public String tampilkanInfo() {
        return "=== LIMAS LAYANG-LAYANG ===\n"
                + "Diagonal 1\t: " + diagonal1 + "\n"
                + "Diagonal 2\t: " + diagonal2 + "\n"
                + "Sisi Pendek\t: " + sisiPendek + "\n"
                + "Sisi Panjang\t: " + sisiPanjang + "\n"
                + "Tinggi Prisma\t: " + tinggiPrisma + "\n"
                + "Volume\t\t: " + volume + "\n"
                + "Luas Permukaan\t: " + luasPermukaan;
    }

    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }
}
