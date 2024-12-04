import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 문자 입력 받음
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        String s = strArr[0];
        char t = strArr[1].charAt(0);

        Main main = new Main();
        System.out.println(main.solution(s, t));
    }

    public String solution(String s, char t) {
        // 문자 배열로 변환
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        // 문자 배열 길이만큼 루프
        for (int i = 0; i <= chars.length - 1; i++) {
            // 현재 인덱스를 기준으로 양쪽으로 한 칸씩 이동하면서 t가 있는지 확인
            int left = i;
            int right = i;

            // 양 끝 인덱스에 도달할 때까지 반복
            while (left > 0 || right < chars.length - 1) {
                if (left > 0) left--;
                if(right < chars.length - 1) right++;

                // 현재 인덱스 문자가 t와 같다면 sb에 0 추가
                if (chars[i] == t) {
                    sb.append("0").append(' ');
                    break;
                }

                // 양쪽으로 이동하면서 t가 있는지 확인
                if (chars[left] == t) {
                    // t라면 현재 현재 인덱스 - 왼쪽 인덱스 값 sb 추가 및 루프 중단
                    sb.append(i - left).append(' ');
                    break;
                }
                if (chars[right] == t) {
                    // t라면 오른쪽 인덱스 - 현재 인덱스 값 sb 추가 및 루프 중단
                    sb.append(right - i).append(' ');
                    break;
                }
            }
        }
        // int로 변환
        return sb.toString();
    }
}

