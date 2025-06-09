package benda_geometri;

public class PrismaPersegi extends Persegi implements Benda3D {

    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public PrismaPersegi(double sisi, double tinggi) throws InvalidInputException {
        super(sisi);
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
        System.out.println("Bangun\t: Prisma Persegi");
        System.out.println("Sisi Alas\t: " + sisi);
        System.out.println("Tinggi\t: " + tinggi);
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
