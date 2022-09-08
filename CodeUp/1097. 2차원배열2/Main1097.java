import java.util.Scanner;

public class Main1097 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] result = new int[19][19];   // 19*19 2차 배열 생성

        for (int i = 0; i < 19; i++) {  // x축 반복문
            for (int j = 0; j < 19; j++) {  // y축 반복문
                result[i][j] = scan.nextInt();  // 좌표(x,y)에 값 입력
            }
        }

        int n = scan.nextInt();     // 돌의 개수 입력

        for (int xy = 0; xy < n; xy++) {
            int a = scan.nextInt(); // x축 위치 입력
            int b = scan.nextInt(); // y축 위치 입력
            int x = a -1;
            int y = b -1;
            for (int i = 0; i < 19; i++) {  // x축 1과 0 뒤집기
                if (result[x][i] == 0) result[x][i] = 1;
                else result[x][i] = 0;
            }
            for (int i = 0; i < 19; i++) {  // y축 1과 0 뒤집기
                if (result[i][y] == 0) result[i][y] = 1;
                else result[i][y] = 0;
            }
        }
        for (int i = 0; i < 19; i++) {  // x축 반복문
            for (int j = 0; j < 19; j++) {  // y축 반복문
                System.out.printf("%d ", result[i][j]); // 배열 출력
            }
            System.out.println();
        }
    }
}
