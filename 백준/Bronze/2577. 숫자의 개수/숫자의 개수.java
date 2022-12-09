import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        String str = String.valueOf(A * B * C);
        String[] strArr = str.split("");
        Integer[] toArray = Arrays.stream(strArr).map(value -> Integer.parseInt(value)).toArray(Integer[]::new);

        int[] count = new int[10];

        for (int i = 0; i < toArray.length; i++) {
            int num = toArray[i];

            count[num]++;
        }

        for (int c : count) {
            System.out.println(c);
        }
    }

}
