package com.psm.model.classes;

import com.psm.db.DBConnect;

import java.util.Scanner;

public class DriverClass {
    static User user =new User();
    Student student;
    Teacher teacher;
    Manager manager;
    Scanner scan=new Scanner(System.in);

    public  void start() {
        int userChoice=-1;
        DriverClass driverClass=new DriverClass();
        //connect to database
        DBConnect.Connect();

        user.login();
        //get user type from the first number in the Id and create correct object upon that number
        int userType=Integer.valueOf(Character.toString(String.valueOf(driverClass.user.getId()).charAt(0)));

        if (userType<7)
           new DriverClass().studentInterface(userChoice);
        else if (userType==7)
            new DriverClass().teacherInterface(userChoice);
        else if (userType==8)
            new DriverClass().managerInterface(userChoice);

        //close connection
        DBConnect.close();

    }

    private void studentInterface(int userChoice){
        student = new Student(user.getId(), user.getPassword());
        System.out.println("Hello  student "+student.getFirstName()+" "+student.getLastName());
        System.out.println("please choose what you want to do");
        System.out.println();

        while (userChoice!=0){
            System.out.println("press 0 to exit\n" +
                    "press 1 for change password\n"+
                    "press 2 for update email address\n"+
                    "press 3 for view grade of specific subject\n"+
                    "press 4 for view your transcript\n"+
                    "press 5 for view your personal info\n"
            );
            userChoice=scan.nextInt();

            switch (userChoice){
                case 1:
                    student.changePassword();
                    break;
                case 2:
                    student.changeEmail();
                    break;
                case 3:
                    student.viewSubjectGrade();
                    break;
                case 4:
                    student.viewTranscript();
                    break;
                case 5:
                    System.out.println(student);
                    break;
            }
        }

    }
    private void teacherInterface(int userChoice){
        teacher = new Teacher(user.getId(), user.getPassword());
        System.out.println("Hello  teacher "+teacher.getFirstName()+" "+teacher.getLastName());
        System.out.println("please choose what you want to do");
        System.out.println();

        while (userChoice!=0){
            System.out.println("press 0 to exit\n" +
                    "press 1 for change password\n"+
                    "press 2 for update email address\n"+
                    "press 3 for add grade for a student\n"+
                    "press 4 for update grade for a student\n"+
                    "press 5 for view your personal info\n"
            );
            userChoice=scan.nextInt();

            switch (userChoice){
                case 1:
                    teacher.changePassword();
                    break;
                case 2:
                    teacher.changeEmail();
                    break;
                case 3:
                    teacher.addGrade();
                    break;
                case 4:
                    teacher.updateGrade();
                    break;
                case 5:
                    System.out.println(teacher);
                    break;
            }
        }
    }
    private void managerInterface(int userChoice){
        manager = new Manager(user.getId(), user.getPassword());
        System.out.println("Hello  manager "+manager.getFirstName()+" "+manager.getLastName());
        System.out.println("please choose what you want to do");
        System.out.println();

        while (userChoice!=0){
            System.out.println("press 0 to exit\n" +
                    "press 1 for change password\n"+
                    "press 2 for update email address\n"+
                    "press 3 for add teacher\n"+
                    "press 4 for delete teacher\n"+
                    "press 5 for add student\n"+
                    "press 6 for delete student\n"+
                    "press 7 for view your personal info\n"
            );
            userChoice=scan.nextInt();

            switch (userChoice){
                case 1:
                    manager.changePassword();
                    break;
                case 2:
                    manager.changeEmail();
                    break;
                case 3:
                    manager.addTeacher();
                    break;
                case 4:
                    manager.deleteTeacher();
                    break;
                case 5:
                    manager.addStudent();
                    break;
                case 6:
                    manager.deleteStudent();
                    break;
                case 7:
                    System.out.println(manager);
                    break;
            }
        }
    }
}
