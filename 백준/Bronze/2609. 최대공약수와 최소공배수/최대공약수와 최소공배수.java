import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        
        String[] arr = str.split(" ");
        
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int r;
        
        int multiply = a * b;
        
        // 최대 공약수
        while(a % b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        System.out.println(b);
        
        
        // 최소 공배수
        System.out.println(multiply / b);
    }
}