package benda_geometri;

public class KerucutTerpancung extends Kerucut implements Benda3D, Runnable {

    private double radiusBawah;
    private double radiusAtas;
    private double tinggi;
    private double volume;
    private double luasPermukaan;
    private String errorMessage;

    public KerucutTerpancung(double radiusBawah, double radiusAtas, double tinggi) throws InvalidInputException {
        super(radiusBawah, tinggi);
        try {
            if (radiusAtas < 0) {
                throw new InvalidInputException("Input tidak boleh negatif!");
            } else if (radiusBawah < radiusAtas) {
                throw new InvalidInputException("Radius atas kerucut tidak boleh lebih besar daripada radius bawah!");
            }
            this.radiusAtas = radiusAtas;
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            this.errorMessage = e.getMessage();
        }
    }

    public KerucutTerpancung(double radiusBawah, double radiusAtas, double tinggi, double customPi) throws InvalidInputException {
        super(radiusBawah, tinggi, customPi);
        try {
            if (radiusAtas < 0) {
                throw new InvalidInputException("Input tidak boleh negatif!");
            } else if (radiusBawah < radiusAtas) {
                throw new InvalidInputException("Radius atas kerucut tidak boleh lebih besar daripada radius bawah!");
            }
            this.radiusAtas = radiusAtas;
            hitungVolume();
            hitungLuasPermukaan();
        } catch (InvalidInputException e) {
            this.errorMessage = e.getMessage();
        }
    }
    
    public String getErrorMessage() { 
        return errorMessage; 
    }

    @Override
    public void hitungVolume() {
        super.hitungVolume();
        volume = super.volume + (1.0 / 3) * pi * tinggi * (Math.pow(radiusAtas, 2) + (radiusBawah * radiusAtas));
    }

    @Override
    public void hitungLuasPermukaan() {
        double garisPelukis = Math.sqrt(Math.pow(tinggi, 2) + Math.pow(radiusBawah - radiusAtas, 2));
        luasPermukaan = pi * (Math.pow(radiusBawah, 2) + Math.pow(radiusAtas, 2)
                + (radiusBawah + radiusAtas) * garisPelukis);
    }

    @Override
    public String tampilkanInfo() {
        if (errorMessage != null) {
            return "Error: " + errorMessage;
        }
        return "\n=== Kerucut Terpancung ===\n"
                + "Radius Bawah: " + radiusBawah + "\n"
                + "Radius Atas: " + radiusAtas + "\n"
                + "Tinggi Kerucut: " + tinggi + "\n"
                + "Garis Pelukis: " + garisPelukis + "\n"
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
