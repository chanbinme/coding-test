import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        if (str.charAt(0) == ' ') {
            str = str.replaceFirst(" ", "");
        }

        String[] arr = str.split(" ");

        if (arr[0].equals("")) {
            String[] arr2 = Arrays.copyOfRange(arr, 1, arr.length);
            System.out.println(arr2.length);
        } else System.out.println(arr.length);
    }
}