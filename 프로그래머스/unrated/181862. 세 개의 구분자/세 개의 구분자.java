import java.util.Arrays;
import java.util.Objects;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
        answer = myStr.split("[abc]");

        if(answer.length == 0) {
            return new String[]{"EMPTY"};
        } else {
            answer = Arrays.stream(answer)
                    .filter(i -> !Objects.equals(i, ""))
                    .toArray(String[]::new);
        }
        return answer;
    }
}