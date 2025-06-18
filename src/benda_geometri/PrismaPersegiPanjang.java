package benda_geometri;

public class PrismaPersegiPanjang extends PersegiPanjang implements Benda3D, Runnable {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggi) throws InvalidInputException {
        super(panjang, lebar);
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
        hitungVolume();
        hitungLuasPermukaan();
    }

    @Override
    public void hitungVolume() {
        super.hitungLuas();
        volume = super.luas * tinggi;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungLuas();
        super.hitungKeliling();
        luasPermukaan = 2 * super.luas + (super.keliling * tinggi);
    }

    @Override
    public String tampilkanInfo() {
    return "=== PRISMA PERSEGI PANJANG ===\n"
            + "Panjang Alas\t: " + panjang + "\n"
            + "Lebar Alas\t: " + lebar + "\n"
            + "Tinggi\t: " + tinggi + "\n"
            + "Volume\t: " + volume + "\n"
            + "Luas Permukaan\t: " + luasPermukaan;
}

    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }
}
