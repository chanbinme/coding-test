import java.util.Scanner;

public class Main1089 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int d = scan.nextInt();
        int n = scan.nextInt();

        for(int i = 1; i < n; i++) {
            a += d;
        }
        System.out.println(a);
    }
}
