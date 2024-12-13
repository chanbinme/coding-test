import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 문자 입력 받음
        Scanner sc = new Scanner(System.in);

        // 문자의 개수(10을 넘지 않음) 및 문자 입력
        int count = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        Main main = new Main();
        System.out.println(main.solution(str, count));
    }

    public String solution(String str, int count) {
        StringBuilder sb = new StringBuilder();
        // 이진수로 변환 # -> 1, * -> 0
        String[] split = str.split("");
        for (String s : split) {
            if (s.equals("#")) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        // 문자열을 7개씩 끊어서 2진수 -> 10진수로 변환
        String binary = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String substring = binary.substring(i * 7, i * 7 + 7);
            int decimal = Integer.parseInt(substring, 2);

            // 아스키코드로 변환
            sb.append((char) decimal);
        }

        return sb.toString();
    }
