import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열 입력 받음
        String str = sc.nextLine();

        Main main = new Main();
        System.out.println(main.solution(str));
    }

    public String solution(String string) {
        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();

        // 첫 번째 문자와 count 초기화
        int count = 1;
        char base = chars[0];

        for (int i = 1; i < chars.length; i++) {
            // base와 같은 문자라면 count 증가
            char c = chars[i];
            if (base == c) {
                count++;
            } else {
                // base와 다른 문자라면 count와 base를 sb에 추가
                sb.append(base);
                // 1 초과라면 count도 추가
                if (count > 1) {
                    sb.append(count);
                }

                // base를 현재 문자로 변경, count를 1로 초기화
                base = c;
                count = 1;
            }

            // 마지막 문자라면 base와 count를 sb에 추가
            if (i == chars.length - 1) {
                sb.append(base);
                // 1 초과라면 count도 추가
                if (count > 1) {
                    sb.append(count);
                }
            }

        }
        return sb.toString();
    }
}
