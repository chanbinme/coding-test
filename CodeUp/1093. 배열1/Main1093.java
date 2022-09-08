import java.util.Scanner;

public class Main1093 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int[] b = new int[a];
        int[] arr = new int[23];

        for (int i = 0; i < a; i++) {
            b[i] = scan.nextInt();
            arr[b[i] - 1] += 1;
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.printf("%d ", arr[j]);
        }
    }
}
