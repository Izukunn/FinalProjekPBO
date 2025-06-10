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
        } catch (NegativeInputException e) {
            System.out.println(e.getMessage());
        }
    }

    // Constructor utama
    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang, double tinggiPrisma)
            throws NegativeInputException {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
        setTinggiPrisma(tinggiPrisma);
        hitungVolume();
        hitungLuasPermukaan();
    }

    // Getter dan Setter
    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) throws NegativeInputException {
        if (tinggiPrisma < 0) {
            throw new NegativeInputException("Tinggi prisma tidak boleh negatif!");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    // Perhitungan volume
    @Override
    public double hitungVolume() {
        volume = super.hitungLuas() * tinggiPrisma;
        return volume;
    }

    // Perhitungan luas permukaan
    @Override
    public double hitungLuasPermukaan() {
        luasPermukaan = (2 * super.hitungLuas()) + (super.hitungKeliling() * tinggiPrisma);
        return luasPermukaan;
    }

    // Implementasi Runnable
    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }

    // Tampilkan info lengkap
    @Override
    public void tampilkanInfo() {
        System.out.println("=== PRISMA LAYANG-LAYANG ===");
        System.out.println("Diagonal 1\t: " + getDiagonal1());
        System.out.println("Diagonal 2\t: " + getDiagonal2());
        System.out.println("Sisi Pendek\t: " + getSisiPendek());
        System.out.println("Sisi Panjang\t: " + getSisiPanjang());
        System.out.println("Tinggi Prisma\t: " + tinggiPrisma);
        System.out.println("Volume\t\t: " + volume);
        System.out.println("Luas Permukaan\t: " + luasPermukaan);
    }

    // Dummy super konstruktor untuk default
    private static void superDummy() {
        try {
            new LayangLayang(1, 1, 1, 1);
        } catch (NegativeInputException e) {
            // tidak akan error karena input valid
        }
    }
}
