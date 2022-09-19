import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int nsn; // 셀프넘버가 아닌 수
        List<Integer> list = new ArrayList<>(); // 셀프넘버가 아닌 수를 넣을 리스트 생성

        for (int i = 1; i < 10000; i++) { // i가 10000보다 같거나 작을때까지 반복
            if (i >= 1000) { // i가 1000 이상이면
                nsn = i + // i 더하기
                        (i % 10) + // 1의 자리 더하기
                        ((i / 10) % 10) + // 10의 자리 더하기
                        ((i / 100) % 10) + // 100의 자리 더하기
                        ((i / 1000) % 10); // 1000의 자리 더하기
            } else if (i >= 100) {
                nsn = i + (i % 10) + ((i / 10) % 10) + ((i / 100) % 10);
            } else if (i >= 10) { nsn = i + (i % 10) + ((i / 10) % 10);
            } else nsn = i + i % 10;

            list.add(nsn);
        }
        for (int i = 1; i <= 10000; i++) {
            if (list.contains(i) == false) { // i값이 list에 포함되지 않으면
                System.out.println(i); // i 출력
            }
        }
    }
}
