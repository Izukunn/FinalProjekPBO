package benda_geometri;

public class LayangLayang implements Benda2D, Runnable {

    private double diagonal1;
    private double diagonal2;
    private double sisiPendek;
    private double sisiPanjang;

    private double luas;
    private double keliling;

    public LayangLayang() {
        this.diagonal1 = 1.0;
        this.diagonal2 = 1.0;
        this.sisiPendek = 1.0;
        this.sisiPanjang = 1.0;
        hitungLuas();
        hitungKeliling();
    }

    public LayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang)
            throws InvalidInputException {
        setDiagonal1(diagonal1);
        setDiagonal2(diagonal2);
        setSisiPendek(sisiPendek);
        setSisiPanjang(sisiPanjang);
        hitungLuas();
        hitungKeliling();
    }

    public double getDiagonal1() {
        return diagonal1;
    }

    public void setDiagonal1(double diagonal1) throws InvalidInputException {
        if (diagonal1 < 0) {
            throw new InvalidInputException("Diagonal 1 tidak boleh negatif!");
        }
        this.diagonal1 = diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    public void setDiagonal2(double diagonal2) throws InvalidInputException {
        if (diagonal2 < 0) {
            throw new InvalidInputException("Diagonal 2 tidak boleh negatif!");
        }
        this.diagonal2 = diagonal2;
    }

    public double getSisiPendek() {
        return sisiPendek;
    }

    public void setSisiPendek(double sisiPendek) throws InvalidInputException {
        if (sisiPendek < 0) {
            throw new InvalidInputException("Sisi pendek tidak boleh negatif!");
        }
        this.sisiPendek = sisiPendek;
    }

    public double getSisiPanjang() {
        return sisiPanjang;
    }

    public void setSisiPanjang(double sisiPanjang) throws InvalidInputException {
        if (sisiPanjang < 0) {
            throw new InvalidInputException("Sisi panjang tidak boleh negatif!");
        }
        this.sisiPanjang = sisiPanjang;
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }

    @Override
    public void hitungLuas() {
        luas = 0.5 * diagonal1 * diagonal2;
    }

    @Override
    public void hitungKeliling() {
        keliling = 2 * (sisiPendek + sisiPanjang);
    }

    @Override
    public String tampilkanInfo() {
        return "=== LAYANG-LAYANG ===\n" +
               "Diagonal 1\t: " + diagonal1 + "\n" +
               "Diagonal 2\t: " + diagonal2 + "\n" +
               "Sisi Pendek\t: " + sisiPendek + "\n" +
               "Sisi Panjang\t: " + sisiPanjang + "\n" +
               "Luas\t\t: " + luas + "\n" +
               "Keliling\t: " + keliling;
    }

    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        System.out.println(tampilkanInfo());
    }
}
