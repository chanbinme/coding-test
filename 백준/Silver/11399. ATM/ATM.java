import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 첫째 줄에 사람의 수가 주어진다.
        int count = scan.nextInt();
        // 사람 수만큼 각 사람이 돈을 인출하는 데 걸린 시간이 주어진다.
        int[] p = new int[count];
        for (int i = 0; i < count; i++) {
            p[i] = scan.nextInt();
        }

        // 인출하는데 걸리는 시간을 오름차순으로 정렬
        Arrays.sort(p);

        // 각 사람이 인출하는데 필요한 시간
        int pTime = 0;
        // 각 사람이 인출하는데 필요한 시간의 합
        int result = 0;

        for (int i = 0; i < p.length; i++) {
            pTime += p[i];
            result += pTime;
        }

        System.out.println(result);
    }
}
