package benda_geometri;

public class TemberengLingkaran extends Lingkaran {

    private double sudut;
    private double tinggiSagitta;
    private double luas;
    private double keliling;

    public TemberengLingkaran(double radius, double sudut, double tinggiSagitta) throws InvalidInputException {
        super(radius);
        if (sudut < 0 || sudut > 360) {
            throw new InvalidInputException("Sudut harus antara 0 dan 360 derajat!");
        }
        this.sudut = sudut;
        if (tinggiSagitta < 0) {
            throw new InvalidInputException("Tinggi sagitta tidak boleh negatif!");
        } else if (tinggiSagitta > 2 * radius) {
            throw new InvalidInputException("Tinggi sagitta tidak boleh lebih dari diameter!");
        }
        this.tinggiSagitta = tinggiSagitta;
    }

    @Override
    public void hitungLuas() {
        double luasJuring = (sudut / 360.0) * super.luas;
        double luasSegitiga = 0.5 * radius * radius * Math.sin(Math.toRadians(sudut));
        luas = luasJuring - luasSegitiga;
    }

    @Override
    public void hitungKeliling() {
        double panjangBusur = (sudut / 360.0) * super.keliling;
        double taliBusur = 2 * Math.sqrt(radius * radius - Math.pow(radius - tinggiSagitta, 2));
        keliling = panjangBusur + taliBusur;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Tembereng Lingkaran");
        System.out.println("Radius\t: " + radius);
        System.out.println("Sudut\t: " + sudut);
        System.out.println("Tinggi Sagitta\t: " + tinggiSagitta);
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
