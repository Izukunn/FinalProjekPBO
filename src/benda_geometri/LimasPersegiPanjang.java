package benda_geometri;

public class LimasPersegiPanjang extends PersegiPanjang implements Benda3D {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggi) throws InvalidInputException {
        super(panjang, lebar);
        if (tinggi < 0) {
            throw new InvalidInputException("Tinggi tidak boleh negatif!");
        }
        this.tinggi = tinggi;
        hitungVolume();
        hitungLuasPermukaan();
    }

    @Override
    public void hitungVolume() {
        super.hitungLuas();
        volume = (1.0 / 3.0) * super.luas * tinggi;
    }

    @Override
    public void hitungLuasPermukaan() {
        super.hitungLuas();
        super.hitungKeliling();
        double tinggiSegitigaPanjang = Math.sqrt(Math.pow((lebar / 2), 2) + Math.pow(tinggi, 2));
        double tinggiSegitigaLebar = Math.sqrt(Math.pow((panjang / 2), 2) + Math.pow(tinggi, 2));
        double luasSegitigaPanjang = panjang * tinggiSegitigaPanjang / 2;
        double luasSegitigaLebar = lebar * tinggiSegitigaLebar / 2;
        luasPermukaan = super.luas + 2 * luasSegitigaPanjang + 2 * luasSegitigaLebar;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Limas Persegi Panjang");
        System.out.println("Panjang Alas\t: " + panjang);
        System.out.println("Lebar Alas\t: " + lebar);
        System.out.println("Tinggi\t: " + tinggi);
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
