import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 문자 입력 받음
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Main main = new Main();
        System.out.println(main.solution(N));
    }

    public int solution(int N) {
        // 0부터 N까지 담을 수 있는 배열 생성
        int[] ints = new int[N + 1];
        int count = 0;

        // 소수는 1과 자신만 나눌 수 있는 값이기 때문에 2부터 시작
        for (int i = 2; i <= N; i++) {
            // i 값이 0이면 count +1, 이후 i의 N까지의 배수 인덱스에 +1
            if (ints[i] == 0) {
                count++;
                int num = 1;
                while (i * num <= N) {
                    ints[i * num] += 1;
                    num++;
                }
            }
        }
        return count;
    }
}
