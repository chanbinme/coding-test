import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        // 문자 리스트로 변환
        List<Character> chars = word.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        // 마지막 인덱스에 도달할 때까지 반복
        int idx = 0;
        while (idx < chars.size() - 1) {
            // 현재 인덱스의 문자 저장
            char currentChar = chars.get(idx);

            // 현재 마지막 인덱스부터 인덱스 +1 인덱스 문자까지 반복
            // 뒤에서부터 루프하는 이유는 중복되는 문자가 있을 경우 삭제하기 위함
            for (int i = chars.size() - 1; i > idx; i--) {
                // 중복되는 문자가 있으면 삭제
                if (currentChar == chars.get(i)) {
                    chars.remove(i);
                }
            }
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        chars.forEach(sb::append);
        return sb.toString();
    }
}