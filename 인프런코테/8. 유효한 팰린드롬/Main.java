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
        String answer = "NO";

        // 소문자로 변환 후 알파벳을 제외한 문자 및 공백 제거
        word = word.toLowerCase().replaceAll("[^a-z]", "");

        // 문자를 뒤집음. 뒤집은 문자와 문자가 같으면 팰린드롬 문자
        String reverseWord = new StringBuilder(word).reverse().toString();
        if (word.equals(reverseWord)) {
            answer = "YES";
        }

        return answer;
    }
}
