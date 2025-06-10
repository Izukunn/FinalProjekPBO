package benda_geometri;

public class PrismaLayangLayang extends LayangLayang implements Benda3D, Runnable {

    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    // Constructor default (nilai dummy valid)
    public PrismaLayangLayang() {
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
    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang, double tinggiPrisma)
            throws InvalidInputException {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
        setTinggiPrisma(tinggiPrisma);
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

    // Perhitungan volume (void)
    @Override
    public void hitungVolume() {
        volume = super.getLuas() * tinggiPrisma;
    }

    // Perhitungan luas permukaan (void)
    @Override
    public void hitungLuasPermukaan() {
        luasPermukaan = (2 * super.getLuas()) + (super.getKeliling() * tinggiPrisma);
    }

    // Tampilkan info lengkap (String)
    @Override
    public String tampilkanInfo() {
        return "=== PRISMA LAYANG-LAYANG ===\n" +
                "Diagonal 1\t: " + getDiagonal1() + "\n" +
                "Diagonal 2\t: " + getDiagonal2() + "\n" +
                "Sisi Pendek\t: " + getSisiPendek() + "\n" +
                "Sisi Panjang\t: " + getSisiPanjang() + "\n" +
                "Tinggi Prisma\t: " + tinggiPrisma + "\n" +
                "Volume\t\t: " + volume + "\n" +
                "Luas Permukaan\t: " + luasPermukaan;
    }

    // Implementasi Runnable
    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        System.out.println(tampilkanInfo());
    }
}
