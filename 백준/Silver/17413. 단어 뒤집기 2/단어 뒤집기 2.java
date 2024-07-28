import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split("");
        StringBuilder sb = new StringBuilder();

        // 일반 단어를 넣을 스택
        Stack<String> stack = new Stack<>();

        // 태그 안에 있는 단어를 넣을 스택
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < S.length; i++) {
            if (S[i].equals("<")) {
                queue.offer(S[i]);
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            } else if (S[i].equals(">")) {
                while (!queue.isEmpty()) {
                    sb.append(queue.poll());
                }
                sb.append(S[i]);
            } else {
                if (!queue.isEmpty()) {
                    queue.offer(S[i]);
                } else {
                    if (S[i].equals(" ")) {
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        sb.append(" ");
                    } else {
                        stack.push(S[i]);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
