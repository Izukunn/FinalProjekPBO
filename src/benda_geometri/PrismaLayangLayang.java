package benda_geometri;

public class PrismaLayangLayang extends LayangLayang implements Benda3D, Runnable {

    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    // Constructor utama
    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang, double tinggiPrisma)
            throws InvalidInputException {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
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
        return "=== PRISMA LAYANG-LAYANG ===\n" +
                "Diagonal 1\t: " + getDiagonal1() + "\n" +
                "Diagonal 2\t: " + getDiagonal2() + "\n" +
                "Sisi Pendek\t: " + getSisiPendek() + "\n" +
                "Sisi Panjang\t: " + getSisiPanjang() + "\n" +
                "Tinggi Prisma\t: " + tinggiPrisma + "\n" +
                "Luas Alas\t: " + getLuas() + "\n" +
                "Keliling Alas\t: " + getKeliling() + "\n" +
                "Volume\t\t: " + volume + "\n" +
                "Luas Permukaan\t: " + luasPermukaan;
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

