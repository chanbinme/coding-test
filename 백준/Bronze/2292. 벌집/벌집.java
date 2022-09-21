import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 방 개수는 겹마다 6개씩 늘어남

        int rNum = scan.nextInt(); // 가야 할 방 번호
        int cnt = 1; // 지나야 할 방 개수
        int room = 1; // 겹이 늘어날 때마다 포함될 방 개수


        while (room < rNum) { // 방 개수가 가야할 방 번호보다 커질 때까지
            room += cnt * 6; // 방 개수 cnt*6씩 늘어남
            cnt++; // 반복 때마다 지나갈 방 개수 +1
        }
        System.out.println(cnt);
    }
}