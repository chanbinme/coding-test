import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());

            // 0이면 마지막 값 제거 및 합에서 빼기
            if (num == 0) {
                if (!stack.isEmpty()) {
                    sum -= stack.pop();
                }
            // 값 추가 및 합 추가
            } else {
                sum += stack.push(num);
            }
        }
        System.out.println(sum);
    }
}
