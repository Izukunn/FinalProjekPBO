package benda_geometri;

public class TemberengBola implements Benda3D, Runnable {

    private double radiusBola;
    private double pi = Math.PI;
    private double tinggiTembereng;
    private double volume;
    private double luasPermukaan;

    public TemberengBola(double radiusBola, double tinggiTembereng) throws InvalidInputException {
        try {
            if (radiusBola < 0 || tinggiTembereng < 0) {
                throw new InvalidInputException("Input tidak boleh negatif!");
            } else if (radiusBola < tinggiTembereng) {
                throw new InvalidInputException("Tinggi tembereng tidak boleh lebih besar daripada radius bola!");
            }
            this.radiusBola = radiusBola;
            this.tinggiTembereng = tinggiTembereng;
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public TemberengBola(double radiusBola, double tinggiTembereng, double customPi) throws InvalidInputException {
        try {
            if (radiusBola < 0) {
                throw new InvalidInputException("Input tidak boleh negatif!");
            } else if (radiusBola < tinggiTembereng) {
                throw new InvalidInputException("Tinggi tembereng tidak boleh lebih besar daripada radius bola!");
            }
            this.radiusBola = radiusBola;
            if (tinggiTembereng < 0) {
                throw new InvalidInputException("Input tidak boleh negatif!");
            }
            this.tinggiTembereng = tinggiTembereng;
            this.pi = customPi;
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void hitungVolume() {
        volume = (pi * Math.pow(tinggiTembereng, 2)
                * (3 * radiusBola - tinggiTembereng)) / 6;
    }

    @Override
    public void hitungLuasPermukaan() {
        luasPermukaan = 2 * pi * radiusBola * tinggiTembereng;
    }

    @Override
    public String tampilkanInfo() {
        return "\n=== TEMBERENG BOLA ===\n"
                + "Radius Bola: " + radiusBola + "\n"
                + "Tinggi Tembereng: " + tinggiTembereng + "\n"
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
