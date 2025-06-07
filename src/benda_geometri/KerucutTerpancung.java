package benda_geometri;

public class KerucutTerpancung implements Benda3D {

    private double radiusBawah;
    private double radiusAtas;
    private double pi = 3.14;
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public KerucutTerpancung(double radiusBawah, double radiusAtas, double tinggi) throws InvalidInputException {
        if (radiusBawah < 0 || radiusAtas < 0 || tinggi < 0) {
            throw new InvalidInputException("Input tidak boleh negatif!");
        }
        this.radiusBawah = radiusBawah;
        this.radiusAtas = radiusAtas;
        this.tinggi = tinggi;
    }

    @Override
    public void hitungVolume() {
        volume = (1.0 / 3) * pi * tinggi* (Math.pow(radiusBawah, 2) + Math.pow(radiusAtas, 2) + (radiusBawah * radiusAtas));
    }

    @Override
    public void hitungLuasPermukaan() {
        double garisPelukis = Math.sqrt(Math.pow(tinggi, 2) + Math.pow(radiusBawah - radiusAtas, 2));
        luasPermukaan = pi * (Math.pow(radiusBawah, 2) + Math.pow(radiusAtas, 2)
                + (radiusBawah + radiusAtas) * garisPelukis);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Kerucut Terpancung");
        System.out.println("Radius Bawah\t: " + radiusBawah);
        System.out.println("Radius Atas\t: " + radiusAtas);
        System.out.println("Pi\t: " + pi);
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
