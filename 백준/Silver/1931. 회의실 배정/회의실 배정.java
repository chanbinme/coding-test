import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 1개의 회의실에 N개의 회의에 대한 회의실 사용표를 만든다.
        // 각 회의는 시작시간과 끝나는 시간이 주어진다.
        // 최대한 많은 회의가 이루어지는 경우의 회의 개수를 구하자

        // 조건 1. 회의 시간이 짧아야 한다.
        // 조건 2. 회의 시간이 겹쳐서는 안된다.

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

        String[] arr = new String[2];
        
        // 회의 개수 N개의 값을 입력
        int n = Integer.parseInt(bf.readLine());
        // N개의 회의 시간 표를 넣을 배열 생성
        int[][] meet = new int[n][2];
        // N개의 회의 시간 표를 입력
        for(int i = 0; i < meet.length; i++) {
                String st = bf.readLine();
                arr = st.split(" ");
                meet[i][0] = Integer.parseInt(arr[0]);
                meet[i][1] = Integer.parseInt(arr[1]);

        }

        // // 시작시간 오름차순으로 회의 정렬. bouble sort 활용
        // for (int i = 0; i < meet.length; i++) {
        //     for (int j = i + 1; j < meet.length; j++) {
        //         if (meet[i][1] > meet[j][1] || (meet[i][1] == meet[j][1] && meet[i][0] > meet[j][0])) {
        //             Collections.swap(Arrays.asList(meet), i, j);
        //         }
        //     }
        // }
        Arrays.sort(meet, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                else return a[1] - b[1];
            }
        });

        // 첫 번째 회의 시작 시간 끝나는 시간 저장
        int end = 0;
        // 회의 개수 1개 미리 선언
        int count = 0;
        // 제일 빨리 끝나는 회의 그 다음으로 제일 빨리 시작하는 회의를 찾으면?
        for (int i = 0; i < meet.length; i++) {
            if(end <= meet[i][0]) {
                end = meet[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
