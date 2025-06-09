package benda_geometri;

public class PrismaTrapesium extends Trapesium implements Benda3D {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public PrismaTrapesium(double sisiAtas, double sisiBawah, double sisiKiri, double sisiKanan, double tinggiAlas, double tinggi) throws InvalidInputException {
        super(sisiAtas, sisiBawah, sisiKiri, sisiKanan, tinggiAlas);
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
    }

    @Override
    public void hitungVolume() {
        volume = super.luas * tinggi;
    }

    @Override
    public void hitungLuasPermukaan() {
        luasPermukaan = 2 * super.luas + (super.keliling * tinggi);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Prisma Trapesium");
        System.out.println("Sisi Atas\t: " + sisiAtas);
        System.out.println("Sisi Bawah\t: " + sisiBawah);
        System.out.println("Sisi Kiri\t: " + sisiKiri);
        System.out.println("Sisi Kanan\t: " + sisiKanan);
        System.out.println("Tinggi Alas\t: " + tinggiAlas);
        System.out.println("Tinggi Prisma\t: " + tinggi);
        System.out.println("Volume\t: " + volume);
        System.out.println("Luas Permukaan\t: " + luasPermukaan);
    }

    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }
}
