import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 단어 입력
        String keyword = scan.nextLine();
        // char a 선언
        char a = 'a';
        // 알파벳 개수만큼 반복
        for (int i = 0; i < 26; i++) {
            String str = String.valueOf(a); // 문자를 문자열로 변환
            if (keyword.contains(str)) { // keyword에 str과 동일한 문자가 있으면
                System.out.print(keyword.indexOf(str) + " "); // str의 index값 출력
            } else System.out.print(-1 + " "); // 동일한 문자가 없으면 -1 출력
            a++; // 반복할때마다 다음 알파벳
        }
    }
}
