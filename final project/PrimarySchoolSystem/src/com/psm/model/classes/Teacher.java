package com.psm.model.classes;

import com.psm.db.DBConnect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends User {
    private int teachingClass;
    private ArrayList students=new ArrayList<>();
    Scanner scan=new Scanner(System.in);
    String[] subjects= {"physics","math","history","english","turkish","music"};


    public Teacher(int id, String password)  {

        super(id, password);
        query="SELECT class FROM school_db.teacher where tid="+this.getId()+";";
        DBConnect.resultStatment(query);
        try {
            DBConnect.res.next();
            //get teaching class of the teacher from database
            setTeachingClass(DBConnect.res.getInt(1));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Teacher() {
    }

    public int getTeachingClass() {
        return teachingClass;
    }

    public void setTeachingClass(int teachingClass) {
        this.teachingClass = teachingClass;
    }
    //add grade of a student for specific subject
    public  void addGrade(){
        System.out.println("choose");
        for (int i = 0; i < subjects.length; i++)
            System.out.println(i+1+"- for "+subjects[i]);
        //get student info from the teacher
        System.out.println("enter the subject number");
        int subjectNumber=scan.nextInt();
        System.out.println("Students IDs");
        displayStudents();
        System.out.println("enter the student id");
        int studentId=scan.nextInt();
        System.out.println("enter student grade");
        double grade= scan.nextDouble();

        query="INSERT INTO `school_db`.`grade_table` (`sname`, `sclass`, `sid`, `grade`) VALUES" +
              " ('"+subjects[subjectNumber-1]+"',"+ "'"+teachingClass+"'"+","+ "'"+studentId+"'"+","+"'"+grade+"')"+";";
        DBConnect.updateStatment(query);


    }

    //display student list for the teacher class only
    private void displayStudents(){
        query="SELECT id FROM school_db.student where id like \'"+this.getTeachingClass()+"%\';";
        DBConnect.resultStatment(query);
        try {
            int i=1;
            while (DBConnect.res.next())
                System.out.println(i++ +"- "+DBConnect.res.getInt(1));

        } catch (SQLException throwables) {

        }
    }

    //update grade of a student for specific subject
    public void updateGrade(){
        System.out.println("updating grade\n");
        System.out.println("enter");
        for (int i = 0; i < subjects.length; i++)
            System.out.println(i+1+"- for "+subjects[i]);

        System.out.println("enter the subject number");
        int subjectNumber=scan.nextInt();
        displayStudents();
        System.out.println("enter the student id");
        int studentId=scan.nextInt();
        System.out.println("enter student new grade");
        double grade= scan.nextDouble();

        query="UPDATE `school_db`.`grade_table` SET" +
                " `grade` = '"+grade+"' WHERE (`sname` = '"+subjects[subjectNumber-1]+"') and" +
                " (`sid` = '"+studentId+"') and (`sclass` = '"+getTeachingClass()+"');";

        DBConnect.updateStatment(query);

    }
}
