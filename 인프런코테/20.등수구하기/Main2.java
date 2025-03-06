import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Integer[] scores = new Integer[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        // 이중 for문으로 쉽게 처리
        StringBuilder sb = new StringBuilder();
        for (Integer score : scores) {
            int rank = 1;
            for (Integer compareScore : scores) {
                if (score < compareScore) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }
}
