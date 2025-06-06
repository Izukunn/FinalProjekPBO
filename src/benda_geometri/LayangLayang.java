package benda_geometri;

public class LayangLayang implements Benda2D {

    private double diagonal1;
    private double diagonal2;
    private double sisiPendek;
    private double sisiPanjang;

    // Constructor
    public LayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang) throws NegativeInputException {
        setDiagonal1(diagonal1);
        setDiagonal2(diagonal2);
        setSisiPendek(sisiPendek);
        setSisiPanjang(sisiPanjang);
    }

    // Getter dan Setter dengan validasi
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

    @Override
    public double hitungLuas() {
        return 0.5 * diagonal1 * diagonal2;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (sisiPendek + sisiPanjang);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bangun\t\t: Layang-layang");
        System.out.println("Diagonal 1\t: " + getDiagonal1());
        System.out.println("Diagonal 2\t: " + getDiagonal2());
        System.out.println("Sisi Pendek\t: " + getSisiPendek());
        System.out.println("Sisi Panjang\t: " + getSisiPanjang());
        System.out.println("Luas\t\t: " + hitungLuas());
        System.out.println("Keliling\t: " + hitungKeliling());
    }
}
