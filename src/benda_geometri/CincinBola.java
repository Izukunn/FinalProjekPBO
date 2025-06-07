package benda_geometri;

public class CincinBola implements Benda3D {
    private double radiusBola;
    private double pi = 3.14;
    private double ketebalan;
    private double volume;
    private double luasPermukaan;

    public CincinBola(double radiusBola, double ketebalan) throws InvalidInputException {
        if (radiusBola < 0 || ketebalan < 0) throw new InvalidInputException("Input tidak boleh negatif!");
        this.radiusBola = radiusBola;
        this.ketebalan = ketebalan;
    }

    @Override
    public void hitungVolume() {
        volume = (pi * Math.pow(ketebalan, 3)) / 6; // Volume = πt³/6
    }

    @Override
    public void hitungLuasPermukaan() {
        luasPermukaan = pi * ketebalan * (2 * radiusBola + ketebalan); // Luas = πt(2R + t)
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Cincin Bola");
        System.out.println("Radius Bola\t: " + radiusBola);
        System.out.println("pi\t: " + pi);
        System.out.println("Ketebalan\t: " + ketebalan);
        System.out.println("Volume\t: " + volume);
        System.out.println("Luas Permukaan\t: " + luasPermukaan);
    }
    
    @Override
    public void run() {
        hitungVolume();
        hitungLuasPermukaan();
        tampilkanInfo();
    }
}
