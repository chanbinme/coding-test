import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N과 L
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        // N개만큼의 수
        Deque<Node> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        // 첫 번째는 혼자기 때문에 최솟값임
        int firstNum = Integer.parseInt(st.nextToken());
        deque.add(new Node(1, firstNum));
        sb.append(firstNum).append(" ");

        for (int i = 2; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 첫 번째 Node가 L 범위에 포함되는지 체크
            if (deque.peekFirst().key <= (i - l)) {
                deque.removeFirst();  // 첫번째 Node 제거
            }

            // 마지막 Node 값이 새로 들어올 값보다 크면 제거
            while (!deque.isEmpty() && deque.peekLast().value > num) {
                deque.removeLast(); // 마지막 Node 제거
            }
            deque.add(new Node(i, num));    // 새로운 값 추가
            sb.append(deque.peekFirst().value).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}