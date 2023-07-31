import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer =
                new StringTokenizer(bufferedReader.readLine());

        int count = Integer.parseInt(stringTokenizer.nextToken());
        int number = Integer.parseInt(stringTokenizer.nextToken());

        int[] arr = new int[count + 1];
        int[] sumArr = new int[count + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= count; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            sumArr[i] = (sumArr[i - 1] + arr[i]);
        }

        for (int k = 0; k < number; k++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            int answer = sumArr[j] - sumArr[i - 1];
            System.out.println(answer);
        }
    }
}