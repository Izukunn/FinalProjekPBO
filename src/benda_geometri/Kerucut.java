package benda_geometri;

public class Kerucut extends Lingkaran implements Benda3D, Runnable {

    public double tinggi;
    public double garisPelukis;
    public double volume;
    public double luasPermukaan;
    public String errorMessage;

    public Kerucut(double radius, double tinggi) throws InvalidInputException {
        super(radius);
        try {
            if (tinggi < 0) {
                throw new InvalidInputException("Tinggi tidak boleh negatif!");
            }
            this.tinggi = tinggi;
            this.garisPelukis = hitungGarisPelukis();
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            this.errorMessage = e.getMessage();
        }
    }

    public Kerucut(double radius, double tinggi, double customPi) throws InvalidInputException {
        super(radius, customPi);
        try {
            if (tinggi < 0) {
                throw new InvalidInputException("Tinggi tidak boleh negatif!");
            }
            this.tinggi = tinggi;
            this.garisPelukis = hitungGarisPelukis();
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            this.errorMessage = e.getMessage();
        }
    }

    private double hitungGarisPelukis() {
        return Math.sqrt(Math.pow(radius, 2) + Math.pow(tinggi, 2));
    }
    
    public String getErrorMessage() { 
        return errorMessage; 
    }

    @Override
    public void hitungVolume() {
        super.hitungLuas();
        volume = (super.luas * tinggi) / 3;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungKeliling();
        super.hitungLuas();
        luasPermukaan = (pi * radius * garisPelukis) + super.luas;
    }

    @Override
    public String tampilkanInfo() {
        if (errorMessage != null) {
            return "Error: " + errorMessage;
        }
        return "\n=== KERUCUT ===\n"
                + "Radius\t: " + radius + "\n"
                + "pi\t: " + super.pi + "\n"
                + "Tinggi\t: " + tinggi + "\n"
                + "Garis Pelukis: " + garisPelukis + "\n"
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
