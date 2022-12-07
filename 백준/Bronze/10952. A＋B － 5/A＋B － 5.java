import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        while (true) {
                Integer a = sc.nextInt();
                Integer b = sc.nextInt();

                if (a == 0) break;
                
                System.out.println(a + b);
        }
    }
}
