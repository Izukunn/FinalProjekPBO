package benda_geometri;

public class Tabung extends Lingkaran implements Benda3D, Runnable {

    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public Tabung(double radius, double tinggi) throws InvalidInputException {
        super(radius);
        try {
            if (tinggi < 0) {
                throw new InvalidInputException("Tinggi tidak boleh negatif!");
            }
            this.tinggi = tinggi;
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public Tabung(double radius, double tinggi, double customPi) throws InvalidInputException {
        super(radius, customPi);
        try {
            if (tinggi < 0) {
                throw new InvalidInputException("Tinggi tidak boleh negatif!");
            }
            this.tinggi = tinggi;
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void hitungVolume() {
        super.hitungLuas();
        volume = super.luas * tinggi;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungLuas();
        super.hitungKeliling();
        luasPermukaan = 2 * super.luas + (super.keliling * tinggi);
    }

    @Override
    public String tampilkanInfo() {
        return "\n=== TABUNG ===\n"
                + "Radius\t: " + radius + "\n"
                + "pi\t: " + super.pi + "\n"
                + "Tinggi\t: " + tinggi + "\n"
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
