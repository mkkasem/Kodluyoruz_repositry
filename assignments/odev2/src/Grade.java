import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {

        double midtermExam, finalExam;
        System.out.println("Enter your midterm exam grade");
        Scanner scan=new Scanner(System.in);
        midtermExam=scan.nextDouble();
        System.out.println("Enter your final exam grade");
        finalExam=scan.nextDouble();
        Grade grade=new Grade();
        int average=grade.calculateGrade(midtermExam,finalExam);
        grade.printResult(average);


    }
    //print the average  and the letter grade
    public void printResult(int average){
        try {
            if(average>=0 &&average<20)
                System.out.println("your average is: "+average+" letter grade: FF");
            else if(average>=20 && average<50)
                System.out.println("your average is: "+average+" letter grade: CB");
            else if(average>=50 && average<70)
                System.out.println("your average is: "+average+" letter grade: BB");
            else if(average>=70 && average<=100)
                System.out.println("your average is: "+average+" letter grade: AA");
            else {
                throw new Exception("please provide grade 0-100");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    //calculate average based on midterm and final grades
    public int calculateGrade(double midtermExam,double finalExam){
         return (int) Math.round(.4*midtermExam + .6*finalExam);
    }

}
