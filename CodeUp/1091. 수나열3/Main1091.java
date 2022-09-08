import java.util.Scanner;

public class Main1091 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextInt();
        int m = scan.nextInt();
        int d = scan.nextInt();
        int n = scan.nextInt();


        for(int i = 1; i < n; i++) {
            a = a * m + d;
        }
        System.out.println(a);
    }
}
