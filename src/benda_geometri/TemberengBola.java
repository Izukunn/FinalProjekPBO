package benda_geometri;

public class TemberengBola implements Benda3D {

    private double radiusBola;
    private double pi;
    private double tinggiTembereng;
    private double volume;
    private double luasPermukaan;

    public TemberengBola(double radiusBola, double tinggiTembereng) throws InvalidInputException {
        if (radiusBola < 0 || tinggiTembereng < 0) {
            throw new InvalidInputException("Input tidak boleh negatif!");
        }
        this.radiusBola = radiusBola;
        this.tinggiTembereng = tinggiTembereng;
    }

    @Override
    public void hitungVolume() {
        volume = (pi * Math.pow(tinggiTembereng, 2)
                * (3 * radiusBola - tinggiTembereng)) / 6; // Volume = πh²(3R - h)/6
    }

    @Override
    public void hitungLuasPermukaan() {
        luasPermukaan = 2 * pi * radiusBola * tinggiTembereng; // Luas = 2πRh
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Tembereng Bola");
        System.out.println("Radius Bola\t: " + radiusBola);
        System.out.println("pi\t: " + pi);
        System.out.println("Tinggi Tembereng\t: " + tinggiTembereng);
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
