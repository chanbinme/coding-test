import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] gradeArray = sc.nextLine().split(" ");
        int sum = 0;
        int point = 0;
        for (String string : gradeArray) {
            int grade = Integer.parseInt(string);

            // 오답이면 point 초기화
            if (grade == 0) {
                point = 0;
                // 정답이면 point 증가
            } else {
                point++;
            }
            // 총합에 더하기
            sum += point;
        }

        System.out.println(sum);
    }
}
