import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // 낮은 숫자를 우선으로 하여 꺼내 처리하는 int 형 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; N > i; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) { // 입력받은 값이 0보다 크면 큐에 넣음
                pq.add(x);
            }
            else { // 입력받은 값이 0일 경우
                if (pq.size() == 0) { // 큐가 비어있으면 0을 출력
                    bw.write(0 + "\n");
                }
                else { // 큐가 지어있지 않으면 최소값 출력
                    bw.write(pq.poll() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}