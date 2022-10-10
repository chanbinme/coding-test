import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* 컴퓨터 개수를 입력받음 */
        int computer = scan.nextInt();
        /* 컴퓨터 개수만큼 네트워크 공간 형성 */
        int[][] network = new int[computer + 1][computer + 1];
        /* 네트워크 상에서 직접 연결되는 컴퓨터 쌍의 수 */
        int connect = scan.nextInt();

        /* 관계 형성된 컴퓨터를 1로 check */
        for (int i = 0; i < connect; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();

            network[from][to] = 1;
            network[to][from] = 1;
        }
        /* DFS로 접근해보자 */
        Stack<Integer> stack = new Stack<>();
        /* 방문했던 컴퓨터인지 체크하기 위한 boolean 배열 생성 */
        boolean[] isSelected = new boolean[computer + 1];

        /* stack에 1번 컴퓨터를 넣는다. */
        stack.add(1);
        /* 1번 컴퓨터 방문 체크 */
        isSelected[1] = true;
        /* 1번 컴퓨터로 인해 감염될 컴퓨터 개수 */
        int count = 0;
        /* stack이 빌 때까지 반복 */
        while (!stack.isEmpty()) {
            /* from에 stack에 마지막에 저장된컴퓨터를 뽑아 넣는다 */
            int from = stack.pop();
            /* from 컴퓨터와 연결된 컴퓨터 탐색 */
            for (int i = 0; i < network[from].length; i++) {
                /* 연결되어있고 방문한적이 없는 컴퓨터라면 */
                if (network[from][i] == 1 && isSelected[i] == false) {
                    /* stack에 해당 컴퓨터 저장해주고 방문표시, count + 1 */
                    stack.add(i);
                    isSelected[i] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
