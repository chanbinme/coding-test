import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 연산의 개수 N 받음
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            // 절대값 기준 오름 차순
            if (Math.abs(o1) < Math.abs(o2)) {
                return -1;
            } else if (Math.abs(o1) > Math.abs(o2)) {
                return 1;
            // 절대값이 같을 경우 정수 오름차순
            } else if (Math.abs(o1) == Math.abs(o2)) {
                if (o1 < o2) {
                    return -1;
                } else if (o1 > o2) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        });

        // N만큼 값 받기
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else if (num != 0) {
                pq.add(num);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
