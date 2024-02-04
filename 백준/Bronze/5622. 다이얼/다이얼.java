import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int totalSecond = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];

            if (c <= 67) {
                totalSecond += 3;
            } else if (c <= 70) {
                totalSecond += 4;
            } else if (c <= 73) {
                totalSecond += 5;
            } else if (c <= 76) {
                totalSecond += 6;
            } else if (c <= 79) {
                totalSecond += 7;
            } else if (c <= 83) {
                totalSecond += 8;
            } else if (c <= 86) {
                totalSecond += 9;
            } else if (c <= 90) {
                totalSecond += 10;
            }
        }

        System.out.println(totalSecond);
    }
}