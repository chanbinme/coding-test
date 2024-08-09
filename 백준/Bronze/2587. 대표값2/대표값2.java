import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] intArr = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            intArr[i] = num;

            // 값 sum에 더하기
            sum += num;
        }
        Arrays.sort(intArr);

        int middleNum = intArr[2];  // 중간값
        int average = sum / 5;  // 평균값

        System.out.println(average);
        System.out.println(middleNum);
    }
}