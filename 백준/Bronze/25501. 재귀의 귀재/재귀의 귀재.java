import java.util.Scanner;

public class Main {
    static int count = 1;
    static int palindrome = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        String[] strArr = new String[testCase];
        for (int i = 0; i < testCase; i++) {
            strArr[i] = sc.nextLine();
        }

        for (String word : strArr) {
            isPalidrome(word, 0, word.length() - 1);
            System.out.printf("%d %d%n", palindrome, count);
            count = 1;
        }
    }

    static void isPalidrome(String word, int start, int end) {
        char startChar = word.charAt(start);
        char endChar = word.charAt(end);

        if (startChar != endChar) {
            palindrome = 0;
            return;
        } else if (start == end || start > end) {
            palindrome = 1;
            return;
        }

        count++;
        isPalidrome(word, start + 1, end - 1);
    }
}