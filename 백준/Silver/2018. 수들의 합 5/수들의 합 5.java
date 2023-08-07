import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int answer = 1;     // 더하는 값 없이 자기 자신만 답일 경우를 위해 1로 초기화

        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;

        while (endIdx != N) {
            if (sum == N) {
                answer++;
                endIdx++;
                sum += endIdx;
            } else if (sum < N) {
                endIdx++;
                sum += endIdx;
            } else {
                sum -= startIdx;
                startIdx++;
            }
        }
        System.out.println(answer);
    }
}