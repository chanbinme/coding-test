import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] numArr = br.readLine().split(" ");

        int M = Integer.parseInt(br.readLine());
        String[] numArr2 = br.readLine().split(" ");

        int[] ints = Arrays.stream(numArr).mapToInt(Integer::parseInt).sorted().toArray();

        int[] result = new int[M];

        for (int i = 0; i < numArr2.length; i++) {
            int key = Integer.parseInt(numArr2[i]);
            int lo = lowerBound(ints, key);
            int hi = upperBound(ints, key);

            result[i] = hi - lo;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        // lo가 hi랑 같아질 때까지 반복
        while (lo < hi) {
            int mid = (lo + hi) / 2;    // 중간 위치를 구함

            /**
             * key 값이 중간 위치의 값보다 작거나 같을 경우
             * (중복 원소에 대해 왼쪽으로 탐색할 수 있도록 상한선을 내린다.)
             */
            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (key < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}