import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 도시 개수를 입력 받음
        long city = scan.nextLong();

        // 도로의 길이 배열
        long[] road = new long[(int)city - 1];
        // 도시 개수 -1 이동 수
        for (int i = 0; i < road.length; i++) {
            road[i] = scan.nextLong();
        }

        // 주유소 리터당 가격
        long[] oil = new long[(int)city];

        for (int i = 0; i < oil.length; i++) {
            oil[i] = scan.nextInt();
        }
        // 가장 기름값 저장할 위치
        long oilMin = oil[0];
        // 이동하는 최소 비용
        long result = oil[0] * road[0];
        // 출발지와 최종 도착지는 빼고 반복
        for (int i = 1; i < oil.length - 1; i++) {
            if (oilMin <= oil[i]) {
                result += oilMin * road[i];
            }
            else {
                oilMin = oil[i];
                result += oil[i] * road[i];
            }
        }
        System.out.println(result);
    }
}
