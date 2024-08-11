import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<String> queue = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람들 입력
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), 1);
        }

        // 보도 못한 사람들 입력
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);   // 이미 존재하면 +1
            if (map.get(name) == 2) {
                queue.add(name);    // 2명이 존재한다면 우선순위큐에 추가
            }
        }

        bw.write(queue.size() + "\n");
        while (!queue.isEmpty()) {
            bw.write(queue.poll() + "\n");
        }
        bw.flush();
        bw.close();
    }
}