package benda_geometri;

public class Bola implements Benda3D {

    private double radius;
    private double pi = 3.14;
    private double volume;
    private double luasPermukaan;

    public Bola() throws InvalidInputException {
        this.radius = 10;
    }
    
    public Bola(double radius) throws InvalidInputException {
        if (radius < 0) {
            throw new InvalidInputException("Radius tidak boleh negatif!");
        }
        this.radius = radius;
    }
    
    public Bola(double radius, double customPi) throws InvalidInputException {
        if (radius < 0) {
            throw new InvalidInputException("Radius tidak boleh negatif!");
        }
        this.radius = radius;
        if (customPi < 0) {
            throw new InvalidInputException("pi tidak boleh negatif!");
        }
        this.pi = customPi;
    }

    @Override
    public void hitungVolume() {
        volume = (4.0 / 3) * pi * Math.pow(radius, 3);
    }

    @Override
    public void hitungLuasPermukaan() {
        luasPermukaan = 4 * pi * Math.pow(radius, 2);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Bola");
        System.out.println("Radius\t: " + radius);
        System.out.println("pi\t: " + pi);
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
