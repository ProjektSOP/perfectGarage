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

public class DAOKunde {
	
	public ArrayList<Kunde> returnKundebyPLZ(int postleitzahl)  {

		ArrayList<Kunde> kundenliste = new ArrayList<Kunde>();
		Connection conn = null;
		int iplz = postleitzahl;
					     
		conn = MySQLConnection.getInstance();
		 
	    if(conn != null)
	    {
	    	
	      // Anfrage-Statement erzeugen.
	      Statement query;
	      try {
	        query = conn.createStatement();
	 
	        // Ergebnistabelle erzeugen und abholen.
	        String sql = "SELECT * FROM t_kunde WHERE plz LIKE ? ";
	        	        
	        PreparedStatement ps = conn.prepareStatement(sql);
	        
	        // Erstes Fragezeichen durch "PLZ" Parameter ersetzen
	        ps.setInt(1, iplz);
	     
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
	        	
			// Abspeichern der Daten in den Objekten	          	          	         
	          Kunde tempkunde = new Kunde(kundennr, nachname, vorname, strasse, plz, ort, kundeseit, telefon, telefax, handy, email);
	          
	          kundenliste.add(tempkunde);
	          }
	        
	        // Test Ausgabe
	      //  /**
	        for (Kunde k : kundenliste ){
	        	System.out.println(k.getNachname() + " " + k.getVorname() + k.getPlz() );
	        }
	       	//  */
	    } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }	    
	    return kundenliste;
	  }

	
public ArrayList<Kunde> returnKundebyKundenNr(int kundennummer)  {

	ArrayList<Kunde> kundenliste = new ArrayList<Kunde>();
	Connection conn = null;
	int ikundennr = kundennummer;
				     
	conn = MySQLConnection.getInstance();
	 
    if(conn != null)
    {
    	
      // Anfrage-Statement erzeugen.
      Statement query;
      try {
        query = conn.createStatement();
 
        // Ergebnistabelle erzeugen und abholen.
        String sql = "SELECT * FROM t_kunde WHERE kundennr LIKE ? ";
        	        
        PreparedStatement ps = conn.prepareStatement(sql);
        
        // Erstes Fragezeichen durch "Kundennummer" Parameter ersetzen
        ps.setInt(1, ikundennr);
     
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
        	
		// Abspeichern der Daten in den Objekten	          	          	         
          Kunde tempkunde = new Kunde(kundennr, nachname, vorname, strasse, plz, ort, kundeseit, telefon, telefax, handy, email);
          
          kundenliste.add(tempkunde);
          }
        
        // Test Ausgabe
      //  /**
        for (Kunde k : kundenliste ){
        	System.out.println(k.getNachname() + " " + k.getVorname() );
        }
       	//  */
    } catch (SQLException e) {
        e.printStackTrace();
      }
    }	    
    return kundenliste;
  }



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
	        
	        // Erstes Fragezeichen durch "Name" Parameter ersetzen
	        ps.setString(1, name);
	     
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
	        	
			// Abspeichern der Daten in den Objekten	          	          	         
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

public ArrayList<Kunde> returnAllKunde()  {
	
	ArrayList<Kunde> kundenliste = new ArrayList<Kunde>();
	Connection conn = null;
				     
	conn = MySQLConnection.getInstance();
	 
    if(conn != null)
    {
    	
      // Anfrage-Statement erzeugen.
      Statement query;
      try {
        query = conn.createStatement();
 
        // Ergebnistabelle erzeugen und abholen.
        String sql = "SELECT * FROM t_kunde ";
        	        
        PreparedStatement ps = conn.prepareStatement(sql);
     
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
        	
		// Abspeichern der Daten in den Objekten	          	          	         
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


