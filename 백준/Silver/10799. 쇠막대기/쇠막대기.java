import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        String pipeLines = br.readLine();
        int result = 0;

        for (int i = 0; i < pipeLines.length(); i++) {
            char currentChar = pipeLines.charAt(i);
            char beforeChar = ' ';
            if (i > 0) {
                beforeChar = pipeLines.charAt(i - 1);
            }

            if (currentChar == '(') {
                // 파이프.
                stack.push(0);
            } else if (currentChar == ')') {
                // 레이저.
                if (beforeChar == '(') {
                    stack.pop();
                    result += stack.size();
                // 파이프 꼬다리.
                } else if (beforeChar == ')') {
                    stack.pop();
                    result += 1;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
