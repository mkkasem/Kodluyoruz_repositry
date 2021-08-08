import java.util.Scanner;
/*I first implemented THY reservation system and then instead of duplicating the code I simply create an
object of THY reservation system class and used it in a hidden way as Pegasus reservation system since they both
display the same behaviour
*/

public class PegasusReservationSystem extends AirplaneReservationSystem{
    private  static THYReservationSystem thyasusReservationSystem;

    public PegasusReservationSystem() {
        super();
        thyasusReservationSystem=new THYReservationSystem();
    }

    public PegasusReservationSystem(int numberOfSeats) {
        super(numberOfSeats);
        thyasusReservationSystem=new THYReservationSystem(numberOfSeats);
    }

    @Override
    public void makeReservation() {

        this.thyasusReservationSystem.makeReservation();
    }

    public static void main(String[] args) {
        PegasusReservationSystem pegasusReservationSystem=new PegasusReservationSystem(10);
        boolean toContinue;


        //choose after how many loops you want to change size of seats
       //int afterNLoops=1;//
        //int changeNumberOfSeats=30;

        //take the client booking requests
        while (true){
        /*uncomment the ıf statement block and the variables  above to change number of seats
         and choose any number you want*/
             //if(afterNLoops--==0)
                //PegasusReservationSystem.thyasusReservationSystem.setNumberOfSeats(changeNumberOfSeats);

            System.out.println("Pegasus Rezervasyon Sistemine hoş geldiniz! ");

            pegasusReservationSystem.makeReservation();

            System.out.println("Devam etmek için c'ye, çıkmak için herhangi başka bir tuşa basınız ");
            toContinue=new Scanner(System.in).next().equals("c")?true:false;
            if(!toContinue)
                break;

            System.out.println();

        }
    }

}
