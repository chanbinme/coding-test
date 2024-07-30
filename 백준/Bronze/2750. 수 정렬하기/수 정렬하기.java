import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] ints = new int[N];

        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            // 한 번 돌 때마다 배열 마지막 한칸씩 정렬되었기 때문에 i만큼 빼줌
            for (int j = 0; j < N - 1 - i; j++) {
                int preNum = ints[j];
                int nextNum = ints[j + 1];
                // 배열 값보다 오른쪽 배열의 값이 더 작으면 값 바꾸기
                if (preNum > nextNum) {
                    ints[j] = nextNum;
                    ints[j + 1] = preNum;
                }
            }
        }

        for (int num : ints) {
            bw.write(String.valueOf(num));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}

