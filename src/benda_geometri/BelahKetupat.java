package benda_geometri;

public class BelahKetupat implements Benda2D, Runnable {

    private double diagonal1;
    private double diagonal2;
    private double sisi;

    // Tambah atribut luas & keliling
    private double luas;
    private double keliling;

    // Constructor default
    public BelahKetupat() {
        // Nilai default 1.0
        this.diagonal1 = 1.0;
        this.diagonal2 = 1.0;
        this.sisi = 1.0;
        hitungLuas();
        hitungKeliling();
    }

    // Constructor dengan parameter
    public BelahKetupat(double diagonal1, double diagonal2, double sisi) throws NegativeInputException {
        setDiagonal1(diagonal1);
        setDiagonal2(diagonal2);
        setSisi(sisi);
        hitungLuas();
        hitungKeliling();
    }

    // Getter & Setter
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

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) throws NegativeInputException {
        if (sisi < 0) {
            throw new NegativeInputException("Sisi tidak boleh negatif!");
        }
        this.sisi = sisi;
    }

    // Getter untuk luas dan keliling
    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }

    // Hitung luas (simpan ke atribut luas)
    @Override
    public double hitungLuas() {
        luas = (diagonal1 * diagonal2) / 2.0;
        return luas;
    }

    // Hitung keliling (simpan ke atribut keliling)
    @Override
    public double hitungKeliling() {
        keliling = 4 * sisi;
        return keliling;
    }

    // Tampilkan info
    @Override
    public void tampilkanInfo() {
        System.out.println("=== BELAH KETUPAT ===");
        System.out.println("Diagonal 1\t: " + diagonal1);
        System.out.println("Diagonal 2\t: " + diagonal2);
        System.out.println("Sisi\t\t: " + sisi);
        System.out.println("Luas\t\t: " + luas);
        System.out.println("Keliling\t: " + keliling);
    }

    // Runnable (multi-thread)
    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        tampilkanInfo();
    }
}
