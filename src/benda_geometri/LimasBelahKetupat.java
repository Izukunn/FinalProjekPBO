package benda_geometri;

public class LimasBelahKetupat extends BelahKetupat implements Benda3D {

    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggiPrisma) throws InvalidInputException {
        super(diagonal1, diagonal2, sisi);
        setTinggiPrisma(tinggiPrisma);
        hitungVolume();
        hitungLuasPermukaan();
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) throws InvalidInputException {
        if (tinggiPrisma < 0) {
            throw new InvalidInputException("Tinggi prisma tidak boleh negatif!");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    @Override
    public void hitungVolume() {
        volume = (1.0 / 3) * super.getLuas() * tinggiPrisma;
    }

    @Override
    public void hitungLuasPermukaan() {
        double tinggiSegitiga = Math.sqrt(Math.pow(tinggiPrisma, 2) + Math.pow(getSisi(), 2) / 4);
        double luasSelimut = 4 * (0.5 * getSisi() * tinggiSegitiga);
        luasPermukaan = super.getLuas() + luasSelimut;
    }

    @Override
    public String tampilkanInfo() {
        return "=== LIMAS BELAH KETUPAT ===\n" +
                "Diagonal 1\t: " + getDiagonal1() + "\n" +
                "Diagonal 2\t: " + getDiagonal2() + "\n" +
                "Sisi\t\t: " + getSisi() + "\n" +
                "Tinggi Prisma\t: " + tinggiPrisma + "\n" +
                "Volume\t\t: " + volume + "\n" +
                "Luas Permukaan\t: " + luasPermukaan;
    }
}
