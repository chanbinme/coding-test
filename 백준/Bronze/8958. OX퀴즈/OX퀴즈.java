import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스 크기만큼 문자열 배열로 입력 받음
        // 문자열 배열을 문자 배열로 변환
        // 문자 배열 값 변환
        Scanner scan = new Scanner(System.in);
        int ts = scan.nextInt(); // 테스트 크기 입력

        String[] arr = new String[ts]; // 테스트 크기만큼의 문자열 배열 생성
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.next(); // 배열에 문자열 입력
        }

        for (int i = 0; i < arr.length; i++) {
            int count = 0; // 반복 횟수
            int sum = 0; // 합계

            for (int j = 0; j < arr[i].length(); j++) { // 문자 길이만큼 반복
                if (arr[i].charAt(j) == 'O') { // 문자가 O라면
                    count++; // count + 1;
                } else count = 0; // 아니라면 count = 0
                sum += count; // 합계 구하기
            }
            System.out.println(sum);
        }
    }
}
