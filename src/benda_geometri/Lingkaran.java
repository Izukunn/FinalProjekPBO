package benda_geometri;

public class Lingkaran implements Benda2D {

    private double radius;

    public Lingkaran(double radius) throws NegativeInputException {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws NegativeInputException {
        if (radius < 0) {
            throw new NegativeInputException("Radius tidak boleh negatif!");
        }
        this.radius = radius;
    }

    @Override
    public double hitungLuas() {
        return Math.PI * radius * radius;
    }

    @Override
    public double hitungKeliling() {
        return 2 * Math.PI * radius;
    }

}
