import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 문자 입력 받음
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        Main main = new Main();
        System.out.println(main.solution(word));
    }

    public int solution(String word) {
        // 문자 배열로 변환
        char[] chars = word.toCharArray();

        // 문자 배열 길이만큼 루프
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            //  숫자라면 sb에 추가
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        // int로 변환
        return Integer.parseInt(sb.toString());
    }
}