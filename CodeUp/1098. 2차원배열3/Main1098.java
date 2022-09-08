import java.util.Scanner;

public class Main1098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();   // height 값 입력
        int w = sc.nextInt();   // width 값 입력

        int[][] arr = new int[h][w];    // 좌표 생성
        int n = sc.nextInt();   // 막대 개수 입력

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();   // 막대 길이 값 입력
            int d = sc.nextInt();   // 방향 입력
            int x = sc.nextInt() - 1;   // x 좌표 입력
            int y = sc.nextInt() - 1;   // y 좌표 입력

            for (int j = 0; j < l; j++) {   // 막대 길이만큼 반복
                if(d == 0) {    // 방향이 0이면 y축+
                    arr[x][y++] += 1;
                }               // 방향이 1이면 x축+
                else arr[x++][y] += 1;
            }
        }

        for (int i = 0; i < h; i++) {   // h*w 배열 출력
            for (int j = 0; j < w; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
