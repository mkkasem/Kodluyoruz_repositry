import java.util.Scanner;

public class THYReservationSystem extends AirplaneReservationSystem{

    public THYReservationSystem() {
        super();
    }

    public THYReservationSystem(int numberOfSeats) {
        super(numberOfSeats);
    }

    //print available of current chosen type of class
    private  void displaySeats(int lower,int upper){

        for (int i = lower; i < upper; i++)
            System.out.print(this.seats[i]==true? i+1+" ":"");
        System.out.println();
    }

    //check that there is available seats and take client order
    @Override
    public void makeReservation() {
        Scanner scan=new Scanner(System.in);
        int choice;

            if (isAirplaneFull()) {
                System.out.println("Maalesef uçak dolu, rezervasyon alamıyoruz! ");
                System.out.println();
            }
            else{
                System.out.println("Business class uçmak için 0'a basınız, ekonomi class uçmak için 1'e basınız: ");
                choice=scan.nextInt();

                if (choice==0)
                    Ticket("business");

                else if (choice==1)
                    Ticket("economic");
            }

    }

    //apply proper commands depends on type of flight
    private void Ticket(String company){
        int lower,upper,chosenSeat;

        if(company.compareTo("business")==0){
            lower=0;
            upper=5;
        }
        else{
            lower=5;
            upper=getNumberOfSeats();
        }

        if (company.compareTo("business")==0){
            if (isBusinessFull())
                System.out.println("Maalesef business koltuklarımız dolu! Rezervasyon alamıyoruz! ");
            else{
                System.out.println("Aşağıdaki bos koltuklardan birini seçiniz: ");
                displaySeats(lower,upper);
                chosenSeat=new Scanner(System.in).nextInt();
                checkValidSeat(chosenSeat-1,lower,upper,"business");
            }
        }
        else if (company.compareTo("economic")==0){
            if (isEconomicFull())
                System.out.println("Maalesef ekonomic koltuklarımız dolu! Rezervasyon alamıyoruz! ");
            else{
                System.out.println("Aşağıdaki bos koltuklardan birini seçiniz: ");
                displaySeats(lower,upper);
                chosenSeat=new Scanner(System.in).nextInt();
                checkValidSeat(chosenSeat-1,lower,upper,"economic");
            }

        }


    }

    //make sure that chosen seat is available and not out of bound of chosen type
    private void checkValidSeat(int chosenSeat,int lower,int upper,String type){

        if (chosenSeat>=lower && chosenSeat<upper){

            if (seats[chosenSeat]){
                seats[chosenSeat]=false;
                System.out.println("Koltuk no: "+(chosenSeat+1)+" adınıza rezerve edildi!");
                System.out.println("İyi uçuşlar! ");
                System.out.println();

            }
            else{ System.out.println("seçilen koltuk zaten dolu! tekrar girin:");
                chosenSeat=new Scanner(System.in).nextInt();
                checkValidSeat(chosenSeat-1,lower,upper,type);
            }
        }

        else{
            System.out.println("geçersiz girdin "+ ""+ type+" koltuk! tekrar girin:");
            chosenSeat=new Scanner(System.in).nextInt();
            checkValidSeat(chosenSeat-1,lower,upper,type);
        }


    }

    public static void main(String[] args) {
        THYReservationSystem thyReservationSystem=new THYReservationSystem(15);
        boolean toContinue;

        //choose after how many loops you want to change size of seats
        //int afterNLoops=1;//
        //int changeNumberOfSeats=30;

        //take the client booking requests
        while (true){
        /*uncomment the ıf statement block and the variables  above to change number of seats
         and choose any number you want*/

            //  if(afterNLoops--==0)
                 //thyReservationSystem.setNumberOfSeats(changeNumberOfSeats);

            System.out.println("THY Rezervasyon Sistemine hoş geldiniz! ");

            thyReservationSystem.makeReservation();

            System.out.println("Devam etmek için c'ye, çıkmak için herhangi başka bir tuşa basınız ");
            toContinue=new Scanner(System.in).next().equals("c")?true:false;
            if(!toContinue)
                break;
            System.out.println();

        }

    }
}
