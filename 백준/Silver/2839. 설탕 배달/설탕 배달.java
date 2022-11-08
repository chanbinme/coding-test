import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* 배달해야하는 설탕 무게 */
        int N = sc.nextInt();

        /* 시도해볼 수 있는 경우의 수 */
        int ts = N / 5;

        /* 설탕 무게의 합 */
        int sum = 0;

        /* 결과값 딱 맞아떨어지지 않았을 경우를 위해 기본값 -1로 설정 */
        int result = -1;

        /* 계산이 딱 맞아떨어지지 않을 때마다 5kg개수 1개씩 줄임. 5kg을 안 쓸 경우의 0도 포함 */
        for (int i = ts; i >= 0; i--) {
            int remainder = N - (5 * i);
            int kg3 = remainder / 3;

            // 딱 나누어 떨어지면
            if (remainder % 3 == 0) {
                result = i + kg3;
                break;
            }
        }
        System.out.println(result);
    }
}