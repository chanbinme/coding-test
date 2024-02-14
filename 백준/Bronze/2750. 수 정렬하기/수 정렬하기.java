import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseSize = Integer.parseInt(br.readLine());
        int[] ints = new int[caseSize];
        for (int i = 0; i < caseSize; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }

        int[] result = Arrays.stream(ints).sorted().toArray();
        for (int i : result) {
            System.out.println(i);
        }
    }
}