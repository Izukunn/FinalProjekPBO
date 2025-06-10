package benda_geometri;

public class Bola extends Lingkaran implements Benda3D {

    public double volume;
    public double luasPermukaan;

    public Bola() {
        super();
        hitungVolume();
        hitungLuasPermukaan();
    }
    
    public Bola(double radius) throws InvalidInputException {
        super(radius);
        hitungVolume();
        hitungLuasPermukaan();
    }
    
    public Bola(double radius, double customPi) throws InvalidInputException {
        super(radius, customPi);
        hitungVolume();
        hitungLuasPermukaan();
    }

    @Override
    public void hitungVolume() {
        volume = (4.0 / 3) * super.pi * Math.pow(radius, 3);
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungLuas();
        luasPermukaan = 4 * super.luas;
    }

    @Override
    public String tampilkanInfo() {
        return "=== BOLA ===\n"
                + "Radius\t: " + radius + "\n"
                + "pi\t: " + super.pi + "\n"
                + "Volume\t: " + volume + "\n"
                + "Luas Permukaan: " + luasPermukaan;
    }

    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }
}
