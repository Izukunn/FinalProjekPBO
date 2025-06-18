package benda_geometri;

public class PrismaJajaranGenjang extends JajaranGenjang implements Benda3D, Runnable {

    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaJajaranGenjang() throws InvalidInputException {
        super(6, 4, 5);
        this.tinggiPrisma = 12;
        hitungVolume();
        hitungLuasPermukaan();
    }

    public PrismaJajaranGenjang(double alas, double tinggiJajar, double sisiMiring, double tinggiPrisma) throws InvalidInputException {
        super(alas, tinggiJajar, sisiMiring);
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
        return "=== PRISMA JAJARAN GENJANG ===\n"
                + "Alas\t: " + getAlas() + "\n"
                + "Tinggi Jajargenjang: " + getTinggi() + "\n"
                + "Sisi Miring\t: " + getSisiMiring() + "\n"
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
