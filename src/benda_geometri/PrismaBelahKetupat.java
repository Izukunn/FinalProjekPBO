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
        volume = super.hitungLuasReturn() * tinggiPrisma;
    }

    @Override
    public void hitungLuasPermukaan() {
        double kelilingAlas = super.hitungKelilingReturn();
        luasPermukaan = (2 * super.hitungLuasReturn()) + (kelilingAlas * tinggiPrisma);
    }

    @Override
    public String tampilkanInfo() {
        return "=== PRISMA BELAH KETUPAT ===\n"
                + "Diagonal 1\t: " + getDiagonal1() + "\n"
                + "Diagonal 2\t: " + getDiagonal2() + "\n"
                + "Sisi\t\t: " + getSisi() + "\n"
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
