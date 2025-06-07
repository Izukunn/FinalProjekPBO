package benda_geometri;

public class JuringLingkaran extends Lingkaran {

    private double sudut;
    private double luas;
    private double keliling;

    public JuringLingkaran(double radius, double sudut) throws InvalidInputException {
        super(radius);
        if (sudut < 0 || sudut > 360) {
            throw new InvalidInputException("Sudut harus antara 0 dan 360 derajat!");
        }
        this.sudut = sudut;
    }

    @Override
    public void hitungLuas() {
        luas = (sudut / 360.0) * super.luas;
    }

    @Override
    public void hitungKeliling() {
        keliling = ((sudut / 360.0) * super.keliling) + 2 * radius;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Juring Lingkaran");
        System.out.println("Radius\t: " + radius);
        System.out.println("Sudut\t: " + sudut);
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
