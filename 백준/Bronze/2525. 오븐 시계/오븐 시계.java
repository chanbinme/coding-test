import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        b = b + c;
        while (b >= 60) {
            b -= 60;
            a++;
        }

        while (a >= 24) {
            a -= 24;
        }

        System.out.println(a + " " + b);
    }
}