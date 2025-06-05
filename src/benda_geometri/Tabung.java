package benda_geometri;

public class Tabung extends Lingkaran implements Benda3D {

    private double tinggi;

    public Tabung(double radius, double tinggi) throws NegativeInputException {
        super(radius);
        setTinggi(tinggi);
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

    @Override
    public double hitungVolume() {
        return Math.PI * Math.pow(getRadius(), 2) * tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * Math.PI * getRadius() * (getRadius() + tinggi);
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Tabung");
        System.out.println("Radius\t: " + getRadius());
        System.out.println("Tinggi\t: " + getTinggi());
        System.out.println("Volume\t: " + hitungVolume());
        System.out.println("Luas Permukaan\t: " + hitungLuasPermukaan());
    }
}
