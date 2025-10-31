import java.util.InputMismatchException;
import java.util.Scanner;

public class IterasiSederhana {

    static double f(double x, int pilihan){
        if (pilihan == 1) return x * x + x - 2;
        else if (pilihan == 2) return x * x * x - 4 * x + 1;
        else return 0;
    }

    static double g(double x, int pilihan){
        if (pilihan == 1) return -x * x + 2;
        else if (pilihan == 2) return Math.cbrt(4 * x - 1);
        else return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x0 = 0, epsilon = 0;
        int maks = 0, pilihan = 0;

        System.out.println("=== Metode Iterasi Sederhana ===");
        System.out.println("Pilih fungsi yang ingin digunakan:");
        System.out.println("1. f(x) = x^2 + x - 2");
        System.out.println("2. f(x) = x^3 - 4x + 1");

        // Validasi input pilihan
        while (true) {
            try {
                System.out.print("Masukkan pilihan (1 atau 2): ");
                pilihan = input.nextInt();
                if (pilihan == 1 || pilihan == 2) break;
                System.out.println("Pilihan hanya 1 atau 2!");
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Masukkan angka 1 atau 2.");
                input.nextLine(); // clear buffer
            }
        }

        // Validasi input numerik
        try {
            System.out.print("Masukkan x0: ");
            x0 = input.nextDouble();
            System.out.print("Masukkan toleransi error (epsilon): ");
            epsilon = input.nextDouble();
            System.out.print("Masukkan iterasi max: ");
            maks = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid! Program dihentikan.");
            return;
        }

        System.out.println("\ni\txi\t\tf(xi)\t\tg(xi)\t\t|xi-xi-1|");
        System.out.println("----------------------------------------------------------------");

        double x1;
        int i;
        for (i = 1; i <= maks; i++) {
            x1 = g(x0, pilihan);
            double fx = f(x1, pilihan);
            double gx = g(x1, pilihan);
            double selisih = Math.abs(x1 - x0);

            System.out.printf("%d\t%.6f\t%.6f\t%.6f\t%.6f\n", i, x1, fx, gx, selisih);

            if (Math.abs(fx) < epsilon) {
                System.out.println("\nKonvergen!");
                System.out.println("Akar ditemukan: " + x1);
                break;
            }
            x0 = x1;
        }

        if (i > maks) {
            System.out.println("\nTidak konvergen");
        }
    }
}