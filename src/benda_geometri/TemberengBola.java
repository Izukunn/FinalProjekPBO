package benda_geometri;

public class TemberengBola extends Bola {

    private double tinggiTembereng;

    public TemberengBola(double radius, double tinggiTembereng) throws NegativeInputException {
        super(radius);
        setTinggiTembereng(tinggiTembereng);
    }

    public double getTinggiTembereng() {
        return tinggiTembereng;
    }

    public void setTinggiTembereng(double tinggiTembereng) throws NegativeInputException {
        if (tinggiTembereng < 0) {
            throw new NegativeInputException("Tinggi tembereng tidak boleh negatif!");
        }
        this.tinggiTembereng = tinggiTembereng;
    }

    @Override
    public double hitungVolume() {
        return ((Math.PI * Math.pow(tinggiTembereng, 2)) / 3) * (3 * getRadius() - tinggiTembereng);
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * Math.PI * getRadius() * (getRadius() + tinggiTembereng);
    }
}
