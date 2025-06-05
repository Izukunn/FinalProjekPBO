package benda_geometri;

public class JuringLingkaran extends Lingkaran {

    private double sudut;

    public JuringLingkaran(double radius, double sudut) throws NegativeInputException {
        super(radius);
        setSudut(sudut);
    }

    public double getSudut() {
        return sudut;
    }

    public void setSudut(double sudut) throws NegativeInputException {
        if (sudut < 0) {
            throw new NegativeInputException("Sudut tidak boleh negatif!");
        }
        this.sudut = sudut;
    }

    @Override
    public double hitungLuas() {
        return (sudut / 360.0) * Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public double hitungKeliling() {
        double panjangBusur = (sudut / 360.0) * 2 * Math.PI * getRadius();
        return panjangBusur + 2 * getRadius();
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Juring Lingkaran");
        System.out.println("Radius\t: " + getRadius());
        System.out.println("Sudut\t: " + getSudut());
        System.out.println("Luas\t: " + hitungLuas());
        System.out.println("Keliling\t: " + hitungKeliling());
    }
}
