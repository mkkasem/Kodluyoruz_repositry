package com.psm.model.classes;

import com.psm.db.DBConnect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User {
    String[] subjects= {"physics","math","history","english","turkish","music"};
    Scanner scan=new Scanner(System.in);
    public Student(){}

    public Student(int id, String password) {
        super(id, password);
    }
    //display grade of selected subject by the student
    public void viewSubjectGrade(){
        System.out.println();
        System.out.println("choose");
        for (int i = 0; i < subjects.length; i++)
            System.out.println(i+1+"- for "+subjects[i]);

        System.out.println("enter the subject number");
        int subjectNumber=scan.nextInt();

        query="select grade from school_db.grade_table where sid="+this.getId()+" and sname=\""+
                subjects[subjectNumber-1]+"\"";
        try {
            DBConnect.resultStatment(query);
            DBConnect.res.next();

            System.out.println("your "+ subjects[subjectNumber-1]+" score is : "+DBConnect.res.getInt(1));
            System.out.println();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //display student transcript and letter grade
    public void viewTranscript()  {
        double average=0;

        System.out.println();
        query="SELECT subject.sname,hours,grade FROM school_db.grade_table inner join  school_db.subject on" +
                " subject.sname=grade_table.sname " +
                "where sid="+this.getId()+";";

        try {
            DBConnect.resultStatment(query);
            System.out.println("your Transcript\n");
            System.out.println(String.format("%10s\t\t%5s\t\t%5s","Subject","Hours","Grade"));
            System.out.println("----------------------------------");
            while (DBConnect.res.next()){
                String subName=DBConnect.res.getString(1);
                int hours=DBConnect.res.getInt(2);
                double grade=DBConnect.res.getDouble(3);
                System.out.println(String.format("%10s\t\t%3s  \t\t%.2f",subName, hours, grade));
                average+=(hours*(grade));
            }
            System.out.println("----------------------------------");
            System.out.println(String.format("%10s\t\t%5s\t\t%.2f","average"," ",average/20));
            displayLetterGrade(average/20);
            System.out.println();
            System.out.println();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            }


    }

    void displayLetterGrade(double avg){
        String letter;
        if (avg>=90)
            letter="A";
        else if (avg>=85)
            letter="B1";
        else if (avg>=80)
            letter="B2";
        else if (avg>=75)
            letter="B3";
        else if (avg>=70)
            letter="C1";
        else if (avg>=65)
            letter="C2";
        else if (avg>=60)
            letter="C3";
        else
            letter="F";
        System.out.printf("%15s %15s  ","Letter grade",letter);
    }
}
