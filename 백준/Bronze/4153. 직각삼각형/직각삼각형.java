import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            if (a == 0) break;

            int a2 = a * a;
            int b2 = b * b;
            int c2 = c * c;
            
            if (a2 == b2 + c2 || b2 == c2 + a2 || c2 == a2 + b2) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}
