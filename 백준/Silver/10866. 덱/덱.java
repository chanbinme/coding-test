import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* test case 입력 */
        int ts = Integer.parseInt(br.readLine());

        /* 명령어들을 담을 test 문자열 리스트 선언 */
        ArrayList<String> test = new ArrayList<>();
        /* 명령어 결과 값을 넣을 list 리스트 선언 */
        ArrayList<Integer> list = new ArrayList<>();
        /* test case만큼의 명령어 입력 받음 */
        for (int i = 0; i < ts; i++) {
            test.add(br.readLine());
        }
        /* test 순회 */
        Iterator<String> iterator = test.iterator();
        while (iterator.hasNext()) {
            /* cmd에 명령어 저장 */
            String cmd = iterator.next();
            /*
             * cmd가 push_front면 앞에 정수 추가
             * cmd가 push_back이면 뒤에 정수 추가
             */
            if (cmd.contains("push_front")) {
                cmd = cmd.replace("push_front ", "");
                Integer num = Integer.parseInt(cmd);
                list.add(0, num);
            } else if (cmd.contains("push_back")) {
                cmd = cmd.replace("push_back ", "");
                Integer num = Integer.parseInt(cmd);
                list.add(num);
                /*
                * cmd가 pop_front라면 list 맨 앞 요소 제거 후 제거된 요소 출력
                * cmd가 pop_back이라면 list 맨 뒤 요소 제거 후 제거된 요소 출력
                */
            } else if (cmd.equals("pop_front")) {
                if (list.isEmpty()) System.out.println(-1);
                else System.out.println(list.remove(0));
            } else if (cmd.equals("pop_back")) {
                if (list.isEmpty()) System.out.println(-1);
                else System.out.println(list.remove(list.size() - 1));
            /* cmd가 size라면 list 크기 출력 */
            } else if (cmd.equals("size")) {
                System.out.println(list.size());
                /* cmd가 empty라면 1 출력 아니라면 0 출력 */
            } else if (cmd.equals("empty")) {
                if (list.isEmpty()) System.out.println(1);
                else System.out.println(0);
                /* cmd가 front라면 list 맨 앞 요소 출력 */
            } else if (cmd.equals("front")) {
                if (list.isEmpty()) System.out.println(-1);
                else System.out.println(list.get(0));
                /* cmd가 back이라면 list 맨 마지막 요소 출력 */
            } else if (cmd.equals("back")) {
                if (list.isEmpty()) System.out.println(-1);
                else System.out.println(list.get(list.size() - 1));
            }
        }
    }
}
