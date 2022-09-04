import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userID = scan.nextLine();
        String checkID = new String(userID);

        if (checkID.equals(userID)) {
            System.out.println(userID + "??!");
        }
    }
}