package cote02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 단어 입력 및 소문자로 변환
        String word = sc.nextLine();

        // 알파벳별로 대/소문자 여부 확인 후 반대로 변환
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                sb.append(Character.toLowerCase(word.charAt(i)));
            } else {
                sb.append(Character.toUpperCase(word.charAt(i)));
            }
        }
        System.out.println(sb);
    }
}