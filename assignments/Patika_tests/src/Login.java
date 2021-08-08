import java.util.Scanner;

public class Login {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String userName, password;
        byte choice;
        System.out.println("please enter your username");
        userName = scan.next();
        System.out.println("please enter your password");

        password = scan.next();
        if (userName.equals("patika")) {
            if (password.equals("java123"))
                System.out.println("you logged in successfully");
            else {
                System.out.println("your password is wrong");
                System.out.println("press 1 if you want to reset your password");
                choice = scan.nextByte();
                if (choice == 1)
                    changePassword(password);

            }
        } else
            System.out.println("your user name is wrong ");


    }

    public static void changePassword(String password) {
        String newPassword;

        System.out.println("enter your new password");
        newPassword = scan.next();
        if (newPassword.equals("java123"))
            System.out.println("you can't set new password as the old one");
        else
            System.out.println("your password was changed successfully");





    }
}