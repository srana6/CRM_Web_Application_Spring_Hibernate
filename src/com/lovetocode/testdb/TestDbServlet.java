package com.lovetocode.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by macbook on 5/15/17.
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends javax.servlet.http.HttpServlet {
    /*protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }*/

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //setup connection variables
        String user= "admin";
        String pass= "chicagodowntown";

        String jdbcUrl= "jdbc:mysql://cms.c4jeud2dq2jh.us-west-2.rds.amazonaws.com/content_management_system_dev?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";

        //get connection to database
        try{
            PrintWriter out = response.getWriter();
            out.println("Connecting:"+jdbcUrl);

            Class.forName(driver);
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);

            out.println("Success");

            myConn.close();

        }catch(Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
