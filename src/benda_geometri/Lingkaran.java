package benda_geometri;

public class Lingkaran implements Benda2D, Runnable {

    public double radius;
    public double pi = Math.PI;
    public double luas;
    public double keliling;
    public String errorMessage;

    public Lingkaran(double radius) throws InvalidInputException {
        try {
            if (radius < 0) {
                throw new InvalidInputException("Radius tidak boleh negatif!");
            }
            this.radius = radius;
            hitungLuas();
            hitungKeliling();
        } catch (InvalidInputException e) {
            this.errorMessage = e.getMessage();
        } 
    }

    public Lingkaran(double radius, double customPi) throws InvalidInputException {
        try {
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
        } catch (InvalidInputException e) {
            this.errorMessage = e.getMessage();
        }
    }
    
    public String getErrorMessage() { 
        return errorMessage; 
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
        if (errorMessage != null) {
            return "Error: " + errorMessage;
        }
        return "\n=== LINGKARAN ===\n"
                + "Radius\t: " + radius + "\n"
                + "pi\t: " + pi + "\n"
                + "Luas\t: " + luas + "\n"
                + "Keliling: " + keliling;
    }

    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        tampilkanInfo();
    }
}
