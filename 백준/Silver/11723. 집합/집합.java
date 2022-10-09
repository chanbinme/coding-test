
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /* test case 입력 */
        int ts = Integer.parseInt(br.readLine());

        /* 명령어들을 담을 test 문자열 리스트 선언 */
        ArrayList<String> test = new ArrayList<>();
        /* 명령어 결과 값을 넣을 list 리스트 선언 */
        ArrayList<Integer> list = new ArrayList<>();
        /* test case만큼의 명령어 입력 받음 */
        for (int i = 0; i < ts; i++) {
            String cmd = br.readLine();
            if (cmd.contains("add")) {
                cmd = cmd.replace("add ", "");
                Integer num = Integer.parseInt(cmd);
                if (!list.contains(num)) list.add(num);
                /* cmd가 pop이라면 list 맨 마지막 요소 제거 후 제거된 요소 출력 */
            } else if (cmd.contains("remove")) {
                cmd = cmd.replace("remove ", "");
                Integer num = Integer.parseInt(cmd);
                if (list.contains(num)) list.remove(num);
                /* cmd에 값이 있으면 1 없으면 0 */
            } else if (cmd.contains("check")) {
                cmd = cmd.replace("check ", "");
                Integer num = Integer.parseInt(cmd);
                if (list.contains(num)) bw.write("1\n");
                else bw.write("0\n");
                /* cmd에 값이 있으면 삭제하고 없으면 추가하라*/
            } else if (cmd.contains("toggle")) {
                cmd = cmd.replace("toggle ", "");
                Integer num = Integer.parseInt(cmd);
                if (!list.contains(num)) list.add(num);
                else list.remove(num);
                /* cmd가 all.이라면 list {1, 2, ..., 20}으로 바꾼다. */
            } else if (cmd.equals("all")) {
                list.clear();
                for (int j = 1; j <= 20; j++) {
                    list.add(j);
                }
            } else if (cmd.equals("empty")) {
                list.clear();
            }
        }
        bw.flush();
    }
}
