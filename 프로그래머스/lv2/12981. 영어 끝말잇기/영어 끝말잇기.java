import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {

        // 등장했던 단어를 저장할 list
        List<String> list = new ArrayList<>();

        // words[0]에 문제있으면 바로 끝
        if (words[0].length() < 2 && words[0].length() > 50) {
            int[] answer = {1, 1};
            return answer;
        }
        // 첫 번째 단어 리스트에 저장
        else list.add(words[0]);


        // 사람의 번호. 첫 번째 사람은 이미 한걸로 치기때문에 2부터 시작
        int person = 2;
        // 몇 번째 차례인지
        int turn = 1;
        // 게임이 무사히 끝난지 확인하기 위한 값
        int end = 1;

        // 끝말 잇기 시작. 편의를 위해 1부터 시작
        for (int i = 1; i < words.length; i++) {
            // 단어의 길이가 2보다 작거나 50보다 크다면
            if (words[i].length() < 2 && words[i].length() > 50) {
                break;
            }
            // 앞사람이 말한 단어의 마지막 문자와 현재 사람의 단어의 시작하는 문자가 같지 않으면
            else if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                break;
            }
            // 이전에 등장했던 단어라면
            else if (list.contains(words[i])) {
                break;
            }

            // 단어를 list에 저장
            list.add(words[i]);
            
            // 다음 순서의 사람
            person++;
            
            // 게임 + 1
            end++;
            
            // 사람의 순서가 n을 넘으면 첫 번째 사람으로 돌아감. 게임 차례 + 1
            if (person > n) {
                person = 1;
                turn++;
            }
        }
        if (end == words.length) {
            int[] answer = {0, 0};
            return answer;
            
        } else {
            int[] answer = {person, turn};
            return answer;
        }

    }
}