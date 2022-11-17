import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다. */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        /* M부터 N까지 순차적으로 소수인지 확인 */
        for (int i = M; i <= N; i++) {
            if (i > 1) {
                prime(i);
            }
        }
    }

    private static void prime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            /* 1과 자신이 아닌 다른 값에 의해 나눠진다면 소수가 아님 */
            if (num % i == 0) {
                return;
            }
        }
        System.out.println(num);
        return;
    }
}
