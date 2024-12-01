package cote03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받은 문자를 공백을 기준으로 구분하여 배열에 저장
        String[] wordList = sc.nextLine().split(" ");

        // 배열 순회하며 단어 최대 길이 및 인덱스 값 저장
        int maxWordLength = 0;
        int index = 0;
        for (int i = 0; i < wordList.length; i++) {
            // 현재 단어의 길이가 최대 길이보다 길면 최대 길이 및 인덱스 값 갱신
            int currentWordLength = wordList[i].length();
            if (currentWordLength > maxWordLength) {
                maxWordLength = currentWordLength;
                index = i;
            }
        }

        System.out.println(wordList[index]);
    }
}
