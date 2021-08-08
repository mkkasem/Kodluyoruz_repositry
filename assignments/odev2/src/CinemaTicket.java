import java.util.Scanner;

public class CinemaTicket {
    //generate random number 50-100 as ticket price
    private int ticketPrice=(int)((Math.random()*51)+50);


    public static void main(String[] args) {
    CinemaTicket cinemaTicket  =  new CinemaTicket();
        System.out.println("original ticket price  "+cinemaTicket.ticketPrice);
    cinemaTicket.sellTicket();
        System.out.println("price of your ticket is  "+cinemaTicket.ticketPrice);
    }

    //sell the ticket and apply specified discounts stated in the class
    public void sellTicket(){
        Scanner scan=new Scanner(System.in);
        byte genre;
        int age;
        System.out.println("please enter your age");
        age=scan.nextInt();
        System.out.println("please choose the number of the genre of the movie\n" +
                "1\tComedy\n"+
                "2\tAction\n"+
                "3\tRomance\n"+
                "4\tHorror"
        );
        genre=scan.nextByte();
        if(genre==4)
            ticketPrice*=0.9;

        if (age<18)
            ticketPrice*=0.9;
        else if( age>=18 && age<=25 )
            ticketPrice*=0.95;


    }
}
