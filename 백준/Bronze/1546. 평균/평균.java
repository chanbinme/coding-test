import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] arr = new int[count]; // a 길이만큼의 배열 생성
        double average = 0;
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        // 제일 높은 점수 구하기
        int max = Arrays.stream(arr)
                .max()  // 최댓값 구하기
                .getAsInt(); // int형으로 호출

        for (double i : arr) {
            average += i / max * 100;
        }

        System.out.println(average / count);
    }
}
