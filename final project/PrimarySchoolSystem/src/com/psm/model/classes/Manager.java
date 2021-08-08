package com.psm.model.classes;

import com.psm.db.DBConnect;

import java.sql.SQLException;
/*
com.psm.db.model.main.Manager id start with 8
 */
public class Manager extends User {


    public Manager(int id, String password) {
        super(id, password);
    }
    //add student to the database by the manager
    public void addStudent(){
        Student student=new Student();
        String maxId;
        int grade;
        System.out.println("adding new student");
        System.out.println("enter student class");
        grade=scan.nextInt();
        String defaultPassword="1234";
        try {
            DBConnect.resultStatment("select max(uid) from user where uid like '"+grade+"%"+"'");
            DBConnect.res.next();

            int i=DBConnect.res.getInt(1);
            //generate suitable id for a student depending on his class
            if (i==0 || i<10)
                i=grade*10;

            if (grade%9==0)
                maxId=String.valueOf(grade*10+1);
            else
                maxId=String.valueOf(i+1);

            //ask manager to provide student info
            student.setId(Integer.valueOf(maxId));
            student.setPassword(defaultPassword);
            System.out.print("enter student first name:   ");
            student.setFirstName(scan.next());
            System.out.print("enter student last name:   ");
            student.setLastName(scan.next());
            System.out.print("enter student age :   ");
            student.setAge(scan.nextInt());
            System.out.print("enter student email   :");
            student.setEmail(scan.next());
            System.out.println(student);

            query= "INSERT INTO `school_db`.`user` (`uid`, `password`, `fname`, `lname`, `age`, `email`) VALUES" +
                    "('"+student.getId()+"'"+","+ "'"+student.getPassword()+"'"+","+ "'"+student.getFirstName()+"'"+
                    ","+"'"+student.getLastName()+"'"+","+"'"+student.getAge()+"'"+","+"'"+student.getEmail()+"')";

            DBConnect.updateStatment(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    //delete student from the database by the manager

    public void deleteStudent(){
        //show student lists
        displayStudents();
        System.out.println("Enter student Id that you want to delete");
        int id =scan.nextInt();

        query="delete from school_db.user where uid="+id;
        DBConnect.updateStatment(query);
        System.out.println("teacher with id "+id+" was deleted successfully");
    }

    //add teacher to the database by the manager
    //teacher id start with 7
    public void addTeacher(){
        Teacher teacher=new Teacher();
        int maxId;
        int teachingClass;
        System.out.println("adding new teacher");
        System.out.println("enter teaching  class");
        teachingClass=scan.nextInt();
        String defaultPassword="1234";
        try {
            DBConnect.resultStatment("select max(uid) from user where uid like '7%'");
            DBConnect.res.next();
            maxId=DBConnect.res.getInt(1);
            //make sure that there is teacher in database if not generate the first if for a teacher
            if (maxId==0)
                 maxId=70;
            //ask manager to provide teacher info
            teacher.setTeachingClass(teachingClass);
            teacher.setId(maxId+1);
            teacher.setPassword(defaultPassword);
            System.out.print("enter teacher first name:   ");
            teacher.setFirstName(scan.next());
            System.out.print("enter teacher last name:   ");
            teacher.setLastName(scan.next());
            System.out.print("enter teacher age :   ");
            teacher.setAge(scan.nextInt());
            System.out.print("enter teacher email   :");
            teacher.setEmail(scan.next());
            System.out.println(teacher);

            query= "INSERT INTO `school_db`.`user` (`uid`, `password`, `fname`, `lname`, `age`, `email`) VALUES" +
                    "('"+teacher.getId()+"'"+","+ "'"+teacher.getPassword()+"'"+","+ "'"+teacher.getFirstName()+"'"+
                    ","+"'"+teacher.getLastName()+"'"+","+"'"+teacher.getAge()+"'"+","+"'"+teacher.getEmail()+"')";

            DBConnect.updateStatment(query);
            System.out.println("UPDATE `school_db`.`teacher` SET `class` = '"+teachingClass+"'"+" WHERE (`tid` = '"+
                    teacher.getId()+"'"+")");
            DBConnect.updateStatment("UPDATE `school_db`.`teacher` SET `class` = '"+teachingClass+"'"+" WHERE (`tid` = '"+
                    teacher.getId()+"'"+")");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    //delete teacher from the database by the manager
    public void deleteTeacher(){
        displayTeachers();
        System.out.println("Enter teacher Id that you want to delete");
        int id =scan.nextInt();
        query="delete from school_db.user where uid="+id;
        DBConnect.updateStatment(query);
        System.out.println("teacher with id "+id+" was deleted successfully");

    }
    //display all students from database
    private void displayStudents(){
        query="SELECT id FROM school_db.student;";
        DBConnect.resultStatment(query);
        try {
            int i=1;
            while (DBConnect.res.next())
                System.out.println(i++ +"- "+DBConnect.res.getInt(1));

        } catch (SQLException throwables) {

        }
    }

    //display all teachers from database
    private void displayTeachers(){
        query="SELECT tid FROM school_db.teacher;";
        DBConnect.resultStatment(query);
        try {
            int i=1;
            while (DBConnect.res.next())
                System.out.println(i++ +"- "+DBConnect.res.getInt(1));

        } catch (SQLException throwables) {

        }

    }
}
