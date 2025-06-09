package benda_geometri;

public class TemberengLingkaran extends Lingkaran {

    private double sudut;
    private double luas;
    private double keliling;

    public TemberengLingkaran() {
        super();
        this.sudut = 60;
        hitungLuas();
        hitungKeliling();
    }
    
    public TemberengLingkaran(double radius) throws InvalidInputException {
        super(radius);
        this.sudut = 60;
        hitungLuas();
        hitungKeliling();
    }
    
    public TemberengLingkaran(double radius, double sudut) throws InvalidInputException {
        super(radius);
        if (sudut < 0 || sudut > 360) {
            throw new InvalidInputException("Sudut harus antara 0 dan 360 derajat!");
        }
        this.sudut = sudut;
        hitungLuas();
        hitungKeliling();
    }

    public TemberengLingkaran(double radius, double sudut, double customPi) throws InvalidInputException {
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
        double luasJuring = (sudut / 360.0) * super.luas;
        double luasSegitiga = 0.5 * radius * radius * Math.sin(Math.toRadians(sudut));
        luas = luasJuring - luasSegitiga;
    }

    @Override
    public void hitungKeliling() {
        super.hitungKeliling();
        double panjangBusur = (sudut / 360.0) * super.keliling;
        double taliBusur = 2 * radius * Math.sin(Math.toRadians(sudut / 2));
        keliling = panjangBusur + taliBusur;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Tembereng Lingkaran");
        System.out.println("Radius\t: " + radius);
        System.out.println("pi\t: " + super.pi);
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
