package benda_geometri;

public class PersegiPanjang implements Benda2D {

    public double panjang;
    public double lebar;
    public double luas;
    public double keliling;

    public PersegiPanjang(double panjang, double lebar) throws InvalidInputException {
        if (panjang < 0) {
            throw new InvalidInputException("Panjang tidak boleh negatif!");
        }
        if (lebar < 0) {
            throw new InvalidInputException("Lebar tidak boleh negatif!");
        }
        this.panjang = panjang;
        this.lebar = lebar;
        hitungLuas();
        hitungKeliling();
    }

    @Override
    public void hitungLuas() {
        luas = panjang * lebar;
    }

    @Override
    public void hitungKeliling() {
        keliling = 2 * (panjang + lebar);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Persegi Panjang");
        System.out.println("Panjang\t: " + panjang);
        System.out.println("Lebar\t: " + lebar);
        System.out.println("Luas\t: " + luas);
        System.out.println("Keliling\t: " + keliling);
    }

    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        tampilkanInfo();
    }
}
