package benda_geometri;

public class LimasLayangLayang extends LayangLayang implements Benda3D, Runnable {

    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    // Constructor default (nilai dummy valid)
    public LimasLayangLayang() {
        superDummy();
        try {
            this.tinggiPrisma = 1.0;
            hitungVolume();
            hitungLuasPermukaan();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Constructor utama
    public LimasLayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang, double tinggiPrisma)
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
        volume = (1.0 / 3) * super.getLuas() * tinggiPrisma;
    }

    // Perhitungan luas permukaan (void)
    @Override
    public void hitungLuasPermukaan() {
        // Estimasi tinggi segitiga selimut menggunakan sisi panjang dan tinggi prisma
        double tinggiSegitiga = Math.sqrt(Math.pow(tinggiPrisma, 2) + Math.pow(getSisiPanjang(), 2) / 4);
        double luasSelimut = 4 * (0.5 * getSisiPanjang() * tinggiSegitiga);
        luasPermukaan = super.getLuas() + luasSelimut;
    }

    // Tampilkan info lengkap (String)
    @Override
    public String tampilkanInfo() {
        return "=== LIMAS LAYANG-LAYANG ===\n" +
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
