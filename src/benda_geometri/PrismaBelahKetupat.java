package benda_geometri;

public class PrismaBelahKetupat extends BelahKetupat implements Benda3D {

    private double tinggiPrisma;

    public PrismaBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggiPrisma) throws NegativeInputException {
        super(diagonal1, diagonal2, sisi);
        setTinggiPrisma(tinggiPrisma);
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) throws NegativeInputException {
        if (tinggiPrisma < 0) {
            throw new NegativeInputException("Tinggi prisma tidak boleh negatif!");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        // Volume prisma = luas alas * tinggi
        return super.hitungLuas() * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        // Luas permukaan = (2 * luas alas) + (keliling alas * tinggi)
        return (2 * super.hitungLuas()) + (super.hitungKeliling() * tinggiPrisma);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t\t: Prisma Belah Ketupat");
        System.out.println("Diagonal 1\t: " + getDiagonal1());
        System.out.println("Diagonal 2\t: " + getDiagonal2());
        System.out.println("Sisi\t\t: " + getSisi());
        System.out.println("Tinggi Prisma\t: " + getTinggiPrisma());
        System.out.println("Volume\t\t: " + hitungVolume());
        System.out.println("Luas Permukaan\t: " + hitungLuasPermukaan());
    }
}
