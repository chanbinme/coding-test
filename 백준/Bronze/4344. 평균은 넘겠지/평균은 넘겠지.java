import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스를 받는다.
        // 테스트 케이스별 학생 수에 맞게 점수를 받는다.
        // 케이스별 평균 점수를 구한다.
        // 평균 점수는 반올림하여 소수점 셋째자까지 출력한다.
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        int[] tcArr = new int[tc];

        for (int i = 0; i < tcArr.length; i++) {
            int num = scan.nextInt(); // 학생 수 입력
            int sum = 0; // 점수 합계
            int[] ts = new int[num]; // 점수 넣을 배열 생성

            for (int j = 0; j < num; j++) { // 학생 수 만큼 점수 입력
                int score = scan.nextInt();
                sum += score; // 입력된 점수를 합함
                ts[j] = score; // 배열에 점수 입력
            }
            double average = sum / num; // 평균 점수
            double count = 0; // 평균 넘는 학생 수
            for (double score : ts) {
                if (score > average) count++; // 평균점수 넘는 학생 나올 때마다 count + 1
            }
            double result = (count / num) * 100; // 전체 학생 중 평균점수 넘는 학생 비율
            System.out.printf("%.3f%%\n", result); // 반올림하여 소수점 셋째자리까지만 출력
        }
    }
}