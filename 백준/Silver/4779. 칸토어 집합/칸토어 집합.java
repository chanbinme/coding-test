import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] result;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        String str;

        while ((str = br.readLine()) != null) {
            N = Integer.parseInt(str);
            int num = (int) Math.pow(3, N);
            result = new String[num];

            for (int i = 0; i < num; i++) {
                result[i] = "-";
            }

            cantor(num, 0);

            sb = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]);
            }

            System.out.println(sb.toString());
        }
    }

    static void cantor(int num, int start) {
        if (num == 1) {
            return;
        }
        int num2 = num / 3;
        int middleStart = start + num2;

        for (int i = middleStart; i < middleStart + num2; i++) {
            result[i] = " ";
        }
        cantor(num2, start);
        cantor(num2, middleStart + num2);
    }
}