import java.util.Scanner;

public class Main {
    static int[] tmp;
    static int[] A;
    static int result = -1;
    static int count = 0;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int size = Integer.parseInt(strArr[0]);
        K = Integer.parseInt(strArr[1]);
        A = new int[size];
        tmp = new int[size];

        strArr = sc.nextLine().split(" ");
        for (int i = 0; i < strArr.length; i++) {
            A[i] = Integer.parseInt(strArr[i]);
        }
        merge_sort(0, size - 1);
        System.out.println(result);
    }

    static void merge_sort(int start, int end) {
        if (count > K) {
            return;
        }
        if (start < end) {
            int middle = (start + end) / 2;
            merge_sort(start, middle);
            merge_sort(middle + 1, end);
            merge(start, middle, end);
        }
    }

    static void merge(int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int t = 0;
        while (i <= middle && j <= end) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }
        while (i <= middle) {
            tmp[t++] = A[i++];
        }
        while (j <= end) {
            tmp[t++] = A[j++];
        }
        i = start;
        t = 0;
        while (i <= end) {
            count++;

            if (count == K) {
                result = tmp[t];
                break;
            }

            A[i++] = tmp[t++];
        }
    }
}