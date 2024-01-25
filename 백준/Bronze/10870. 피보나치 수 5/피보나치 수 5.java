import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        long result = fibonachi(N);
        System.out.println(result);
    }

    static long fibonachi(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }

        return fibonachi(N - 1) + fibonachi(N - 2);
    }
}