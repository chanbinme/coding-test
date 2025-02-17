import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        int num = 666;
        int count = 1;

        while(count != N){
            num++;
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }

        System.out.println(num);
    }
}
