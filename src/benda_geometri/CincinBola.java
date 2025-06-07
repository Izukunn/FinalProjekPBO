package benda_geometri;

public class CincinBola extends Bola {

    private double radiusLuar;
    private double radiusDalam;

    public CincinBola(double radiusLuar, double radiusDalam) throws InvalidInputException {
        super(radiusLuar);
        setRadiusLuar(radiusLuar);
        setRadiusDalam(radiusDalam);
    }

    public double getRadiusLuar() {
        return radiusLuar;
    }

    public void setRadiusLuar(double radiusLuar) throws InvalidInputException {
        if (radiusLuar < 0) {
            throw new InvalidInputException("Radius luar tidak boleh negatif!");
        }
        this.radiusLuar = radiusLuar;
    }

    public double getRadiusDalam() {
        return radiusDalam;
    }

    public void setRadiusDalam(double radiusDalam) throws InvalidInputException {
        if (radiusDalam < 0) {
            throw new InvalidInputException("Radius dalam tidak boleh negatif!");
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
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Cincin Bola");
        System.out.println("Radius Luar\t: " + getRadiusLuar());
        System.out.println("Radius Dalam\t: " + getRadiusDalam());
        System.out.println("Volume\t: " + hitungVolume());
        System.out.println("Luas Permukaan\t: " + hitungLuasPermukaan());
    }
}
