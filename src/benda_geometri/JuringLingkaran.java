package benda_geometri;

public class JuringLingkaran extends Lingkaran implements Runnable {

    private double sudut;
    private double luas;
    private double keliling;

    public JuringLingkaran() {
        super();
        this.sudut = 60;
        hitungLuas();
        hitungKeliling();
    }

    public JuringLingkaran(double radius) throws InvalidInputException {
        super(radius);
        this.sudut = 60;
        hitungLuas();
        hitungKeliling();
    }

    public JuringLingkaran(double radius, double sudut) throws InvalidInputException {
        super(radius);
        if (sudut < 0 || sudut > 360) {
            throw new InvalidInputException("Sudut harus antara 0 dan 360 derajat!");
        }
        this.sudut = sudut;
        hitungLuas();
        hitungKeliling();
    }

    public JuringLingkaran(double radius, double sudut, double customPi) throws InvalidInputException {
        super(radius, customPi);
        if (sudut < 0 || sudut > 360) {
            throw new InvalidInputException("Sudut harus antara 0 dan 360 derajat!");
        }
        this.sudut = sudut;
        hitungLuas();
        hitungKeliling();
    }

    @Override
    public void hitungLuas() {
        super.hitungLuas();
        luas = (sudut / 360.0) * super.luas;
    }

    @Override
    public void hitungKeliling() {
        super.hitungKeliling();
        keliling = ((sudut / 360.0) * super.keliling) + 2 * radius;
    }

    @Override
    public String tampilkanInfo() {
        return "=== JURING LINGKARAN ===\n"
                + "Radius\t: " + radius + "\n"
                + "pi\t: " + super.pi + "\n"
                + "Sudut\t: " + sudut + "\n"
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
