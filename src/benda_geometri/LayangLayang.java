package benda_geometri;

public class LayangLayang implements Benda2D, Runnable {

    public double diagonal1;
    public double diagonal2;
    public double sisiPendek;
    public double sisiPanjang;
    public double luas;
    public double keliling;

    public LayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang)
            throws InvalidInputException {
        if (diagonal1 < 0 || diagonal2 < 0 || sisiPendek < 0 || sisiPanjang < 0) {
            throw new InvalidInputException("Nilai tidak boleh negatif!");
        }
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiPendek = sisiPendek;
        this.sisiPanjang = sisiPanjang;
        hitungLuas();
        hitungKeliling();
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
        return "=== LAYANG-LAYANG ===\n"
               + "Diagonal 1\t: " + diagonal1 + "\n"
               + "Diagonal 2\t: " + diagonal2 + "\n"
               + "Sisi Pendek\t: " + sisiPendek + "\n"
               + "Sisi Panjang\t: " + sisiPanjang + "\n"
               + "Luas\t\t: " + luas + "\n"
               + "Keliling\t: " + keliling;
    }

    @Override
    public void run() {
        hitungLuas();
        hitungKeliling();
        tampilkanInfo();
    }
}
