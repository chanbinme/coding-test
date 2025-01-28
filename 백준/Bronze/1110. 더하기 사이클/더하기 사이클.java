import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        // 10 미만의 수는 앞에 0을 붙여준다.
        if (Integer.parseInt(num) < 10) {
            num = "0" + num;
        }

        // 각 자리수를 구한다
        int a = num.charAt(0) - '0';
        int b = num.charAt(1) - '0';

        int cycle = 0;
        String newNum = "";

        // num과 동일한 값이 나올 때까지 반복한다.
        while (!num.equals(newNum)) {
            cycle++;
            int sum = a + b;
            a = b;
            b = sum % 10;
            newNum = "" + a + b;
        }
        System.out.println(cycle);
    }
}