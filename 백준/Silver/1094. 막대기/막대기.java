import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int X = Integer.parseInt(new Scanner(System.in).nextLine());
        int[] ints = {64, 32, 16, 8, 4, 2, 1};
        int count = 0;

        for (int i = 0; i < ints.length; i++) {
            if (X >= ints[i]) {
                X -= ints[i];
                count++;
            }

            if (X == 0) {
                break;
            }
        }
        System.out.println(count);
    }
}
