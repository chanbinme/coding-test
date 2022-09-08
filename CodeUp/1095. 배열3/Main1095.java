import java.util.Scanner;

public class Main1095 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int[] arr = new int[a];
        int result = 24;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
            if (arr[i] < result) result = arr[i];
        }
        System.out.println(result);
    }
}
