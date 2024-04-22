import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 과목의 개수
        int N = Integer.parseInt(br.readLine());
        String[] points = br.readLine().split(" ");
        double[] doublePoints = new double[N];

        // 과목 중 가장 큰 수를 구함
        double max = 0;
        for (int i = 0; i < N; i++) {
            doublePoints[i] = Double.parseDouble(points[i]);
            if (max < doublePoints[i]) {
                max = doublePoints[i];
            }
        }

        // 가장 큰 점수로 새로운 점수를 구함
        double sum = 0;
        for (int i = 0; i < doublePoints.length; i++) {
            sum += doublePoints[i] / max * 100;
        }

        bw.write(String.valueOf(sum / N));
        bw.flush();
        bw.close();
    }
}