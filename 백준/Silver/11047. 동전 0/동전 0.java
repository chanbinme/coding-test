import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 동전의 총 종류
        int type = scan.nextInt();
        // 만들어내야 할 금액
        int cost = scan.nextInt();
        // 필요한 코인 개수
        int count = 0;
        // type을 받을 수 있는 배열 생성
        int[] coins = new int[type];
        // type만큼의 동전을 배열에 받음
        for (int i = 0; i < type; i++) {
            coins[i] = scan.nextInt();
        }

        // 가장 큰 값의 동전부터 내림차순으로
        for (int i = coins.length - 1; i >= 0; i--) {
            // 동전 값이 cost보다 크지 않으면
            if(coins[i] <= cost) {
                // cost를 나누고 나눈 값을 count에 더하고
                count += cost / coins[i];
                // cost를 나눈 나머지 값을 cost에 다시 저장
                cost = cost % coins[i];
            }
            // cost가 0이되면 반복문 중단 및 count 출력
            if (cost == 0) {
                break;
            }
        }
        System.out.println(count);
    }
}