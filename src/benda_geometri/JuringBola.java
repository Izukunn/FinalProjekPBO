package benda_geometri;

public class JuringBola implements Benda3D {

    private double radius;
    private double pi = 3.14;
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public JuringBola(double radius, double tinggi) throws InvalidInputException {
        if (radius < 0 || tinggi < 0) {
            throw new InvalidInputException("Input tidak boleh negatif!");
        }
        this.radius = radius;
        this.tinggi = tinggi;
    }

    @Override
    public void hitungVolume() {
        volume = (2.0 / 3) * pi * Math.pow(radius, 2) * tinggi; // Volume = ²⁄₃πr²h
    }

    @Override
    public void hitungLuasPermukaan() {
        luasPermukaan = pi * radius * (2 * tinggi + radius); // Luas = πr(2h + r)
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Juring Bola");
        System.out.println("Radius\t: " + radius);
        System.out.println("pi\t: " + pi);
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
