import java.util.Scanner;

public class Main {
    static long result = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        factorial(N);
        System.out.println(result);
    }

    static void factorial(int N) {
        if (N == 0) {
            return;
        }

        result *= N;
        factorial(N - 1);
    }
}
