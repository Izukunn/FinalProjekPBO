package benda_geometri;

public class Kerucut extends Lingkaran implements Benda3D {

    private double tinggi;
    private double garisPelukis;

    public Kerucut(double radius, double tinggi) throws NegativeInputException {
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
}
