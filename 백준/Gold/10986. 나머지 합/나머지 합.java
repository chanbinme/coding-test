import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        long[] sumArr = new long[N + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            sumArr[i] = sumArr[i - 1] + num;
        }

        long count = 0L;
        long[] countArr = new long[M];

        for (int i = 1; i <= N; i++) {
            int num = (int) (sumArr[i] % M);
            if (num == 0) {
                count++;
            }
            countArr[num]++;
        }
        for (int i = 0; i < M; i++) {
            if (countArr[i] > 1) {
                count = count + (countArr[i] * (countArr[i] - 1) / 2);
            }
        }

        System.out.println(count);
    }
}