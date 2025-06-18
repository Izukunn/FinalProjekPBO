package benda_geometri;

public class Lingkaran implements Benda2D, Runnable {

    public double radius;
    public double pi = Math.PI;
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
    public String tampilkanInfo() {
        return "=== LINGKARAN ===\n"
                + "Radius\t: " + radius + "\n"
                + "pi\t: " + pi + "\n"
                + "Luas\t: " + luas + "\n"
                + "Keliling: " + keliling;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            hitungLuas();
            Thread.sleep(1000);
            hitungKeliling();
            tampilkanInfo();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted");
        }
    }
}
