package benda_geometri;

public class JuringBola implements Benda3D, Runnable {

    private double radius;
    private double pi = Math.PI;
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public JuringBola(double radius, double tinggi) throws InvalidInputException {
        try {
            if (radius < 0 || tinggi < 0) {
                throw new InvalidInputException("Input tidak boleh negatif!");
            } else if (radius < tinggi) {
                throw new InvalidInputException("Tinggi juring tidak boleh lebih besar daripada radius bola!");
            }
            this.radius = radius;
            this.tinggi = tinggi;
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public JuringBola(double radius, double tinggi, double customPi) throws InvalidInputException {
        try {
            if (radius < 0 || tinggi < 0) {
                throw new InvalidInputException("Input tidak boleh negatif!");
            } else if (radius < tinggi) {
                throw new InvalidInputException("Tinggi juring tidak boleh lebih besar daripada radius bola!");
            }
            this.radius = radius;
            this.tinggi = tinggi;
            this.pi = customPi;
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void hitungVolume() {
        volume = (2.0 / 3) * pi * Math.pow(radius, 2) * tinggi;
    }

    @Override
    public void hitungLuasPermukaan() {
        luasPermukaan = pi * radius * (2 * tinggi + radius);
    }

    @Override
    public String tampilkanInfo() {
        return "\n=== JURING BOLA ===\n"
                + "Radius Bola: " + radius + "\n"
                + "Tinggi Juring: " + tinggi + "\n"
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
