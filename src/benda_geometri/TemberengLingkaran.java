package benda_geometri;

public class TemberengLingkaran extends Lingkaran {

    private double sudut;
    private double tinggiSagitta;

    public TemberengLingkaran(double radius, double sudut, double tinggiSagitta) throws NegativeInputException {
        super(radius);
        setSudut(sudut);
        setTinggiSagitta(tinggiSagitta);
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

    public double getTinggiSagitta() {
        return tinggiSagitta;
    }

    public void setTinggiSagitta(double tinggiSagitta) throws NegativeInputException {
        if (tinggiSagitta < 0) {
            throw new NegativeInputException("Tinggi sagitta tidak boleh negatif!");
        }
        this.tinggiSagitta = tinggiSagitta;
    }

    @Override
    public double hitungLuas() {
        double luasJuring = (sudut / 360.0) * Math.PI * getRadius() * getRadius();
        double luasSegitiga = 0.5 * getRadius() * getRadius() * Math.sin(Math.toRadians(sudut));
        return luasJuring - luasSegitiga;
    }

    @Override
    public double hitungKeliling() {
        double panjangBusur = (sudut / 360.0) * 2 * Math.PI * getRadius();
        double taliBusur = 2 * Math.sqrt(getRadius() * getRadius() - Math.pow(getRadius() - tinggiSagitta, 2));
        return panjangBusur + taliBusur;
    }
}
