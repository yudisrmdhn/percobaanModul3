import java.util.Scanner;

public class IterasiSederhana {

    static double f(double x){
        return x * x + x-2;
    }

    static double g(double x){
        return -x * x + 2;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.println("===Metode Iterasi Sederhana===");

        System.out.print("Masukkan x0: ");
        double x0=input.nextDouble();
        System.out.print("Masukkan toleransi error (epsilon): ");
        double epsilon=input.nextDouble();
        System.out.print("Masukkan iterasi max: ");
        int maks=input.nextInt();

        System.out.println("\ni\txi\t\tf(xi)\t\tg(xi)\t\t|xi-xi-1|");
        System.out.println("----------------------------------------------------------------");

        double x1;
        int i;
        for(i = 1; i <=maks; i++){
            x1=g(x0);
            double fx=f(x1);
            double gx=g(x1);
            double selisih=Math.abs(x1-x0);

            System.out.printf("%d\t%.6f\t%.6f\t%.6f\t%.6f\n",i,x1,fx,gx,selisih);

            if(Math.abs(fx)<epsilon){
                System.out.println("\nKonvergen!");
                System.out.println("Akar ditemukan: "+x1);
                break;
            }
            x0=x1;
        }

        if(i>maks){
            System.out.println("\nTidak konvergen");
        }
    }
}