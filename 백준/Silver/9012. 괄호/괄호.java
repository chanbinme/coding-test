import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* test case 입력 */
        int ts = scan.nextInt();
        /* test case만큼 문자열 배열 arr에 입력 */
        String[] arr = new String[ts];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.next();
        }
        /* arr[i]에 "()"가 있다면 없어질 때까지 삭제 */
        for (int i = 0; i < arr.length; i++) {
            while (arr[i].contains("()")) {
                arr[i] = arr[i].replace("()", "");
            }
            /*
            * 빈문자열이라면 "()"만 갖고있던 문자열이기 때문에 YES 출력
            * 빈문자열이 아니라면 "()" 외에 다른 괄호가 있다는 뜻이므로 NO 출력
            * */
            if (arr[i].equals("")) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
