package benda_geometri;

public class LimasBelahKetupat extends BelahKetupat implements Benda3D, Runnable {

    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    // Constructor default (nilai dummy valid)
    public LimasBelahKetupat() {
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
    public LimasBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggiPrisma)
            throws NegativeInputException {
        super(diagonal1, diagonal2, sisi);
        setTinggiPrisma(tinggiPrisma);
        hitungVolume();
        hitungLuasPermukaan();
    }

    // Setter dan Getter
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
        volume = (1.0 / 3) * super.hitungLuas() * tinggiPrisma;
        return volume;
    }

    // Perhitungan luas permukaan
    @Override
    public double hitungLuasPermukaan() {
        // Estimasi tinggi segitiga selimut menggunakan Pythagoras
        double tinggiSegitiga = Math.sqrt(Math.pow(tinggiPrisma, 2) + Math.pow(getSisi(), 2) / 4);
        double luasSelimut = 4 * (0.5 * getSisi() * tinggiSegitiga);
        luasPermukaan = super.hitungLuas() + luasSelimut;
        return luasPermukaan;
    }

    // Tampilkan info lengkap
    @Override
    public void tampilkanInfo() {
        System.out.println("=== LIMAS BELAH KETUPAT ===");
        System.out.println("Diagonal 1\t: " + getDiagonal1());
        System.out.println("Diagonal 2\t: " + getDiagonal2());
        System.out.println("Sisi\t\t: " + getSisi());
        System.out.println("Tinggi Prisma\t: " + tinggiPrisma);
        System.out.println("Volume\t\t: " + volume);
        System.out.println("Luas Permukaan\t: " + luasPermukaan);
    }

    // Implementasi Runnable
    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }

    // Penanganan default konstruktor superclass yang butuh parameter
    private static void superDummy() {
        try {
            new BelahKetupat(1, 1, 1); // dummy object to initialize superclass
        } catch (NegativeInputException e) {
            // Tidak akan terjadi karena input valid
        }
    }
}
