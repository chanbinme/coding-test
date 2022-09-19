import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ts = sc.nextInt();

        for (int i = 0; i < ts; i++) { // ts만큼 반복
            int repeat = sc.nextInt(); // 반복횟수 입력
            String str = sc.next(); // 문자열 입력

            // 반복횟수 * 문자열 길이만큼 곱한 크기의 char 배열 생성
            char[] chArr = new char[repeat * str.length()];
            int pos = 0;
            for (int j = 0; j < str.length(); j++) { // 문자열 길이만큼 반복
                for (int k = 0; k < repeat; k++) { // 반복횟수만큼 반복
                    chArr[pos] = str.charAt(j); // 반복횟수만큼 해당 인덱스 문자 chArr에 저장
                    pos++;
                }
            }
            System.out.println(String.valueOf(chArr)); // 문자 배열 문자열로 변환
        }
    }
}