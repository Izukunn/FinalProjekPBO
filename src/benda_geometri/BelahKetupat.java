package benda_geometri;

public class BelahKetupat implements Benda2D {

    private double diagonal1;
    private double diagonal2;
    private double sisi;

    public BelahKetupat(double diagonal1, double diagonal2, double sisi) throws NegativeInputException {
        setDiagonal1(diagonal1);
        setDiagonal2(diagonal2);
        setSisi(sisi);
    }

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

    @Override
    public double hitungLuas() {
        return (diagonal1 * diagonal2) / 2.0;
    }

    @Override
    public double hitungKeliling() {
        return 4 * sisi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t: Belah Ketupat");
        System.out.println("Diagonal 1\t: " + getDiagonal1());
        System.out.println("Diagonal 2\t: " + getDiagonal2());
        System.out.println("Sisi\t: " + getSisi());
        System.out.println("Luas\t: " + hitungLuas());
        System.out.println("Keliling\t: " + hitungKeliling());
    }
}
