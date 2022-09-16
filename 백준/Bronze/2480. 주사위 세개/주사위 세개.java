import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int result;
        int max = 0;
        if (a == b && b == c) result = a * 1000 + 10000;
        else if (a == b || a == c) result = a * 100 + 1000;
        else if (b == a || b == c) result = b * 100 + 1000;
        else {
            if(a > max) max = a;
            if(b > max) max = b;
            if(c > max) max = c;

            result = max * 100;
        }
        System.out.println(result);
    }
}