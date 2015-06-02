package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import mySQLConnector.MySQLConnection;
import objects.Kunde;
import objects.Nutzer;

public class DAO_KundeByName {
	
public ArrayList<Kunde> returnKundebyName(String kundenname)  {
	
		ArrayList<Kunde> kundenliste = new ArrayList<Kunde>();
		Connection conn = null;
		String name = kundenname;
					     
		conn = MySQLConnection.getInstance();
		 
	    if(conn != null)
	    {
	    	
	      // Anfrage-Statement erzeugen.
	      Statement query;
	      try {
	        query = conn.createStatement();
	 
	        // Ergebnistabelle erzeugen und abholen.
	        String sql = "SELECT * FROM t_kunde WHERE name LIKE ? ";
	        	        
	        PreparedStatement ps = conn.prepareStatement(sql);
	        
	        // Erstes Fragezeichen durch "firstName" Parameter ersetzen
	        ps.setString(1, kundenname);
	     
	        // FUNKTIONSTEST
	        System.out.println(sql);
	        
	        
	        // SQL ausführen.
	        	 
	        ResultSet result = ps.executeQuery();
	              
	       	 
	        // Ergebnissätze durchfahren.
	       	        
	        while (result.next()) {
	        
	        	int kundennr = result.getInt("kundennr"); 
	        	String nachname = result.getString("name"); 
	        	String vorname = result.getString("Vorname"); // 
	        	String strasse = result.getString("Strasse"); 
	        	int plz = result.getInt("PLZ");
	        	String ort = result.getString("Ort"); 
	        	Date kundeseit = result.getDate("Kundeseit"); 
	        	String telefon = result.getString("telefon"); 
	        	String telefax = result.getString("fax"); 
	        	String handy = result.getString("handy"); 
	        	String email = result.getString("mail"); 
	        	
					          	          	         
	          Kunde tempkunde = new Kunde(kundennr, nachname, vorname, strasse, plz, ort, kundeseit, telefon, telefax, handy, email);
	          
	          kundenliste.add(tempkunde);
	         	                    
	        }
	        
	        // Test Ausgabe
	        /**
	        for (Kunde k : kundenliste ){
	        	System.out.println(k.getNachname() + " " + k.getVorname() );
	        }
	       	  */
	        
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }	    
	    return kundenliste;
	  }

	

}
