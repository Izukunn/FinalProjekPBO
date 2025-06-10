package benda_geometri;

public class LayangLayang implements Benda2D, Runnable {

    private double diagonal1;
    private double diagonal2;
    private double sisiPendek;
    private double sisiPanjang;

    // Tambahan atribut
    private double luas;
    private double keliling;

    // Constructor default
    public LayangLayang() {
        this.diagonal1 = 1.0;
        this.diagonal2 = 1.0;
        this.sisiPendek = 1.0;
        this.sisiPanjang = 1.0;
        hitungLuas();
        hitungKeliling();
    }

    // Constructor overloading dengan parameter
    public LayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang)
            throws NegativeInputException {
        setDiagonal1(diagonal1);
        setDiagonal2(diagonal2);
        setSisiPendek(sisiPendek);
        setSisiPanjang(sisiPanjang);
        hitungLuas();
        hitungKeliling();
    }

    // Getter dan Setter
    public double getDiagonal1() {
        return diagonal1;
    }

    public void setDiagonal1(double diagonal1) throws NegativeInputException {
        if (diagonal1 < 0) {
            throw new NegativeInputException("Diagonal 1 tidak boleh negatif!");
        }
        this.diagonal1 = diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    public void setDiagonal2(double diagonal2) throws NegativeInputException {
        if (diagonal2 < 0) {
            throw new NegativeInputException("Diagonal 2 tidak boleh negatif!");
        }
        this.diagonal2 = diagonal2;
    }

    public double getSisiPendek() {
        return sisiPendek;
    }

    public void setSisiPendek(double sisiPendek) throws NegativeInputException {
        if (sisiPendek < 0) {
            throw new NegativeInputException("Sisi pendek tidak boleh negatif!");
        }
        this.sisiPendek = sisiPendek;
    }

    public double getSisiPanjang() {
        return sisiPanjang;
    }

    public void setSisiPanjang(double sisiPanjang) throws NegativeInputException {
        if (sisiPanjang < 0) {
            throw new NegativeInputException("Sisi panjang tidak boleh negatif!");
        }
        this.sisiPanjang = sisiPanjang;
    }

    // Getter untuk luas dan keliling
    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }

    // Perhitungan luas dan keliling
    @Override
    public double hitungLuas() {
        luas = 0.5 * diagonal1 * diagonal2;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 2 * (sisiPendek + sisiPanjang);
        return keliling;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== LAYANG-LAYANG ===");
        System.out.println("Diagonal 1\t: " + diagonal1);
        System.out.println("Diagonal 2\t: " + diagonal2);
        System.out.println("Sisi Pendek\t: " + sisiPendek);
        System.out.println("Sisi Panjang\t: " + sisiPanjang);
        System.out.println("Luas\t\t: " + luas);
        System.out.println("Keliling\t: " + keliling);
    }

    // Multi-thread support
    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        tampilkanInfo();
    }
}
