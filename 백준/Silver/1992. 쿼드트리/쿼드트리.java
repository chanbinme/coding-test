import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] board;

    public static void main(String[] args) {
        // board 크기 입력 받음
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        board = new int[N][N];

        // board 채우기
        for (int i = 0; i < N; i++) {
            String[] num = sc.nextLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(num[j]);
            }
        }

        partition(0, 0, N);
        System.out.println(sb.toString());
    }

    static void partition(int row, int col, int size) {
        if (numberCheck(row, col, size)) {
            // 모두 동일하다면 sb에 추가
            int num = board[row][col];
            sb.append(num);
        } else {
            // 아니라면 4등분하여 다시 진행. 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순서
            int newSize = size / 2;
            sb.append("(");
            partition(row, col, newSize);
            partition(row, col + newSize, newSize);
            partition(row + newSize, col, newSize);
            partition(row + newSize, col + newSize, newSize);
            sb.append(")");
        }
    }

    // 숫자 동일한지 체크
    static boolean numberCheck(int row, int col, int size) {
        int num = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (num != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}