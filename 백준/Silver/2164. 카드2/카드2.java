import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();

        // N 받음
        int N = Integer.parseInt(br.readLine());

        // 1~N 만큼 큐에 입력
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 큐 사이즈가 1이 될 때까지 반복
        while (queue.size() > 1) {
            // 큐에서 가장 앞숫자 삭제
            queue.poll();

            // 그 다음 숫자를 뽑아 다시 큐에 입력
            queue.add(queue.poll());
        }

        assert queue.peek() != null;
        bw.write(String.valueOf(queue.peek()));
        bw.flush();
        bw.close();
    }
}