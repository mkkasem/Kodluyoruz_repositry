package com.psm.model.classes;

import com.psm.db.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int id;
    private String password;
    boolean loginStatus=false;
    protected String query;
    Scanner scan=new Scanner(System.in);

    public User() { }

    public User(int id, String password) {
        this.id = id;
        this.password = password;
        query="select * from user where uid="+id+";";
        ResultSet userInfo= DBConnect.resultStatment(query);
        try {
            DBConnect.res.next();
            setAttributes(userInfo.getInt(1),userInfo.getString(2),
                    userInfo.getString(3),userInfo.getString(4),
                    userInfo.getInt(5),userInfo.getString(6)
            );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //login into the database and if success set the attributes
    public void login(){
        System.out.println("please enter your Id");
        int id=scan.nextInt();
        System.out.println("please enter your password");
        String password=scan.next();

        query="select * from user where uid="+id+";";
        ResultSet userInfo=DBConnect.resultStatment(query);
        try {

            DBConnect.res.next();
            //check that existed Id in database is provided
            if (userInfo.getRow()==0){
                System.out.println("invalid id number");
                System.out.println("try again");
                login();
            }
            //get correct password from user when id is correct and keep ask him
            //to provide it correctly if it was entered wrongly
            else if (userInfo.getString("password").compareTo(password)!=0){
                System.out.println("Invalid password");

                while (userInfo.getString("password").compareTo(password)!=0){
                    System.out.println("please enter your password correctly");
                    password=scan.next();
                }
                setAttributes(userInfo.getInt(1),userInfo.getString(2),
                              userInfo.getString(3),userInfo.getString(4),
                              userInfo.getInt(5),userInfo.getString(6)
                             );
            }
            //validate information and set attributes
            else if (userInfo.getInt("uid")==id &&
                     userInfo.getString("password").equals(password))
            {
                System.out.println("successfully connected");
                System.out.println();
                setAttributes(userInfo.getInt(1),userInfo.getString(2),
                        userInfo.getString(3),userInfo.getString(4),
                        userInfo.getInt(5),userInfo.getString(6)
                );

            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setAttributes(int id,String pass,String fname,String lname,int age,String email) {
        setId(id);
        setPassword(pass);
        setFirstName(fname);
        setLastName(lname);
        setAge(age);
        setEmail(email);
        loginStatus=true;

    }

    @Override
    public String toString() {
        return "your info{" +"\n"+
                "firstName='" + firstName + '\'' +"\n"+
                "lastName='" + lastName + '\'' +"\n"+
                "email='" + email + '\'' +"\n"+
                "age=" + age +"\n"+
                "id=" + id +"\n"+
                "password='" + password + '\'' +"\n"+
                '}'+"\n"
                ;
    }

    //change user password after proving that he provided the old one and store in database
    public void changePassword(){
        System.out.println("enter your old password");
        String input=scan.next();
        String newPassword;
        if (input.compareTo(getPassword())!=0) {
            while (!input.equals(this.getPassword())){
                System.out.println("please enter your old password correctly");
                input=scan.next();
            }
        }
        if (input.equals(getPassword())) {
            System.out.println("enter your new password");
            newPassword = scan.next();

            query = "update school_db.user SET `password` =" + "'" +
                    newPassword + "'" + " WHERE (`uid` =" + "'" + this.getId() + "'" + ")" + " ;";
            this.setPassword(newPassword);
        }
        DBConnect.updateStatment(query);
        System.out.println("password successfully changed");
        System.out.println();

    }

    public void changeEmail(){
        System.out.println("enter your new email");
        String input=scan.next();
        query="update school_db.user SET `email` ="+"'"+
                input+"'"+" WHERE (`uid` ="+"'"+ this.getId()+"'"+")"+" ;";
        DBConnect.updateStatment(query);

        System.out.println("email successfully changed");
        this.setEmail(input);

    }
}
