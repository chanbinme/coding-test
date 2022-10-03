import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cal = scan.next();
        // 괄호를 적절히 쳐서 최소값이 나오는 식을 만들어라
        // 예. 55-50+40 -> 55-(50+40) = -35
        // -를 기준으로 split 해준다.
        String[] calMin = cal.split("-");
        // 배열마다 +로 split 후 합산
        for (int i = 0; i < calMin.length; i++) {
            if (calMin[i].contains("+")) {
                int sum = 0;
                // 정규식에서 +는 메타문자로 앞에 있는 문자가 있어야 의미가 있는데
                // 문자가 없는 채로 사용하려하기 때문에 문자 그대로 매칭하기 위해 이스케이프(\)를 사용해야 한다.
                String[] sumArr = calMin[i].split("\\+");
                for (int j = 0; j < sumArr.length; j++) {
                    sum += Integer.parseInt(sumArr[j]);
                }
                calMin[i] = sum + "";
            }
        }
        int minSum = Integer.parseInt(calMin[0]);
        if (calMin.length == 1) System.out.println(minSum);
        else {
            // 배열의 모든 값을 빼주자
            for (int i = 1; i < calMin.length; i++) {
                minSum -= Integer.parseInt(calMin[i]);
            }
            System.out.println(minSum);
        }

    }
}
