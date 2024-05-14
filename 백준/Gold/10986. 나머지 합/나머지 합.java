import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * [나머지 합 구하기]
         *
         * (A+B) % C == ((A % C) + (B % C)) % C
         * 특정 구간 수들의 나머지 연산을 더해 나머지 연산을 한 값과 이 구간들 합의 나머지 연산을 한 값은 동일하다.
         * S[i] - S[j]는 원본 배열의 i+1부터 j까지의 구간 합이다.
          */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 합 배열 생성
        long[] arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
        }

        // 합 배열 나머지 연산 값으로 업데이트
        long[] countArr = new long[M];
        long count = 0;
        for (int i = 1; i <= N; i++) {
            int remainder = (int) (arr[i] % M);
            if (remainder == 0) {
                count++;
            }
            // 나머지가 같은 인덱스 카운팅
            countArr[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (countArr[i] > 1) {
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
                count += countArr[i] * (countArr[i] - 1) / 2;   // 2개를 뽑는 경우의 수 구하는 공식
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
