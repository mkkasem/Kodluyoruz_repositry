import java.util.Scanner;

public class Calculater {

    public static void main(String[] args) {
        int n1,n2;
        Scanner scan=new Scanner(System.in);
        System.out.println("Please enter the first number");
        n1=scan.nextInt();
        System.out.println("Please enter the second number");
        n2=scan.nextInt();
        System.out.println("please choose the operation\n" +
                "1 for +\n"+
                "2 for - \n"+
                "3 for / \n"+
                "4 for x \n");
        int choice =scan.nextInt();
        switch(choice){
            case 1:
                System.out.println(n1+" + "+n2+" = "+ (n1+n2));
                break;
            case 2:
                System.out.println(n1+" - "+n2+" = " + (n1-n2));
                break;
            case 3:
                if (n2==0)
                   System.out.println("you can't divide by zero");
                else 
                   System.out.println(n1+" / "+n2+" = " + (n1/n2));
                break;
            case 4:
                System.out.println(n1+" x "+n2+" = " + (n1*n2));
                break;
            default:
                System.out.println("you haven't provided valid choice ");
                break;                      
        }
  
       

    }

}

