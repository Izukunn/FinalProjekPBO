package benda_geometri;

public class CincinBola extends Bola {

    private double radiusLuar;
    private double radiusDalam;

    public CincinBola(double radiusLuar, double radiusDalam) throws NegativeInputException {
        super(radiusLuar);
        setRadiusLuar(radiusLuar);
        setRadiusDalam(radiusDalam);
    }

    public double getRadiusLuar() {
        return radiusLuar;
    }

    public void setRadiusLuar(double radiusLuar) throws NegativeInputException {
        if (radiusLuar < 0) {
            throw new NegativeInputException("Radius luar tidak boleh negatif!");
        }
        this.radiusLuar = radiusLuar;
    }

    public double getRadiusDalam() {
        return radiusDalam;
    }

    public void setRadiusDalam(double radiusDalam) throws NegativeInputException {
        if (radiusDalam < 0) {
            throw new NegativeInputException("Radius dalam tidak boleh negatif!");
        }
        this.radiusDalam = radiusDalam;
    }

    @Override
    public double hitungVolume() {
        return (4.0 / 3) * Math.PI * (Math.pow(radiusLuar, 3) - Math.pow(radiusDalam, 3));
    }
    
    @Override
    public double hitungLuasPermukaan() {
        return 4 * Math.PI * (Math.pow(radiusLuar, 2) + Math.pow(radiusDalam, 2));
    }
}
