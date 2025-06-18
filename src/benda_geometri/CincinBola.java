package benda_geometri;

public class CincinBola extends Bola implements Benda3D, Runnable {

    private double radiusDalam;
    private double volume;
    private double luasPermukaan;

    public CincinBola(double radiusLuar, double radiusDalam) throws InvalidInputException {
        super(radiusLuar);
        try {
            if (radiusDalam < 0) {
                throw new InvalidInputException("Radius tidak boleh negatif!");
            } else if (radiusLuar < radiusDalam) {
                throw new InvalidInputException("Radius dalam tidak boleh lebih besar daripada radius luar!");
            }
            this.radiusDalam = radiusDalam;
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public CincinBola(double radiusLuar, double radiusDalam, double customPi) throws InvalidInputException {
        super(radiusLuar, customPi);
        try {
        if (radiusDalam < 0) {
            throw new InvalidInputException("Radius tidak boleh negatif!");
        } else if (radiusLuar < radiusDalam) {
            throw new InvalidInputException("Tinggi tembereng tidak boleh lebih besar daripada radius bola!");
        }
        this.radiusDalam = radiusDalam;
        hitungVolume();
        hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void hitungVolume() {
        super.hitungVolume();
        volume = super.volume - (4 / 3 * super.pi * Math.pow(radiusDalam, 3));
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungLuasPermukaan();
        luasPermukaan = super.luasPermukaan + (4 * super.pi * Math.pow(radiusDalam, 2));
    }

    @Override
    public String tampilkanInfo() {
        return "\n=== CINCIN BOLA ===\n"
                + "Radius Luar: " + super.radius + "\n"
                + "Radius Dalam: " + radiusDalam + "\n"
                + "pi\t: " + super.pi + "\n"
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
