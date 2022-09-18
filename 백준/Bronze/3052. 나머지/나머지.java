import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10]; // 정수형 배열 생성
        int[] arr2 = new int[10]; // 2번째 정수형 배열 생성

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt() % 42; // 입력 값의 42를 나눈 나머지 값을 배열에 선언
        }

        long count = Arrays.stream(arr) // 배열 스트림으로 변환
                .distinct() // 중복 제거
                .count(); // 총 개수 출력

        System.out.println((int)count); // count는 long타입이기때문에 int타입으로 변환
    }
}
