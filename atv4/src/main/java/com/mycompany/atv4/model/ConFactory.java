package com.mycompany.atv4.model;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

public class ConFactory {
    public static final int MYSQL = 0; 
    public static final int JavaDB = 1;  
  
   public static Connection conexao(String nome, String senha,  
         int banco) throws ClassNotFoundException, SQLException {  
      switch (banco) {        
      case MYSQL:           
         Class.forName("org.gjt.mm.mysql.Driver"); 
         return DriverManager.getConnection("jdbc:mysql://localhost:3306/igordb?zeroDateTimeBehavior=convertToNull", nome, senha);
      case JavaDB:
          Class.forName("org.apache.derby.jdbc.ClientDriver"); 
          return DriverManager.getConnection("jdbc:derby://localhost:1527/igordb", "root", "root");
      }  
      return null;
   }  
}