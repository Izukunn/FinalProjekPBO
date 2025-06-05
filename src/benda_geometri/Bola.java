package benda_geometri;

public class Bola extends Lingkaran implements Benda3D {

    public Bola(double radius) throws NegativeInputException {
        super(radius);
    }

    @Override
    public double hitungVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(getRadius(), 3);
    }

    @Override
    public double hitungLuasPermukaan() {
        return 4 * Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Bola");
        System.out.println("Radius\t: " + getRadius());
        System.out.println("Volume\t: " + hitungVolume());
        System.out.println("Luas Permukaan\t: " + hitungLuasPermukaan());
    }
}
