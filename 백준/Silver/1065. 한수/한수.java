import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        if (num < 100) System.out.println(num);
        else {
            int cnt = 99;

            for (int i = 100; i <= num; i++) {
                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if (hun - ten == ten - one) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}