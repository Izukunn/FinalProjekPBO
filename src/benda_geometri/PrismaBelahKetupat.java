package benda_geometri;

public class PrismaBelahKetupat extends BelahKetupat implements Benda3D, Runnable {

    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

<<<<<<< HEAD
    // Constructor default (nilai dummy valid)
    public PrismaBelahKetupat() {
        this.tinggiPrisma = 1.0;
        hitungVolume();
        hitungLuasPermukaan();
    }

=======
>>>>>>> dcaa7a787733875dffc8e33304b3d9deba7d7575
    // Constructor utama
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
<<<<<<< HEAD
        return "=== PRISMA BELAH KETUPAT ===\n"
                + "Diagonal 1\t: " + getDiagonal1() + "\n"
                + "Diagonal 2\t: " + getDiagonal2() + "\n"
                + "Sisi\t\t: " + getSisi() + "\n"
                + "Tinggi Prisma\t: " + tinggiPrisma + "\n"
                + "Volume\t\t: " + volume + "\n"
                + "Luas Permukaan\t: " + luasPermukaan;
=======
        return "=== PRISMA BELAH KETUPAT ===\n" +
                "Diagonal 1\t: " + getDiagonal1() + "\n" +
                "Diagonal 2\t: " + getDiagonal2() + "\n" +
                "Sisi\t\t: " + getSisi() + "\n" +
                "Tinggi Prisma\t: " + tinggiPrisma + "\n" +
                "Luas Alas\t: " + getLuas() + "\n" +
                "Keliling Alas\t: " + getKeliling() + "\n" +
                "Volume\t\t: " + volume + "\n" +
                "Luas Permukaan\t: " + luasPermukaan;
>>>>>>> dcaa7a787733875dffc8e33304b3d9deba7d7575
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
