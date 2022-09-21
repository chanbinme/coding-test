import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt(); // 고정비용
        int b = scan.nextInt(); // 가변비용
        int c = scan.nextInt(); // 판매비용

        if (c <= b) System.out.println(-1); // 판매비용이 가변비용보다 저렴하면 망함 -1
        else {
            int sum = c - b; // 판매비용에서 가변비용을 뺌
            int cnt = (a / sum) + 1; // 고정비용 sum을 나누고 1개를 더 팔아야 손익분기점을 넘김
            System.out.println(cnt);
        }
    }
}