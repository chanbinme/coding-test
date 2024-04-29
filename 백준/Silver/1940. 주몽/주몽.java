import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String[] strArr = br.readLine().split(" ");
        int[] intArr = Arrays.stream(strArr).mapToInt(Integer::parseInt).sorted().toArray();

        int startIndex = 0;
        int endIndex = N - 1;
        int count = 0;
        int sum = intArr[startIndex] + intArr[endIndex];

        while (startIndex < endIndex) {

            if (sum > M) {
                sum -= intArr[endIndex];
                endIndex--;
                sum += intArr[endIndex];
            } else if (sum < M) {
                sum -= intArr[startIndex];
                startIndex++;
                sum += intArr[startIndex];
            } else {
                count++;
                startIndex++;
                endIndex--;
                sum = intArr[startIndex] + intArr[endIndex];
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}