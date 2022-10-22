import java.io.*;

public class Main {
    /**
     * 0 개수를 저장할 zeroCount 생성
     * 1 개수를 저장할 oneCount 생성
     */
    static int zeroCount = 0;
    static int oneCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 테스트 케이스의 개수 입력 */
        int tc = Integer.parseInt(br.readLine());

        /* 테스트 케이스 크기만큼의 배열 생성 */
        int[] test = new int[tc];

        /* 테스트 케이스 입력 */
        for (int i = 0; i < tc; i++) {
            test[i] = Integer.parseInt(br.readLine());
        }

        /* 테스트 케이스만큼 fibonacci 테스트 */
        for (int i = 0; i < test.length; i++) {
            fibonacci(test[i]);
            System.out.println(zeroCount + " " + oneCount);
            /* 다음 케이스를 위해 값 0으로 선언 */
            zeroCount = 0;
            oneCount = 0;
        }
    }

    /* for문으로 해결 */
    public static void fibonacci(int n) {
        /* f1 = f - 2 역할, f2 = f - 1 역할 이걸 역으로 진행할 예정 */
        int f1 = 0;
        int f2 = 1;
        int f = 0;

        /* n이 0이면 0만 카운트 1 */
        if (n == 0) {
            zeroCount = 1;
            return;
        }
        /* n이 1이면 1만 카운트 1 */
        else if (n == 1) {
            oneCount = 1;
            return;
        } else if (n < 0) return;
        else {
            /* 0과 1의 값은 지정했기 때문에 i는 2부터 시작 */
            for (int i = 2; i <= n; i++) {
                f = f1 + f2;
                f1 = f2;
                f2 = f;
            }
            /* 최종 f1이 0이 호출된 개수, f2이 1이 호출된 개수 */
            zeroCount = f1;
            oneCount = f2;
        }
    }
}
