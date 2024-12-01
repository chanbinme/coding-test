package cote01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 단어 입력 및 소문자로 변환
        String word = sc.nextLine().toLowerCase();

        // 알파벳 입력
        String albabet = sc.nextLine().toLowerCase();

        // 알파벳이 단어에 몇 개 있는지 카운트
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == albabet.charAt(0)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
