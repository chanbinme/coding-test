package cote04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N개의 단어 입력 받은 후 뒤집어 출력
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            System.out.println(sb.append(sc.nextLine()).reverse());
        }
    }
}