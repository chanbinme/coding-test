

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int max = sc.nextInt();
        int sum = 0;

        int[] arr = new int[num];

        /* card 개수만큼 입력 받음 */
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        /* 오름차순 정렬 */
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (sum < arr[k] + arr[j] + arr[i] && max >= arr[k] + arr[j] + arr[i]) {
                        sum = arr[k] + arr[j] + arr[i];
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
