import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class StationaryStore {
    private static  int totalNumberBought=0;
    private static HashMap  <String,Integer> items = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("please enter what item(s) you want and how many of each?");
        getOrders(scan);
        Iterator iterator= items.entrySet().iterator();
        printReceipt(iterator);


    }
    //print customer receipt and total number of copies as a table
    public static void printReceipt(Iterator iterator){
        System.out.printf("%-15s %-10s\n","item name","number");
        while (iterator.hasNext()){
            Map.Entry item=(Map.Entry) iterator.next();
            System.out.printf("%-15s %d\n",item.getKey(),item.getValue());
        }
        System.out.println("-------------------------");
        System.out.printf("%-15s %d\n","Total number",totalNumberBought);
    }

    /*function that take user's order and count the number of copies of each item and count the total number of
    / all copies of all items bought*/
    //note if you want more copies of previously selected item you can add as if it's new icon
    public static void getOrders(Scanner scan){
        Integer currentItemNumber;
        while(true){
            currentItemNumber=0;
            System.out.println("enter end if you wish to exit at any point");
            System.out.println("item name \t numberOfItems:");
            String itemName=scan.next();
            //when user enter "end" finish exit
            if(itemName.equals("end"))
                break;
            Integer addedToitemCount =scan.nextInt();
            if (items.get(itemName)!=null)
                currentItemNumber= items.get(itemName);
            
            items.put(itemName,currentItemNumber+ addedToitemCount);
            totalNumberBought += addedToitemCount.intValue();

        }

    }


}
