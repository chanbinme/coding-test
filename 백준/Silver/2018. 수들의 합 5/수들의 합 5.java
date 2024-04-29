import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int sum = 1;
        int startIndex = 1;
        int endIndex = 1;

        while (endIndex != N) {
            if (sum > N) {
                sum -= startIndex;
                startIndex++;
            } else if (sum < N) {
                endIndex++;
                sum += endIndex;
            } else {
                endIndex++;
                sum += endIndex;
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}