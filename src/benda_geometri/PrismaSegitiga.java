package benda_geometri;

public class PrismaSegitiga extends Segitiga implements Benda3D {

    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaSegitiga() {
        super(5, 4);
        this.tinggiPrisma = 10;
        hitungVolume();
        hitungLuasPermukaan();
    }

    public PrismaSegitiga(double alas, double tinggiSegitiga, double tinggiPrisma) throws InvalidInputException {
        super(alas, tinggiSegitiga);
        if (tinggiPrisma < 0) {
            throw new InvalidInputException("Tinggi prisma tidak boleh negatif!");
        }
        this.tinggiPrisma = tinggiPrisma;
        hitungVolume();
        hitungLuasPermukaan();
    }

    @Override
    public void hitungVolume() {
        volume = super.hitungLuasReturn() * tinggiPrisma;
    }

    @Override
    public void hitungLuasPermukaan() {
        double kelilingAlas = super.hitungKelilingReturn();
        luasPermukaan = (2 * super.hitungLuasReturn()) + (kelilingAlas * tinggiPrisma);
    }

    @Override
    public String tampilkanInfo() {
        return "=== PRISMA SEGITIGA ===\n"
                + "Alas\t: " + getAlas() + "\n"
                + "Tinggi Segitiga: " + getTinggi() + "\n"
                + "Tinggi Prisma\t: " + tinggiPrisma + "\n"
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
