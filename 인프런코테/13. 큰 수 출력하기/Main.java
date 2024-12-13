import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        // 입력될 숫자 개수(사용안함)
        Integer.parseInt(sc.nextLine());

        // 숫자 리스트 입력 받음
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        System.out.println(main.solution(numbers));
    }

    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int preNum = 0;

        // size만큼 루프
        for (int i = 0; i < numbers.length; i++) {
            // currentNum이 preNum보다 크면 sb에 추가
            int currentNum = numbers[i];
            if (currentNum > preNum) {
                sb.append(currentNum).append(" ");
            }
            // currentNum을 preNum으로 설정
            preNum = currentNum;
        }

        return sb.toString();
    }
}