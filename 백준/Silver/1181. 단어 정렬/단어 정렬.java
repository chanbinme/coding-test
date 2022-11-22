import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ts = Integer.parseInt(br.readLine());

        // 중복된 단어가 나오면 배열 길이가 달라지기 때문에 배열이 아닌 리스트 사용
        List<String> arr = new ArrayList<>();

        // ts만큼 단어를 입력 받음
        for (int i = 0; i < ts; i++) {
            String as = br.readLine();
            // 중복되는 단어가 나오면 제외
            if (!arr.contains(as)) {
                arr.add(as);
            }
        }

        // 정렬
        arr = arr.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 길이가 같으면
                if (o1.length() == o2.length()) {
                    int j = 0;
                    while (true) {
                        // 문자열의 j번째 문자가 같지 않으면
                        if (o1.charAt(j) != o2.charAt(j)) {
                            // 문자열 기준으로 오름차순
                            return o1.charAt(j) - o2.charAt(j);
                        }
                        // 문자열의 문자가 같으면 j++
                        j++;
                    }
                }
                // 문자열 길이가 다르면 길이 기준으로 오름차순
                return o1.length() - o2.length();
            }
        }).collect(Collectors.toList());

        for (String str : arr) {
            bw.write(str + "\n");
        }
        bw.close();
    }
}
