
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ts = Integer.parseInt(br.readLine());
        
        ArrayList<String> test = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ts; i++) {
            test.add(br.readLine());
        }
        
        Iterator<String> iterator = test.iterator();
        while (iterator.hasNext()) {
            String cmd = iterator.next();
//        for(String cmd : test) {
            if (cmd.contains("push")) {
                cmd = cmd.replace("push ", "");
                Integer num = Integer.parseInt(cmd);
                list.add(num);
            } else if (cmd.equals("pop")) {
                if (list.isEmpty()) System.out.println(-1);
                else System.out.println(list.remove(list.size() - 1));
            } else if (cmd.equals("size")) {
                System.out.println(list.size());
            } else if (cmd.equals("empty")) {
                if (list.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (cmd.equals("top")) {
                if (list.isEmpty()) System.out.println(-1);
                else System.out.println(list.get(list.size() - 1));
            }
        }
    }
}
