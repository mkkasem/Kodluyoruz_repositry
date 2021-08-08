import java.util.Scanner;

public class Manav {

    public static void main(String[] args) {
        int temp;
        double toplam=0;
        double [] prices={2.14,3.67,1.11,0.95,5.00};
        String [] names= {"Armut","Elma","Domates","Muz","Patlıcan"};
        Scanner in=new Scanner(System.in);

        for(int i=0;i<5;i++) {
            System.out.print(names[i] + " Kaç Kilo ? :");
            temp = in.nextInt();
            toplam += temp * prices[i];
        }
        System.out.println("Toplam Tutar : "+toplam +" TL");

    }
}
