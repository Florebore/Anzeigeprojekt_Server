/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Florian
 */
public class Database_Controller {
    
 
    public Database_Controller(){
        
        
    }
    
//methods have been written static so far, because they can be accessed without the instance of an object     
// connects to Database
    
public static Connection Connect_to_Database(String localhost,String user, String password) throws SQLException{

    Connection con = null;
    
    try   {con = DriverManager.getConnection("jdbc:mysql://localhost:"+ localhost + 
        "/Database_Anzeige?verifyServerCertificate=false&useSSL=false", user , password);
		System.out.println("Connection successful!");
                
}

catch (Exception e){e.printStackTrace();}
    
return con;}


//general code for an SQLquery. Takes an SQL statement as input 

public static ResultSet sqlquery(String query) throws SQLException {
    
Connection con = Connect_to_Database("3306", "root", "30Bore300");   
    
ResultSet rs_SQL = null;

try {   Statement stmt;
        stmt = con.createStatement();
        rs_SQL = stmt.executeQuery(query);
                              }

catch (SQLException e) {}

if(rs_SQL == null){con.close();

System.out.println("Connection closed!");}

return rs_SQL;  
}

//returns the result of an sql query 

public String getusernamefromdatabase(String User) throws SQLException{
  
    
   // first connection object is created through Connect_to_Database - Method from Database_Controller
   //Connection con = Connect_to_Database("3306", "root", "30Bore300");   
    String usernamerueckgabe = null;
    ResultSet SQLergebnis;
    boolean isEmpty;
    
    
    SQLergebnis = sqlquery("SELECT Username FROM Database_Anzeige.UserDB WHERE Username = '"+User+"'" );
    
    
    //checks if the Resultset contains rows or not, if it doesn't Ausgabe will return null to next function
            
   if (SQLergebnis.first()){
            isEmpty = false;}
   
   else {isEmpty = true;}
   
   System.out.println("'"+isEmpty+"'");
   
 //  SQLergebnis.previous();
    
    // String elemets need a backslash before every quotation mark otherwise query does not work
    //query = "SELECT Username, Ident FROM Database_Anzeige.UserDB WHere Username = \"f.boettinger\"";

    if(isEmpty == false)   { 
    
    //ResultSet getString()-Method gets colums from the query and translates them to Strings
    try {
                
                usernamerueckgabe = (SQLergebnis.getString(1));
              System.out.println(usernamerueckgabe +"usernamerück");
                
            }
       
       
       
    
    
        
        //else { System.out.println("User exisitiert nicht!");}}
            
            catch (Exception e) {e.printStackTrace();}}
    
   
          else {usernamerueckgabe = "0";
             System.out.println("SQLResultset ist leer!");                   }
       
return usernamerueckgabe;}


public String getpasswordfromdatabase (String User) throws SQLException{
  
    
   // first connection object is created through Connect_to_Database - Method from Database_Controller
   //Connection con = Connect_to_Database("3306", "root", "30Bore300");   
    String passwortrueckgabe = null;
    ResultSet SQLergebnis;
    boolean isEmpty;
    
    
    SQLergebnis = sqlquery("SELECT Ident FROM Database_Anzeige.UserDB WHERE Username = '"+User+"'" );
    
    
    //checks if the Resultset contains rows or not, if it doesn't Ausgabe will return null to next function
            
   if (SQLergebnis.first()){
            isEmpty = false;}
   
   else {isEmpty = true;}
   
   System.out.println("'"+isEmpty+"'");
   
   //SQLergebnis.previous();
    
    // String elemets need a backslash before every quotation mark otherwise query does not work
    //query = "SELECT Username, Ident FROM Database_Anzeige.UserDB WHere Username = \"f.boettinger\"";

    if(isEmpty == false)   { 
    
    //ResultSet getString()-Method gets colums from the query and translates them to Strings
    try {
                
                passwortrueckgabe = (SQLergebnis.getString(1));
                System.out.println(passwortrueckgabe);
                
            }
       
       
       
    
    
        
        //else { System.out.println("User exisitiert nicht!");}}
            
            catch (Exception e) {e.printStackTrace();}}
    
   
          else {passwortrueckgabe = "0";
             System.out.println("SQLResultset ist leer!");                   }
       
return passwortrueckgabe;}

public String getrollefromdatabase (String User) throws SQLException{

    
   // first connection object is created through Connect_to_Database - Method from Database_Controller
   //Connection con = Connect_to_Database("3306", "root", "30Bore300");   
    String rollerueckgabe = null;
    ResultSet SQLergebnis;
    boolean isEmpty;
    
    
    SQLergebnis = sqlquery("SELECT Rolle FROM Database_Anzeige.UserDB WHERE Username = '"+User+"'" );
    
    
    //checks if the Resultset contains rows or not, if it doesn't Ausgabe will return null to next function
            
   if (SQLergebnis.first()){
            isEmpty = false;}
   
   else {isEmpty = true;}
   
   System.out.println("'"+isEmpty+"'");
   
   SQLergebnis.previous();
    
    // String elements need a backslash before every quotation mark otherwise query does not work
    //query = "SELECT Username, Ident FROM Database_Anzeige.UserDB WHere Username = \"f.boettinger\"";

    if(isEmpty == false)   { 
    
    //ResultSet getString()-Method gets colums from the query and translates them to Strings
    try {
                
                rollerueckgabe = (SQLergebnis.getString(1));
              
                
            }
       
       
       
    
    
        
        //else { System.out.println("User exisitiert nicht!");}}
            
            catch (Exception e) {e.printStackTrace();}}
    
   
          else {rollerueckgabe = null;
             System.out.println("SQLResultset ist leer!");                   }
       
return rollerueckgabe;}

public void closeconnection(Connection c) throws SQLException {
    
    c.close();

}


}