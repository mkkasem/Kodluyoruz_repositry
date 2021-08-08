import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        int F0=0,F1=1;
        int number;
        int result ;
        Scanner in = new Scanner(System.in);
        System.out.println("lütfen istediğiniz fibonacci terimini kadar giriniz?");
        number=in.nextInt();

        if(number==0)
            System.out.println(F0);
            else {
                System.out.print(F0+", ");
                System.out.print(F1+", ");
                for(int i=2;i<=number;i++){
                   result=F0+F1;
                   F0=F1;
                   F1=result;
                   System.out.print(result+", ");

                }
            }
    }
}
