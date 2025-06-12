package benda_geometri;

public class PrismaBelahKetupat extends BelahKetupat implements Benda3D, Runnable {
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaBelahKetupat() throws InvalidInputException {
        super(6, 8, 5);  
        this.tinggiPrisma = 10;
        hitungVolume();
        hitungLuasPermukaan();
    }

    public PrismaBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggiPrisma) 
            throws InvalidInputException {
        super(diagonal1, diagonal2, sisi);
        if (tinggiPrisma < 0) {
            throw new InvalidInputException("Tinggi prisma tidak boleh negatif!");
        }
        this.tinggiPrisma = tinggiPrisma;
        hitungVolume();
        hitungLuasPermukaan();
    }

    @Override
    public void hitungVolume() {
        super.hitungLuas();
        volume = super.luas * tinggiPrisma;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungKeliling();
        super.hitungLuas();
        double kelilingAlas = super.keliling;
        luasPermukaan = (2 * super.luas) + (kelilingAlas * tinggiPrisma);
    }

    @Override
    public String tampilkanInfo() {
        return "=== PRISMA BELAH KETUPAT ===\n"
                + "Diagonal 1\t: " + super.diagonal1 + "\n"
                + "Diagonal 2\t: " + super.diagonal2 + "\n"
                + "Sisi\t\t: " + super.sisi + "\n"
                + "Tinggi Prisma\t: " + tinggiPrisma + "\n"
                + "Volume\t\t: " + volume + "\n"
                + "Luas Permukaan\t: " + luasPermukaan;
    }
    
    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }
}
