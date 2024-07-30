import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 스왑이 한 번도 일어나지 않은 루프가 언제인지 알아내는 문제
         * 버블소트로 풀면 시간초과로 풀 수 없다.
         * 데이터 정렬 전 index와 정렬 후 index를 비교해서 가장 많이 이동한 값을 통해 해당 루프를 알 수 있다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 배열 크기
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];

        for (int i = 0; i < N; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);

        int MAX = 0;
        for (int i = 0; i < A.length; i++) {
            int beforeInex = A[i].index;
            if (beforeInex - i > MAX) {
                MAX = beforeInex - i;
            }
        }

        // 스왑이 일어나지 않았을 때의 루프도 포함하기 위해 + 1
        System.out.println(MAX + 1);
    }

    static class mData implements Comparable<mData> {
        int value;
        int index;

        public mData(int value, int index) {
//            super();
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(mData o) {
            return this.value - o.value;
        }
    }
}
