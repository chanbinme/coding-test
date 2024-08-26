import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        quickSort(0, numbers.length - 1, K - 1);
        System.out.println(numbers[K - 1]);
    }

    static void quickSort(int start, int end, int K) {
        if (start < end) {
            int pivot = selectPivot(start, end);
            if (pivot == K) {
                return;
            } else if (K < pivot) {
                quickSort(start, pivot - 1, K);
            } else {
                quickSort(pivot + 1, end, K);
            }
        }
    }

    // 피벗 구하기 함수
    static int selectPivot(int start, int end) {
        if (start + 1 == end) {
            if (numbers[start] > numbers[end]) {
                swap(start, end);
                return end;
            }
        }
        int middle = (start + end) / 2;
        swap(start, middle);
        int pivot = numbers[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (pivot < numbers[j] && j > 0) {
                j--;
            }
            while (pivot > numbers[i] && i < numbers.length - 1) {
                i++;
            }
            if (i <= j) {
                swap(i++, j--);
            }
        }
        numbers[start] = numbers[j];
        numbers[j] = pivot;
        return j;
    }

    public static void swap(int start, int end) {
        int temp = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = temp;
    }
}
