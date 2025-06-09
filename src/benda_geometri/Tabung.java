package benda_geometri;

public class Tabung extends Lingkaran implements Benda3D {

    private double tinggi;
    private double volume;
    private double luasPermukaan;
    
    public Tabung() {
        super();
        this.tinggi = 20;
        hitungVolume();
        hitungLuasPermukaan();
    }

    public Tabung(double radius, double tinggi) throws InvalidInputException {
        super(radius);
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
        hitungVolume();
        hitungLuasPermukaan();
    }
    
    public Tabung(double radius, double tinggi, double customPi) throws InvalidInputException {
        super(radius, customPi);
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
        hitungVolume();
        hitungLuasPermukaan();
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
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Tabung");
        System.out.println("Radius\t: " + radius);
        System.out.println("pi\t: " + super.pi);
        System.out.println("Tinggi\t: " + tinggi);
        System.out.println("Volume\t: " + volume);
        System.out.println("Luas Permukaan\t: " + luasPermukaan);
    }

    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }
}
