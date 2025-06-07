package benda_geometri;

public class Lingkaran implements Benda2D {

    public double radius;
    public double pi = 3.14;
    public double luas;
    public double keliling;

    public Lingkaran(double radius) throws InvalidInputException {
        if (radius < 0) {
            throw new InvalidInputException("Radius tidak boleh negatif!");
        }
        this.radius = radius;
        hitungLuas();  // Hitung saat inisialisasi
        hitungKeliling();
    }

    @Override
    public void hitungLuas() {
        luas = pi * radius * radius;
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
}
