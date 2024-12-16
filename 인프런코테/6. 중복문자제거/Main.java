import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 문자 입력 받음
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        Main main = new Main();
        String result = main.solution(word);
        System.out.println(result);
    }

    public String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            // 단어에서 첫번째로 발견되는 문자 인덱스
            int firstCharIndex = word.indexOf(word.charAt(i));
            // 단어에서 첫번째로 발견된 문자 인덱스와 현재 인덱스의 값이 같지 않으면 중복된 문자
            if (firstCharIndex == i) {
                answer += word.charAt(i);
            }
        }

        return answer;
    }
}
