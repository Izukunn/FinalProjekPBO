package benda_geometri;

public class LimasBelahKetupat extends BelahKetupat implements Benda3D, Runnable {

    public double tinggiPrisma;
    public double volume;
    public double luasPermukaan;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggiPrisma) 
            throws InvalidInputException {
        super(diagonal1, diagonal2, sisi);
        if (tinggiPrisma < 0) {
            throw new InvalidInputException("Tinggi prisma tidak boleh negatif!");
        }
        this.tinggiPrisma = tinggiPrisma;
        hitungVolume();
        hitungLuasPermukaan();
    }

    @Override
    public void hitungVolume() {
        super.hitungLuas();
        volume = (1.0 / 3) * luas * tinggiPrisma;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungLuas();
        double tinggiSegitiga = Math.sqrt(Math.pow(tinggiPrisma, 2) + Math.pow(sisi, 2) / 4);
        double luasSelimut = 4 * (0.5 * sisi * tinggiSegitiga);
        luasPermukaan = luas + luasSelimut;
    }

    @Override
    public String tampilkanInfo() {
        return "=== LIMAS BELAH KETUPAT ===\n"
                + "Diagonal 1\t: " + diagonal1 + "\n"
                + "Diagonal 2\t: " + diagonal2 + "\n"
                + "Sisi\t\t: " + sisi + "\n"
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
