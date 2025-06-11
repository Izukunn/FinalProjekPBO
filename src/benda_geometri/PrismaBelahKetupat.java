package benda_geometri;

public class PrismaBelahKetupat extends BelahKetupat implements Benda3D, Runnable {

    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggiPrisma)
            throws InvalidInputException {
        super(diagonal1, diagonal2, sisi);
        setTinggiPrisma(tinggiPrisma);
        hitungLuas();
        hitungKeliling();
        hitungVolume();
        hitungLuasPermukaan();
    }

    // Getter dan Setter
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
        volume = super.getLuas() * tinggiPrisma;
    }

    @Override
    public void hitungLuasPermukaan() {
        luasPermukaan = (2 * super.getLuas()) + (super.getKeliling() * tinggiPrisma);
    }

    @Override
    public void hitungLuas() {
        super.hitungLuas();
    }

    @Override
    public void hitungKeliling() {
        super.hitungKeliling();
    }

    @Override
    public String tampilkanInfo() {
        return "=== PRISMA_BELAH_KETUPAT ===\n"
                + "Diagonal 1: " + getDiagonal1() + "\n"
                + "Diagonal 2: " + getDiagonal2() + "\n"
                + "Sisi: " + getSisi() + "\n"
                + "Tinggi Prisma: " + tinggiPrisma + "\n"
                + "Volume: " + volume + "\n"
                + "Luas Permukaan: " + luasPermukaan;
    }

    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }
}
