package benda_geometri;

public class PrismaLayangLayang extends LayangLayang implements Benda3D, Runnable {

    public double tinggiPrisma;
    public double volume;
    public double luasPermukaan;

    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang, double tinggiPrisma)
            throws InvalidInputException {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
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
        volume = luas * tinggiPrisma;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungLuas();
        super.hitungKeliling();
        luasPermukaan = (2 * luas) + (keliling * tinggiPrisma);
    }

    @Override
    public String tampilkanInfo() {
        return "=== PRISMA LAYANG-LAYANG ===\n"
                + "Diagonal 1\t: " + diagonal1 + "\n"
                + "Diagonal 2\t: " + diagonal2 + "\n"
                + "Sisi Pendek\t: " + sisiPendek + "\n"
                + "Sisi Panjang\t: " + sisiPanjang + "\n"
                + "Tinggi Prisma\t: " + tinggiPrisma + "\n"
                + "Luas Alas\t: " + luas + "\n"
                + "Keliling Alas\t: " + keliling + "\n"
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
