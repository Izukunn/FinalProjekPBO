package benda_geometri;

public class Kerucut extends Lingkaran implements Benda3D {

    private double tinggi;
    private double garisPelukis;
    private double volume;
    private double luasPermukaan;

    public Kerucut(double radius, double tinggi, double garisPelukis) throws InvalidInputException {
        super(radius);
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
        if (garisPelukis < 0) {
            throw new InvalidInputException("Garis Pelukis tidak boleh negatif!");
        }
        this.garisPelukis = garisPelukis;
    }

    @Override
    public void hitungVolume() {
        super.hitungLuas();
        volume = super.luas * tinggi;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungKeliling();
        luasPermukaan = (super.keliling * tinggi) + (2 * super.luas);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Kerucut");
        System.out.println("Radius\t: " + radius);
        System.out.println("Tinggi\t: " + tinggi);
        System.out.println("Garis Pelukis\t: " + garisPelukis);
        System.out.println("Volume\t: " + volume);
        System.out.println("Luas Permukaan\t: " + luasPermukaan);
    }
}
