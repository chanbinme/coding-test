import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수의 개수 N
        int N = Integer.parseInt(br.readLine());

        // N개의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long[] ints = new Long[N];
        for (int i = 0; i < N; i++) {
            ints[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(ints);
        int count = 0;

        // 투포인터로 계산 : i와 j가 만날 때까지 계산
        for (int i = 0; i < N; i++) {
            long goodNum = ints[i];

            int startIndex = 0;
            // endIndex 위치의 값이 좋은 수보다 같거나 크면 안됨
            int endIndex = N - 1;
            // startIndex와 endIndex가 만날때까지 반복
            while (startIndex < endIndex) {
                if (ints[startIndex] + ints[endIndex] < goodNum) {
                    startIndex++;
                } else if (ints[startIndex] + ints[endIndex] > goodNum) {
                    endIndex--;
                // 좋은 수라는 것이 확인 됐기 때문에 while문 종료
                } else if (ints[startIndex] + ints[endIndex] == goodNum) {
                    if (startIndex == i) {
                        startIndex++;
                    } else if (endIndex == i) {
                        endIndex--;
                    } else {
                        count++;
                        break;
                    }
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
