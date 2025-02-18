import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 수열의 크기 N
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        // N 개의 수열 입력
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 첫 번째 언덕과 마지막 언덕
        int firstHill = 0;
        int lastHill = 0;

        // 제일 높은 오르막길
        int maxHill = 0;

        for (int i = 0; i < N; i++) {
            // 첫 번째 언덕 찾기
            if (firstHill == 0) {
                firstHill = arr[i];
            // 마지막 언덕을 변경
            } else if (firstHill < arr[i] && lastHill < arr[i]) {
                lastHill = arr[i];
            } else {
                maxHill = Math.max(maxHill, lastHill - firstHill);
                firstHill = arr[i];
                lastHill = 0;
            }

            // 리스트 끝났을 때
            if (i == N - 1) {
                maxHill = Math.max(maxHill, lastHill - firstHill);
            }
        }

        System.out.println(maxHill);
    }
}
