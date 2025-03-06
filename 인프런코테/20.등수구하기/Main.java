import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Integer[] scores = new Integer[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        // 점수 기준으로 내림차순 정렬
        Integer[] scoresReverseOrder = scores.clone();
        Arrays.sort(scoresReverseOrder, Comparator.reverseOrder());

        // 등수 계산. 앞 순서와 같은 점수인 경우 등수만 +1 해주고 저장하지 않음
        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();

        // 1등은 미리 넣어둠
        map.put(scoresReverseOrder[0], rank);
        for (int i = 1; i < N; i++) {
            rank++;
            if (i > 0 && scoresReverseOrder[i] != scoresReverseOrder[i - 1]) {
                map.put(scoresReverseOrder[i], rank);
            }
        }

        // 순서대로 등수 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(scores[i])).append(" ");
        }

        System.out.println(sb);
    }
}
