package benda_geometri;

public class JuringBola extends Bola {

    private double sudutPusat;

    public JuringBola(double radius, double sudutPusat) throws NegativeInputException {
        super(radius);
        setSudutPusat(sudutPusat);
    }

    public double getSudutPusat() {
        return sudutPusat;
    }

    public void setSudutPusat(double sudutPusat) throws NegativeInputException {
        if (sudutPusat < 0) {
            throw new NegativeInputException("Sudut pusat tidak boleh negatif!");
        }
        this.sudutPusat = sudutPusat;
    }

    @Override
    public double hitungVolume() {
        return (2.0 / 3) * Math.PI * Math.pow(getRadius(), 3) * (sudutPusat / 360);
    }

    @Override
    public double hitungLuasPermukaan() {
        return Math.PI * Math.pow(getRadius(), 2) * (sudutPusat / 90);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Juring Bola");
        System.out.println("Radius\t: " + getRadius());
        System.out.println("Sudut Pusat\t: " + getSudutPusat());
        System.out.println("Volume\t: " + hitungVolume());
        System.out.println("Luas Permukaan\t: " + hitungLuasPermukaan());
    }
}
