package benda_geometri;

public class Lingkaran implements Benda2D {

    public double radius;
    public double pi = 3.14;
    public double luas;
    public double keliling;

    public Lingkaran() {
        this.radius = 10;
        hitungLuas();
        hitungKeliling();
    }
    
    public Lingkaran(double radius) throws InvalidInputException {
        if (radius < 0) {
            throw new InvalidInputException("Radius tidak boleh negatif!");
        }
        this.radius = radius;
        hitungLuas();
        hitungKeliling();
    }

    public Lingkaran(double radius, double customPi) throws InvalidInputException {
        if (radius < 0) {
            throw new InvalidInputException("Radius tidak boleh negatif!");
        }
        this.radius = radius;
        if (customPi < 0) {
            throw new InvalidInputException("Pi tidak boleh negatif!");
        }
        this.pi = customPi;
        hitungLuas();
        hitungKeliling();
    }

    @Override
    public void hitungLuas() {
        luas = pi * Math.pow(radius, 2);
    }

    @Override
    public void hitungKeliling() {
        keliling = 2 * pi * radius;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Lingkaran");
        System.out.println("Radius\t: " + radius);
        System.out.println("pi\t: " + pi);
        System.out.println("Luas\t: " + luas);
        System.out.println("Keliling\t: " + keliling);
    }

    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        tampilkanInfo();
    }
}
