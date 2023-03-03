import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // 명령 갯수만큼의 배열을 생성한다.
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            // 자를 배열의 첫 번째 인덱스(
            int start = commands[i][0] - 1;

            // 자를 배열의 마지막 인덱스
            int end = commands[i][1];

            // 인덱스는 0부터 시작하기때문에 -1을 해준다.
            int idx = commands[i][2] - 1;

            // command대로 배열을 자른다.
            int[] slice = Arrays.copyOfRange(array, start, end);

            // 자른 배열을 정렬한다.
            Arrays.sort(slice);

            // idx번째 값을 answer에 넣는다.
            answer[i] = slice[idx];
        }

        return answer;
    }
}