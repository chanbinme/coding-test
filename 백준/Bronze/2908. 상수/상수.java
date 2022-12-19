import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String A = String.valueOf(a);
        String B = String.valueOf(b);

        String C = "";
        String D = "";
        for (int i = 2; i > -1; i--) {
            C += A.charAt(i);
            D += B.charAt(i);
        }

        a = valueOf(C);
        b = valueOf(D);

        System.out.println(Math.max(a, b));
    }
}
