import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        String[] strArr = sc.nextLine().split(" ");
        List<String> reverseStrArr = Arrays.stream(strArr).map(i -> {
            StringBuffer sb = new StringBuffer(i);
            return sb.reverse().toString();
        }).collect(Collectors.toList());

        ArrayList<Integer> primeList = new ArrayList<>();
        for (String str : reverseStrArr) {
            int num = Integer.parseInt(str);

            if (num < 2) {
                continue;
            }

            if (num == 2) {
                primeList.add(num);
                continue;
            }

            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                // 소수가 아닐 경우
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeList.add(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer num : primeList) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}