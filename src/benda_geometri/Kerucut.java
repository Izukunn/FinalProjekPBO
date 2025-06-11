package benda_geometri;

public class Kerucut extends Lingkaran implements Benda3D {

    public double tinggi;
    public double garisPelukis;
    public double volume;
    public double luasPermukaan;

    public Kerucut() {
        super();
        this.tinggi = 20;
        hitungVolume();
        hitungLuasPermukaan();
    }

    public Kerucut(double radius, double tinggi) throws InvalidInputException {
        super(radius);
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
        this.garisPelukis = hitungGarisPelukis();
        hitungVolume();
        hitungLuasPermukaan();
    }

    public Kerucut(double radius, double tinggi, double customPi) throws InvalidInputException {
        super(radius, customPi);
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
        this.garisPelukis = hitungGarisPelukis();
        hitungVolume();
        hitungLuasPermukaan();
    }

    private double hitungGarisPelukis() {
        return Math.sqrt(Math.pow(radius, 2) + Math.pow(tinggi, 2));
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
        return "=== KERUCUT ===\n"
                + "Radius\t: " + radius + "\n"
                + "pi\t: " + super.pi + "\n"
                + "Tinggi\t: " + tinggi + "\n"
                + "Garis Pelukis: " + garisPelukis + "\n"
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
