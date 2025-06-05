package Main;

import java.util.Scanner;
import benda_geometri.NegativeInputException;
import benda_geometri.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Kalkulator Bentuk Geometri");
                System.out.println("1. Bangun Datar\n2. Bangun Ruang\n3. Keluar");
                System.out.print("Opsi : ");
                int opsi = sc.nextInt();
                switch (opsi) {
                    case 1:
                        bangunDatar();
                        break;
                    case 2:
                        bangunRuang();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opsi Tidak Valid!");
                        break;
                }
            } catch (NegativeInputException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error: Input harus angka!");
                sc.nextLine();
            }
        }
    }

    private static double inputPositif(String prompt) throws NegativeInputException {
        System.out.print(prompt);
        double nilai = sc.nextDouble();
        if (nilai < 0) {
            throw new NegativeInputException("Input tidak boleh negatif!");
        }
        return nilai;
    }

    private static void bangunDatar() throws NegativeInputException {
        System.out.println("Bangun Datar");
        System.out.println("1. Segitiga");
        System.out.println("2. Persegi");
        System.out.println("3. Persegi Panjang");
        System.out.println("4. Jajar Genjang");
        System.out.println("5. Trapesium");
        System.out.println("6. Belah Ketupat");
        System.out.println("7. Layang-Layang");
        System.out.println("8. Lingkaran");
        System.out.println("9. Tembereng");
        System.out.println("10. Juring");
        System.out.print("Opsi : ");
        int opsi = sc.nextInt();
        switch (opsi) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                double radius = inputPositif("Input Radius : ");
                Lingkaran lingkaran = new Lingkaran(radius);
                lingkaran.tampilkanInfo();
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                System.out.println("Input Tidak Valid!");
                break;
        }
    }

    private static void bangunRuang() throws NegativeInputException {
        System.out.println("Bangun Ruang");
        System.out.println("1. Prisma Segitiga");
        System.out.println("2. Limas Segitiga");
        System.out.println("3. Prisma Persegi");
        System.out.println("4. Limas Persegi");
        System.out.println("5. Prisma Persegi Panjang");
        System.out.println("6. Limas Persegi Panjang");
        System.out.println("7. Prisma Jajaran Genjang");
        System.out.println("8. Limas Jajaran Genjang");
        System.out.println("9. Prisma Trapesium");
        System.out.println("10. Limas Trapesium");
        System.out.println("11. Prisma Belah Ketupat");
        System.out.println("12. Limas Belah Ketupat");
        System.out.println("13. Prisma Layang-Layang");
        System.out.println("14. Limas Layang-Layang");
        System.out.println("15. Tabung");
        System.out.println("16. Kerucut");
        System.out.println("17. Kerucut Terpancung");
        System.out.println("18. Bola");
        System.out.println("19. Tembereng Bola");
        System.out.println("20. Juring Bola");
        System.out.println("21. Cincin Bola");
        System.out.print("Opsi : ");
        int opsi = sc.nextInt();
        switch (opsi) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                double radius = inputPositif("Input Radius : ");
                double tinggi = inputPositif("Input Tinggi : ");
                double garisPelukis = inputPositif("Input Garis Pelukis : ");
                Kerucut kerucut = new Kerucut(radius, tinggi, garisPelukis);
                kerucut.tampilkanInfo();
                break;
            case 17:
                double radiusBawah = inputPositif("Input Radius Bawah: ");
                double radiusAtas = inputPositif("Input Radius Atas : ");
                garisPelukis = inputPositif("Input Garis Pelukis : ");
                tinggi = inputPositif("Input Tinggi : ");
                KerucutTerpancung kerucutT = new KerucutTerpancung(radiusBawah, radiusAtas, garisPelukis, tinggi);
                kerucutT.tampilkanInfo();
                break;
            case 18:
                radius = inputPositif("Input Radius : ");
                Bola bola = new Bola(radius);
                bola.tampilkanInfo();
                break;
            case 19:
                break;
            case 20:
                break;
            case 21:
                break;
            default:
                System.out.println("Input Tidak Valid!");
                break;
        }
    }
}
