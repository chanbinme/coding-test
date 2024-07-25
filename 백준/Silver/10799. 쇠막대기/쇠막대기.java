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
        Stack<String> stack = new Stack<>();

        String[] pipeLines = br.readLine().split("");
        int result = 0;

        for (int i = 0; i < pipeLines.length; i++) {
            String object = pipeLines[i];

            if (object.equals("(")) {
                // 파이프.
                stack.push(object);
            } else if (object.equals(")")) {
                // 레이저.
                if (pipeLines[i - 1].equals("(")) {
                    stack.pop();
                    result += stack.size();
                // 파이프 꼬다리.
                } else if (pipeLines[i - 1].equals(")")) {
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
