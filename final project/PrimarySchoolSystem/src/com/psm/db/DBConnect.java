package com.psm.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;




    public class DBConnect {
        public static Connection con;
        public static PreparedStatement st;
        public static ResultSet res;
        //server info
        //schema name
        public static String DBname = "school_db";
        public static String url = "jdbc:mysql://localhost:3306/" + DBname;
        public static String username = "root";
        public static String password = "1234";

        public static Connection Connect(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,username,password);
            }catch(ClassNotFoundException | SQLException e){
            }
            return con;
        }
        public static void updateStatment(String s){
            try {
                st = con.prepareStatement(s);
                st.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        public static ResultSet resultStatment(String s){
            try {
                st = con.prepareStatement(s);
                res = st.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            return res;
        }
        public static void close(){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

