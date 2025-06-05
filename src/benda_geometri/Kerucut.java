package benda_geometri;

public class Kerucut extends Lingkaran implements Benda3D {

    private double tinggi;
    private double garisPelukis;

    public Kerucut(double radius, double tinggi, double garisPelukis) throws NegativeInputException {
        super(radius);
        setTinggi(tinggi);
        setGarisPelukis(garisPelukis);
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) throws NegativeInputException {
        if (tinggi < 0) {
            throw new NegativeInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
    }

    public double getGarisPelukis() {
        return garisPelukis;
    }

    public void setGarisPelukis(double garisPelukis) throws NegativeInputException {
        if (garisPelukis < 0) {
            throw new NegativeInputException("Garis Pelukis tidak boleh negatif!");
        }
        this.garisPelukis = garisPelukis;
    }

    @Override
    public double hitungVolume() {
        return (1.0 / 3) * Math.PI * Math.pow(getRadius(), 2) * tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        return Math.PI * getRadius() * (getRadius() + garisPelukis);
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Kerucut");
        System.out.println("Radius\t: " + getRadius());
        System.out.println("Tinggi\t: " + getTinggi());
        System.out.println("Garis Pelukis\t: " + getGarisPelukis());
        System.out.println("Volume\t: " + hitungVolume());
        System.out.println("Luas Permukaan\t: " + hitungLuasPermukaan());
    }
}
