
public abstract class AirplaneReservationSystem {
    private int numberOfSeats;
    protected boolean[] seats;

    public AirplaneReservationSystem() {
        int numberOfSeats=10;
        seats=new boolean[numberOfSeats];
        for (int i = 0; i < numberOfSeats; i++)
              seats[i]=true;
    }

    //make sure that seats at least 10
    public AirplaneReservationSystem(int numberOfSeats) {

        if(numberOfSeats<10){
            System.out.println("Koultuk sayısı hatalı. Otomatık 10 yaplıdı ");
            this.numberOfSeats=10;
        }else
            this.numberOfSeats = numberOfSeats;

        seats=new boolean[this.numberOfSeats];
        for (int i = 0; i < this.numberOfSeats; i++)
            seats[i]=true;
    }
    //adjust seats size during run time if necessary
    public void setNumberOfSeats(int numberOfSeats){
        boolean[] temp=new boolean[this.numberOfSeats];

            for (int i = 0; i < temp.length; i++)
                temp[i] = this.seats[i];

        seats=null;
        this.seats=new boolean[numberOfSeats];

        if (numberOfSeats<this.numberOfSeats){
            for (int i = 0; i < numberOfSeats; i++)
                    this.seats[i] = temp[i];
        }
        else
            for (int i = 0; i < this.numberOfSeats; i++)
                this.seats[i] = temp[i];


        if (numberOfSeats>this.numberOfSeats)
           for (int i = this.numberOfSeats; i < numberOfSeats; i++) {
                this.seats[i] = true;
            }
        this.numberOfSeats=numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isEconomicFull(){
        for (int i = 5; i < seats.length; i++) {
            if(seats[i])
                return false;
        }
        return true;
    }

    public boolean isBusinessFull(){
        for (int i = 0; i < 5; i++) {
            if(seats[i])
                return false;
        }
        return true;
    }

    public boolean isAirplaneFull(){
        for (int i = 0; i < seats.length; i++) {
            if(seats[i])
            return false;
        }
        return true;
    }

    public abstract void makeReservation();

}
