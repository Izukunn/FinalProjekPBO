package benda_geometri;

public class LimasLayangLayang extends LayangLayang implements Benda3D {

    private double tinggiPrisma;

    public LimasLayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang, double tinggiPrisma) throws NegativeInputException {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
        setTinggiPrisma(tinggiPrisma);
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) throws NegativeInputException {
        if (tinggiPrisma < 0) {
            throw new NegativeInputException("Tinggi prisma tidak boleh negatif!");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        // Volume limas = (1/3) * luas alas * tinggi
        return (1.0 / 3) * super.hitungLuas() * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        // Luas permukaan = luas alas + luas selimut (4 segitiga)
        // Estimasi tinggi segitiga selimut menggunakan sisi panjang dan tinggi prisma
        double tinggiSegitiga = Math.sqrt(Math.pow(tinggiPrisma, 2) + Math.pow(getSisiPanjang(), 2) / 4);
        double luasSelimut = 4 * (0.5 * getSisiPanjang() * tinggiSegitiga);
        return super.hitungLuas() + luasSelimut;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t\t: Limas Layang-layang");
        System.out.println("Diagonal 1\t: " + getDiagonal1());
        System.out.println("Diagonal 2\t: " + getDiagonal2());
        System.out.println("Sisi Pendek\t: " + getSisiPendek());
        System.out.println("Sisi Panjang\t: " + getSisiPanjang());
        System.out.println("Tinggi Prisma\t: " + getTinggiPrisma());
        System.out.println("Volume\t\t: " + hitungVolume());
        System.out.println("Luas Permukaan\t: " + hitungLuasPermukaan());
    }
}
