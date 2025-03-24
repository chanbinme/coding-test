import java.util.*;

public class Main {
    public int solution(int n, int[][] arr){
        int sum1, sum2;
        int answer = 0;
        for (int i = 0; i < n; i++){
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++){
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);
        return answer;
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(main.solution(n, arr));
    }
}[인프런 코테] Title: 격자판 최대합
