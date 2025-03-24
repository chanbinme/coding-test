import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());

        int[] rowSumArray = new int[N]; // 각 행의 합을 담는 배열
        int[] columnSumArray = new int[N]; // 각 열의 합을 담는 배열
        int[] crossSumArray = new int[N]; // 각 대가선의 합을 담는 배열

        // 배열 따로 만들지 않고 바로 합 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = in.nextInt();

                // 각 행 합 계산
                rowSumArray[i] += num;

                // 각 열 합 계산
                columnSumArray[j] += num;

                // 왼쪽 대각선 합 계산
                if(i == j) {
                    crossSumArray[0] += num;
                }

                // 오른쪽 대각선 합 계산
                if(i + j == N) {
                    crossSumArray[1] += num;
                }
            }
            in.nextLine();
        }

        // 배열 합치고 최대값 구하기
        int[] array = IntStream.concat(Arrays.stream(rowSumArray), Arrays.stream(columnSumArray)).toArray();
        IntStream.concat(Arrays.stream(array), Arrays.stream(crossSumArray)).max().ifPresent(System.out::println);
    }
}
