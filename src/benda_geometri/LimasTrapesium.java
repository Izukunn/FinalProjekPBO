package benda_geometri;

public class LimasTrapesium extends Trapesium implements Benda3D {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public LimasTrapesium(double sisiAtas, double sisiBawah, double sisiKiri, double sisiKanan, double tinggiAlas, double tinggi) throws InvalidInputException {
        super(sisiAtas, sisiBawah, sisiKiri, sisiKanan, tinggiAlas);
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
        double tinggiSegitigaAtas = Math.sqrt(Math.pow((sisiBawah - sisiAtas) / 2, 2) + Math.pow(tinggi, 2));
        double tinggiSegitigaKiri = Math.sqrt(Math.pow((sisiKanan - sisiKiri) / 2, 2) + Math.pow(tinggi, 2));
        double luasSegitigaAtas = sisiAtas * tinggiSegitigaAtas / 2;
        double luasSegitigaBawah = sisiBawah * tinggiSegitigaAtas / 2;
        double luasSegitigaKiri = sisiKiri * tinggiSegitigaKiri / 2;
        double luasSegitigaKanan = sisiKanan * tinggiSegitigaKiri / 2;
        luasPermukaan = super.luas + luasSegitigaAtas + luasSegitigaBawah + luasSegitigaKiri + luasSegitigaKanan;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Limas Trapesium");
        System.out.println("Sisi Atas\t: " + sisiAtas);
        System.out.println("Sisi Bawah\t: " + sisiBawah);
        System.out.println("Sisi Kiri\t: " + sisiKiri);
        System.out.println("Sisi Kanan\t: " + sisiKanan);
        System.out.println("Tinggi Alas\t: " + tinggiAlas);
        System.out.println("Tinggi Limas\t: " + tinggi);
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
