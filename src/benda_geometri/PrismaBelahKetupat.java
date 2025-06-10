package benda_geometri;

public class PrismaBelahKetupat extends BelahKetupat implements Benda3D, Runnable {

    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    // Constructor default
    public PrismaBelahKetupat() {
        superDummy();
        try {
            this.tinggiPrisma = 1.0;
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    // Constructor utama
    public PrismaBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggiPrisma)
            throws InvalidInputException {
        super(diagonal1, diagonal2, sisi);
        setTinggiPrisma(tinggiPrisma);
        hitungVolume();
        hitungLuasPermukaan();
    }

    // Getter & Setter
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

    // hitungLuas ➜ void
    @Override
    public void hitungLuas() {
        super.hitungLuas();
    }

    // hitungKeliling ➜ void
    @Override
    public void hitungKeliling() {
        super.hitungKeliling();
    }

    // hitungVolume ➜ void
    @Override
    public void hitungVolume() {
        volume = super.hitungLuas() * tinggiPrisma;
    }

    // hitungLuasPermukaan ➜ void
    @Override
    public void hitungLuasPermukaan() {
        luasPermukaan = (2 * super.hitungLuas()) + (super.hitungKeliling() * tinggiPrisma);
    }

    // tampilkanInfo ➜ String
    @Override
    public String tampilkanInfo() {
        return "=== PRISMA BELAH KETUPAT ===\n" +
               "Diagonal 1\t: " + getDiagonal1() + "\n" +
               "Diagonal 2\t: " + getDiagonal2() + "\n" +
               "Sisi\t\t: " + getSisi() + "\n" +
               "Tinggi Prisma\t: " + tinggiPrisma + "\n" +
               "Volume\t\t: " + volume + "\n" +
               "Luas Permukaan\t: " + luasPermukaan + "\n";
    }

    // Implementasi Runnable
    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        System.out.println(tampilkanInfo());
    }

    // Dummy super konstruktor (untuk constructor default)
    private static void superDummy() {
        try {
            new BelahKetupat(1, 1, 1);
        } catch (InvalidInputException e) {
            // Tidak error
        }
    }
}
