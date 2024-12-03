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
        // 대소문자 구분하지 않기 위해 소문자로 변환
        word = word.toLowerCase();
        // 문자 배열로 변환
        char[] chars = word.toCharArray();

        // lt와 rt가 교차할 때까지 반복
        int lt = 0;
        int rt = chars.length - 1;
        while (lt < rt) {
            // lt 문자와 rt 문자가 다르면 NO 반환
            if (chars[lt] != chars[rt]) {
                return "NO";
            }
            // lt와 rt 이동
            lt++;
            rt--;
        }
        // YES 반환
        return "YES";
    }
}