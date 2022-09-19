import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 무시
        int a = sc.nextInt();
        // 문자형으로 받음
        String str = sc.next();
        // 문자로 분리하여 문자열 배열에 저장
        String[] strArr = str.split("");

        int result = Arrays.stream(strArr)  // 스트림으로 변환 후
                .mapToInt(Integer::parseInt)    // 문자열을 정수형으로 변환
                .sum(); // 합계 출력
        System.out.println(result);
    }
}
