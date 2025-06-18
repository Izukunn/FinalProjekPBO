package benda_geometri;

public class Bola extends Lingkaran implements Benda3D, Runnable {

    public double volume;
    public double luasPermukaan;
    public String errorMessage;

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
    
    public String getErrorMessage() { 
        return errorMessage; 
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
        if (errorMessage != null) {
            return "Error: " + errorMessage;
        }
        return "\n=== BOLA ===\n"
                + "Radius\t: " + radius + "\n"
                + "pi\t: " + pi + "\n"
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
