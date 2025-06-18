package benda_geometri;

public class Bola extends Lingkaran implements Benda3D, Runnable {

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
        super.hitungLuas();
        volume = (4.0 / 3) * super.luas * radius;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungKeliling();
        luasPermukaan = super.keliling / pi;
    }

    @Override
    public String tampilkanInfo() {
        return "=== BOLA ===\n"
                + "Radius\t: " + radius + "\n"
                + "pi\t: " + pi + "\n"
                + "Volume\t: " + volume + "\n"
                + "Luas Permukaan: " + luasPermukaan;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            hitungVolume();
            Thread.sleep(1000);
            hitungLuasPermukaan();
            tampilkanInfo();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted");
        }
    }
}
