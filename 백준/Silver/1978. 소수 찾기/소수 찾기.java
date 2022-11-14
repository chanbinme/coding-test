import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        /* prime 개수 */
        int count = 0;
        boolean check = true;

        for (int i = 0; i < num; i++) {
            int prime = Integer.parseInt(st.nextToken());

            if (prime == 2) {
                count++;
            } else if (prime > 2) {
                for (int j = 2; j <= Math.sqrt(prime); j++) {
                    /* 2부터 num미만의 수로 num을 나눴을 때 나머지가 0이면 소수가 아님 */
                    if (prime % j == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) count++;
                check = true;
            }
        }
        System.out.println(count);
    }

}
