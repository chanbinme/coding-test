import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        System.out.println(mostAlphabet(word));
    }

    public static String mostAlphabet(String word) {
        // 대문자로 변환
        word = word.toUpperCase();

        // 대문자 개수만큼의 배열 생성
        int[] charArr = new int[26];

        // 문자열의 알파벳 순회
        for (int i = 0; i < word.length(); i++) {
            // 해당 알파벳의 아스키코드 값 index에 + 1
            charArr[word.charAt(i) - 65]++;
        }

        // 가장 큰 수 체크
        List<Character> mostAlphabet = new ArrayList<>();

        // 최대 개수
        int max = 0;

        for (int i = 0; i < charArr.length; i++) {
            // max보다 크면
            if (charArr[i] > max) {
                // max에 가장 큰 수 대체
                max = charArr[i];
                // 기존 mostAlphabet 모두 지우고 현재 가장 많이 사용된 문자 추가
                mostAlphabet.clear();
                mostAlphabet.add((char) (i + 65));
                // max와 값이 같으면
            } else if (charArr[i] == max) {
                // 해당 문자 mostAlphabet에 추가
                mostAlphabet.add((char) (i + 65));
            }
        }
        // mostAlphabet의 개수가 1개이면 해당 문자 리턴
        if (mostAlphabet.size() == 1) {
            return mostAlphabet.get(0) + "";
        }
        // mostAlphabet의 개수가 2 이상이면 물음표 출력
        else return "?";
    }
}
