import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int a = sc.nextInt();
int b = sc.nextInt();

    System.out.println(IntStream.rangeClosed(1, a * b).mapToObj(i -> i % a == 0 ? "*\n" : "*").collect(Collectors.joining()));
}
}