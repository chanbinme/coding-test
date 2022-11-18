import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Object[][] arr = new Object[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = st.nextToken();
            arr[i][2] = i;
        }

        arr = Arrays.stream(arr).sorted(new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                return o1[0] != o2[0] ? (int)o1[0] - (int)o2[0] : (int)o1[2] - (int)o2[2];
            }
        }).toArray(Object[][]::new);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
