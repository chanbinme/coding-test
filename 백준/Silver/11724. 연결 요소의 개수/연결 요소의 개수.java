

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int vertex;  // 정점
    static int edge;    // 간선
    static int count;   // 연결 요수의 개수
    static boolean[] isVisited; // 방문 여부 체크
    static int[][] arr; // 간선 양 끝 정점을 받을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        vertex = Integer.parseInt(strArr[0]);
        edge = Integer.parseInt(strArr[1]);
        count = 0;
        isVisited = new boolean[vertex + 1];

        // 편의를 위해 index0 사용 안함
        arr = new int[vertex + 1][vertex + 1];

        /* 간선의 양 끝점 입력 받음 */
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            /* 무향 그래프 */
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        /* 정점 탐색 */
        for (int i = 1; i < arr.length; i++) {
            /* 탐색한적 없는 정점이라면 */
            if (isVisited[i] == false) {
                /* 탐색 시작 */
                dfs(i);
                /* dfs가 끝나면 하나의 연결 요소가 구해졌다는 뜻이기 때문에 count +1 */
                count++;
            }
        }
        System.out.println(count);

    }
    static void dfs(int i) {
        /* x 방문 체크 */
        isVisited[i] = true;

        /* 방문하지 않았고 간선이 연결되어 있다면 dfs에 다시 쏘옥~ */
        for (int j = 1; j < arr.length; j++) {
            if (arr[i][j] == 1 && isVisited[j] == false) {
                dfs(j);
            }
        }
    }
}


