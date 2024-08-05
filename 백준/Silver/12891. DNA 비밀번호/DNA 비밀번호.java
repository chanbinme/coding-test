import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int A;
    private static int C;
    private static int T;
    private static int G;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // DNA 문자열의 길이, 부분 문자열의 길이
        String[] s = br.readLine().split(" ");
        int S = Integer.parseInt(s[0]);     // 문자열 길이
        int P = Integer.parseInt(s[1]);     // 부분 문자열 길이

        // DNA 문자열
        String DNA = br.readLine();

        // 부분 문자열에 포함돼야 할 A, C, G, T의 최소 개수
        String[] actg = br.readLine().split(" ");
        A = Integer.parseInt(actg[0]);
        C = Integer.parseInt(actg[1]);
        G = Integer.parseInt(actg[2]);
        T = Integer.parseInt(actg[3]);

        // 부분 문자열의 길이만큼 문자열 Queue에 넣어 A, C, G, T 개수 계산
        Queue<Character> queue = new LinkedList<>();
        int aCount = 0;
        int cCount = 0;
        int tCount = 0;
        int gCount = 0;
        for (int i = 0; i < P; i++) {
            char c = DNA.charAt(i);
            queue.add(c);
            switch (c) {
                case 'A' : aCount++; break;
                case 'C' : cCount++; break;
                case 'T' : tCount++; break;
                case 'G' : gCount++; break;
                default: break;
            }
        }
        checkDNA(aCount, cCount, tCount, gCount);


        // 이후부터는 하나씩 이동
        for (int i = P; i < S; i++) {
            // 첫 번째 문자 하나 제외
            Character poll = queue.poll();
            switch (poll) {
                case 'A' : aCount--; break;
                case 'C' : cCount--; break;
                case 'T' : tCount--; break;
                case 'G' : gCount--; break;
                default: break;
            }

            // 다음 문자 추가
            char c = DNA.charAt(i);
            queue.add(c);
            switch (c) {
                case 'A' : aCount++; break;
                case 'C' : cCount++; break;
                case 'T' : tCount++; break;
                case 'G' : gCount++; break;
                default: break;
            }
            checkDNA(aCount, cCount, tCount, gCount);
        }

        System.out.println(result);
    }

    private static void checkDNA(int aCount, int cCount, int tCount, int gCount) {
        if (aCount >= A && cCount >= C && tCount >= T && gCount >= G) {
            result++;
        }
    }
}
