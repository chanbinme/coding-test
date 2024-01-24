import java.util.Scanner;

public class Main {
    static int minusOneCount = 0;
    static int zeroCount = 0;
    static int plusOneCount = 0;
    static int[][] board;

    public static void main(String[] args) {
        // 종이 크기 입력 받음
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] paperTypeArr = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(paperTypeArr[j]);
            }
        }

        checkPaperType(0, 0, N);

        System.out.println(minusOneCount);
        System.out.println(zeroCount);
        System.out.println(plusOneCount);
    }

    static void checkPaperType(int startRow, int startCol, int size) {
        if (size == 1) {
            int number = board[startRow][startCol];
            checkPaperType(number);
            return;
        }

        // 같은 종이인지 체크
        int startNumber = board[startRow][startCol];
        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startCol; j < startCol + size; j++) {

                // 같은 종이가 아니라면 3등분
                if (startNumber != board[i][j]) {
                    int newSize = size / 3;
                    checkPaperType(startRow, startCol, newSize);
                    checkPaperType(startRow, startCol + newSize, newSize);
                    checkPaperType(startRow, startCol + newSize + newSize, newSize);
                    checkPaperType(startRow + newSize, startCol, newSize);
                    checkPaperType(startRow + newSize, startCol + newSize, newSize);
                    checkPaperType(startRow + newSize, startCol + newSize + newSize, newSize);
                    checkPaperType(startRow + newSize + newSize, startCol, newSize);
                    checkPaperType(startRow + newSize + newSize, startCol + newSize, newSize);
                    checkPaperType(startRow + newSize + newSize, startCol + newSize + newSize, newSize);
                    return;
                }
            }
        }
        checkPaperType(startNumber);
    }

    // 종이 타입 체크
    static void checkPaperType(int number) {
        if (number == -1) {
            minusOneCount++;
        } else if (number == 0) {
            zeroCount++;
        } else if (number == 1) {
            plusOneCount++;
        }
    }
}
