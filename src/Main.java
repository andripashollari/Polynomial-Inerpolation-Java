import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=0;

        System.out.print("Jepni vleren e n: ");
        n = scanner.nextInt();
        while(n<1 || n>15){
            System.out.print("Gabim ne dhenjen e vleres!(15 maksimuni)");
            System.out.print("Jepni vleren e n: ");
            n = scanner.nextInt();
        }
        double [] y = new double[n];
        double [] x = new double[n];

        MyFrame frame = new MyFrame(n);

        x = frame.getx();
        y = frame.gety();
    }
}
