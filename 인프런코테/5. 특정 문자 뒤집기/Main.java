package cote05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열 입력 받음
        String str = sc.nextLine();

        Main main = new Main();
        System.out.println(main.solution(str));
    }

    public String solution(String string) {
        char[] chars = string.toCharArray();
        int lt = 0;
        int rt = string.length() - 1;
        // lt와 rt가 교차할 때까지 반복
        while (lt < rt) {
            // lt와 rt가 문자가 아닐 때 lt와 rt 이동
            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else {
                // lt와 rt가 문자일 때 교체
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(chars);
    }
}
