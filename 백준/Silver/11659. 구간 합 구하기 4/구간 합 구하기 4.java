import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 데이터의 개수, 질의 개수
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        // 구간 합을 구할 대상 배열
        String[] arr = br.readLine().split(" ");
        int[] sumArr = new int[arr.length];
        sumArr[0] = Integer.parseInt(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(arr[i]);
        }

        // 구간 합 계산 및 출력
        for (int i = 0; i < M; i++) {
            String ij = br.readLine();
            String[] IJ = ij.split(" ");

            int I = Integer.parseInt(IJ[0]) - 1;
            int J = Integer.parseInt(IJ[1]) - 1;

            // 첫번째부터 구간합을 구할 경우 계산 필요 없음
            if (I == 0) {
                bw.write(sumArr[J] + "\n");
            } else {
                bw.write(sumArr[J] - sumArr[I - 1] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}