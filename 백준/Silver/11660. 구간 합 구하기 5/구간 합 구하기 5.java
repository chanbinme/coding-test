import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 2차원 배열 크기
        int N = Integer.parseInt(st.nextToken());

        // 질의 수
        int M = Integer.parseInt(st.nextToken());

        long[][] sumArr = new long[N + 1][N + 1];

        // 구간 합 구하기
        for (int i = 1; i < sumArr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < sumArr.length; j++) {
                if (i == 1 && j == 1) {
                    sumArr[i][j] = Integer.parseInt(st.nextToken());
                } else if (j == 1) {
                    sumArr[i][j] = sumArr[i - 1][j] + Integer.parseInt(st.nextToken());
                } else if (i == 1) {
                    sumArr[i][j] = sumArr[i][j - 1] + Integer.parseInt(st.nextToken());
                } else {
                    sumArr[i][j] = sumArr[i][j - 1] + sumArr[i - 1][j] - sumArr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
                }
            }
        }

        // 질의 답
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == 1 && y1 == 1) {
                bw.write(sumArr[x2][y2] + "\n");
            } else {
                bw.write(sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}