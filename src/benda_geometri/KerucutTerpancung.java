package benda_geometri;

public class KerucutTerpancung extends Kerucut {

    private double radiusAtas;
    private double radiusBawah;

    public KerucutTerpancung(double radiusBawah, double radiusAtas, double garisPelukis, double tinggi) throws InvalidInputException {
        super(radiusBawah, garisPelukis, tinggi);
        setRadiusBawah(radiusBawah);
        setRadiusAtas(radiusAtas);
    }

    public double getRadiusBawah() {
        return radiusBawah;
    }

    public void setRadiusBawah(double radiusBawah) throws InvalidInputException {
        if (radiusBawah < 0) {
            throw new InvalidInputException("Radius bawah tidak boleh negatif!");
        }
        this.radiusBawah = radiusBawah;
    }

    public double getRadiusAtas() {
        return radiusAtas;
    }

    public void setRadiusAtas(double radiusAtas) throws InvalidInputException {
        if (radiusAtas < 0) {
            throw new InvalidInputException("Radius tidak boleh negatif!");
        }
        this.radiusAtas = radiusAtas;
    }

    @Override
    public double hitungVolume() {
        return (1.0 / 3) * Math.PI * getTinggi() * (Math.pow(radiusBawah, 2) + (radiusBawah * radiusAtas) + Math.pow(radiusAtas, 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        double s = Math.sqrt(Math.pow(radiusBawah - radiusAtas, 2) + Math.pow(getTinggi(), 2));
        return Math.PI * (Math.pow(radiusBawah, 2) + Math.pow(radiusAtas, 2) + s * (radiusBawah + radiusAtas));
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Kerucut Terpancung");
        System.out.println("Radius Bawah\t: " + getRadiusBawah());
        System.out.println("Radius Atas\t: " + getRadiusAtas());
        System.out.println("Tinggi\t: " + getTinggi());
        System.out.println("Garis Pelukis\t: " + getGarisPelukis());
        System.out.println("Volume\t: " + hitungVolume());
        System.out.println("Luas Permukaan\t: " + hitungLuasPermukaan());
    }
}
