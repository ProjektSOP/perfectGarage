package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mySQLConnector.MySQLConnection;
import objects.Nutzer;

public class DAO_Alle_Nutzer {
	
public ArrayList<Nutzer> returnAllNutzer()  {
	
		ArrayList<Nutzer> nutzerliste = new ArrayList<Nutzer>();
		Connection conn = null;
					     
		conn = MySQLConnection.getInstance();
		 
	    if(conn != null)
	    {
	    	
	      // Anfrage-Statement erzeugen.
	      Statement query;
	      try {
	        query = conn.createStatement();
	 
	        // Ergebnistabelle erzeugen und abholen.
	        String sql = "SELECT benutzername, passwort, name, vorname, nutzerrolle FROM t_nutzer";
	        ResultSet result = query.executeQuery(sql);
	 
	        // Ergebniss�tze durchfahren.
	        int i = 0;
	        
	        while (result.next()) {
	        
	          String benutzername = result.getString("benutzername"); 
	          String passwort = result.getString("passwort"); 
	          String nachname = result.getString("Name"); // 
	          String vorname = result.getString("Vorname"); 
	          String nutzerrolle = result.getString("Nutzerrolle");
	          	          	         
	          Nutzer tempnutzer = new Nutzer(benutzername, passwort, nachname, vorname, nutzerrolle);
	          
	          nutzerliste.add(tempnutzer);
	         	                    
	        }
	       	   
	        
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    
	    for(Nutzer n : nutzerliste){
       	 System.out.println(n.getVorname() + " "+ n.getNachname() +"\n" );
        }
	    
	    return nutzerliste;
	  }

	

}