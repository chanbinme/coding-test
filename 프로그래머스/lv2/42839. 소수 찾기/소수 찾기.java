import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> answer = new HashSet<>();
    boolean[] isVisited;
    String numbers;

    public int solution(String numbers) {
        this.numbers = numbers;
        isVisited = new boolean[numbers.length()];
        permutation("", 0);

        return answer.size();
    }

    private void permutation(String numericString, int index) {
        int number;

        if (!numericString.equals("")) {
            number = Integer.parseInt(numericString);
            if (isPrime(number)) answer.add(number);
        }
//        if (isIndexOutOfBound(index)) return;

        for (int i = 0; i < numbers.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                permutation(numericString + numbers.charAt(i), index + 1);
                isVisited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number == 0 || number == 1) return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}