import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ts = Integer.parseInt(bf.readLine());

        // 값을 넣을 배열 생성
        int[][] arr = new int[ts][2];

        for (int i = 0; i < ts; i++) {
            String str = bf.readLine();
            String[] arr2 = str.split(" ");

            arr[i][0] = Integer.parseInt(arr2[0]);
            arr[i][1] = Integer.parseInt(arr2[1]);
        }

        // Comparator 익명 클래스 구현
        arr = Arrays.stream(arr).sorted(new Comparator<int[]>() {
            // 첫 번째 열 숫자 기준 오름차순. 첫 번째 열 숫자가 동일하면 두 번째 열 기준 오름차순
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        }).toArray(int[][]::new);

        for (int[] arr3 : arr) {
            bw.write(arr3[0] + " " + arr3[1] + "\n");
        }
        bw.close();
    }
}