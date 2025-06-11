package benda_geometri;

public class CincinBola extends Bola implements Benda3D {
    private double radiusDalam;
    private double volume;
    private double luasPermukaan;

    public CincinBola() {
        super();
        this.radiusDalam = 5;
        hitungVolume();
        hitungLuasPermukaan();
    }
    
    public CincinBola(double radiusLuar, double radiusDalam) throws InvalidInputException {
        super(radiusLuar);
        if (radiusDalam < 0) throw new InvalidInputException("Radius tidak boleh negatif!");
        this.radiusDalam = radiusDalam;
        hitungVolume();
        hitungLuasPermukaan();
    }
    
    public CincinBola(double radiusLuar, double radiusDalam, double customPi) throws InvalidInputException {
        super(radiusLuar, customPi);
        if (radiusDalam < 0) throw new InvalidInputException("Radius tidak boleh negatif!");
        this.radiusDalam = radiusDalam;
        hitungVolume();
        hitungLuasPermukaan();
    }

    @Override
    public void hitungVolume() {
        super.hitungVolume();
        volume = super.volume - (4/3 * super.pi * Math.pow(radiusDalam, 3));
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungLuasPermukaan();
        luasPermukaan = super.luasPermukaan + (4 * super.pi * Math.pow(radiusDalam, 2));
    }

    @Override
    public String tampilkanInfo() {
        return "=== CINCIN BOLA ===\n"
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
