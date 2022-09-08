import java.util.Scanner;

public class Main1096 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] result = new int[19][19];   // 19*19 2차 배열 생성
        int n = scan.nextInt();     // 돌의 개수 입력

        for (int xy = 0; xy < n; xy++) {
            int x = scan.nextInt(); // x축 위치 입력
            int y = scan.nextInt(); // y축 위치 입력
            result[x - 1][y - 1] = 1;   // 좌표(x,y)에 1입력
        }
        for (int i = 0; i < 19; i++) {  // x축 반복문
            for (int j = 0; j < 19; j++) {  // y축 반복문
                System.out.printf("%d ", result[i][j]); // 배열 출력
                if (j == 18) System.out.println();  // y축 19번째 위치마다 줄바꿈
            }
        }
    }
}
