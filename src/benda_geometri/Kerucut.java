package benda_geometri;

public class Kerucut extends Lingkaran implements Benda3D {

    private double tinggi;
    private double garisPelukis;
    private double volume;
    private double luasPermukaan;

    public Kerucut() {
        super();
        this.tinggi = 20;
        hitungVolume();
        hitungLuasPermukaan();
    }

    public Kerucut(double radius, double tinggi) throws InvalidInputException {
        super(radius);
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
        this.garisPelukis = hitungGarisPelukis();
        hitungVolume();
        hitungLuasPermukaan();
    }

    public Kerucut(double radius, double tinggi, double customPi) throws InvalidInputException {
        super(radius, customPi);
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
        this.garisPelukis = hitungGarisPelukis();
        hitungVolume();
        hitungLuasPermukaan();
    }

    private double hitungGarisPelukis() {
        return Math.sqrt(Math.pow(radius, 2) + Math.pow(tinggi, 2));
    }

    @Override
    public void hitungVolume() {
        super.hitungLuas();
        volume = (super.luas * tinggi) / 3;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungKeliling();
        super.hitungLuas();
        luasPermukaan = (pi * radius * garisPelukis) + super.luas;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Kerucut");
        System.out.println("Radius\t: " + radius);
        System.out.println("pi\t: " + super.pi);
        System.out.println("Tinggi\t: " + tinggi);
        System.out.println("Garis Pelukis\t: " + garisPelukis);
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
