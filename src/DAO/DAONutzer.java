package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mySQLConnector.MySQLConnection;
import objects.Kunde;
import objects.Nutzer;


public class DAONutzer {
	
	final String returnAllNutzerString = "SELECT * FROM t_nutzer";
	final String updateoldNutzer = "UPDATE t_nutzer SET benutzername=?, passwort=?, Name=?, Vorname=?, Nutzerrolle=?, Status=? WHERE benutzername=? ";
	
	
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
	        String sql = returnAllNutzerString;
	        ResultSet result = query.executeQuery(sql);
	 
	        // Ergebnissätze durchfahren.
	        while (result.next()) {
	        
	          String benutzername = result.getString("benutzername"); 
	          String passwort = result.getString("passwort"); 
	          String nachname = result.getString("Name"); // 
	          String vorname = result.getString("Vorname"); 
	          String nutzerrolle = result.getString("Nutzerrolle");
	          String status = result.getString("Status");
	          	          	         
	          Nutzer tempnutzer = new Nutzer(benutzername, passwort, nachname, vorname, nutzerrolle, status);
	        
	          nutzerliste.add(tempnutzer);
	        }
	            
	        
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }	    
	    return nutzerliste;
	  }

public ArrayList<Nutzer> returnAllNutzerWithoutAdmin()  {
	
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
        String sql = "SELECT * FROM t_nutzer";
        ResultSet result = query.executeQuery(sql);
 
        // Ergebnissätze durchfahren.
        int i = 0;
        
        while (result.next()) {
        	
        	
        	if(!(result.getString("benutzername").equals("Administrator"))){
        	
	          String benutzername = result.getString("benutzername"); 
	          String passwort = result.getString("passwort"); 
	          String nachname = result.getString("Name"); // 
	          String vorname = result.getString("Vorname"); 
	          String nutzerrolle = result.getString("Nutzerrolle");
	          String status = result.getString("Status");
	          	          	         
	          Nutzer tempnutzer = new Nutzer(benutzername, passwort, nachname, vorname, nutzerrolle, status);
	          
	          nutzerliste.add(tempnutzer);
         	                    
        	}
          
        }
        
        //TEST AUSGABE
        /**
        for (Nutzer n : nutzerliste)
        System.out.println(n.getVorname() + " " + n.getNachname());
       	*/
        
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }	    
    return nutzerliste;
  }



public boolean updateNutzer(Nutzer oldNutzer, String oldname)  {
	
	/**
	 *	@param Übernimmt einen Nutzer - Objekt und updates dieses in der Datenbank
	 *	@param gibt ein boolean zurück, ob das Update erfolgreich war
	*/
	
	boolean ready = false;
	
	Nutzer tempnutzer = oldNutzer;
		
	Connection conn = MySQLConnection.getInstance();
	 
    if(conn != null)
    {
    	
      // Anfrage-Statement erzeugen.
      Statement query;
      try {
        query = conn.createStatement();
 
        // Insert-Statement erzeugen (Fragezeichen werden später ersetzt).
        String sql = updateoldNutzer; 
                	        
        PreparedStatement ps = conn.prepareStatement(sql);
     
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        
        // Parameter durch übernommene Daten ersetzen
        preparedStatement.setString(1, tempnutzer.getUsername());
        preparedStatement.setString(2, tempnutzer.getPassword() );
        preparedStatement.setString(3, tempnutzer.getNachname() );
        preparedStatement.setString(4, tempnutzer.getVorname() );
        preparedStatement.setString(5, tempnutzer.getGruppe() );
        preparedStatement.setString(6, tempnutzer.getStatus() );
        preparedStatement.setString(7, oldname );
                        
        // SQL ausführen
        preparedStatement.executeUpdate();
        
        ready = true;
        
    } catch (SQLException e) {
        e.printStackTrace();
        
        ready = false;
      }
    }	    
    return ready;
  }


}
