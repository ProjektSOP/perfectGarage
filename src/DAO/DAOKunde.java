package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import mySQLConnector.MySQLConnection;
import objects.Kunde;

public class DAOKunde {
	
	final String returnKundebyPLZString = "SELECT * FROM t_kunde WHERE plz LIKE ? ";
	final String returnKundebyKundenNrString = "SELECT * FROM t_kunde WHERE kundennr LIKE ? ";
	final String returnKundebyNameString = "SELECT * FROM t_kunde WHERE name LIKE ? ";
	final static String returnAllKundeString = "SELECT * FROM t_kunde ";
	final String insertnewKundeString = "INSERT INTO t_kunde( name, vorname, strasse, plz, ort, kundeseit, telefon, fax, handy, mail) VALUES (?, ?, ?, ?, ?, curDate(), ?, ?,?,?)";
	final String updateoldKunde = "UPDATE t_kunde SET name=?, vorname=?, strasse=?, plz=?, ort=?, kundeseit=?, telefon=?, fax=?, handy=?, mail=? WHERE kundennr=? ";
	
public ArrayList<Kunde> returnKundebyPLZ(int postleitzahl)  {

		ArrayList<Kunde> kundenliste = new ArrayList<Kunde>();
		
		int iplz = postleitzahl;
					     
		Connection conn = MySQLConnection.getInstance();
		 
	    if(conn != null)
	    {
	    	
	      // Anfrage-Statement erzeugen.
	      Statement query;
	      try {
	        query = conn.createStatement();
	 
	        // Ergebnistabelle erzeugen und abholen.
	        String sql = returnKundebyPLZString;
	        	        
	        PreparedStatement ps = conn.prepareStatement(sql);
	        
	        // Erstes Fragezeichen durch "PLZ" Parameter ersetzen
	        ps.setInt(1, iplz);
	     
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
	            Kunde tempkunde = new Kunde(nachname, vorname, strasse, plz, ort, telefon, telefax, handy, email);
	            
	          // Extra Setzen der 2 Attribute, weil diese nicht im Konstruktor vorkommen
	          // Attribute nicht im Konstruktor, damit bei setzen eines neuen Kunden diese beiden Werte automatisch gesetzt werden können
	            
	            tempkunde.setKundeseit(kundeseit);
	            tempkunde.setKundennr(kundennr);
	            
	          kundenliste.add(tempkunde);
	          }
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }	    
	    return kundenliste;
	  }
	
public ArrayList<Kunde> returnKundebyKundenNr(int kundennummer)  {

	ArrayList<Kunde> kundenliste = new ArrayList<Kunde>();
	
	int ikundennr = kundennummer;
				     
	Connection conn = MySQLConnection.getInstance();
	 
    if(conn != null)
    {
    	
      // Anfrage-Statement erzeugen.
      Statement query;
      try {
        query = conn.createStatement();
 
        // Ergebnistabelle erzeugen und abholen.
        String sql = returnKundebyKundenNrString;
        	        
        PreparedStatement ps = conn.prepareStatement(sql);
        
        // Erstes Fragezeichen durch "Kundennummer" Parameter ersetzen
        ps.setInt(1, ikundennr);
        	        
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
          Kunde tempkunde = new Kunde(nachname, vorname, strasse, plz, ort, telefon, telefax, handy, email);
          
        // Extra Setzen der 2 Attribute, weil diese nicht im Konstruktor vorkommen
        // Attribute nicht im Konstruktor, damit bei setzen eines neuen Kunden diese beiden Werte automatisch gesetzt werden können
          
          tempkunde.setKundeseit(kundeseit);
          tempkunde.setKundennr(kundennr);
          
          kundenliste.add(tempkunde);
          }
        

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
	        String sql = returnKundebyNameString;
	        	        
	        PreparedStatement ps = conn.prepareStatement(sql);
	        
	        // Erstes Fragezeichen durch "Name" Parameter ersetzen
	        ps.setString(1, name);
	        	        
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
	            Kunde tempkunde = new Kunde(nachname, vorname, strasse, plz, ort, telefon, telefax, handy, email);
	            
	          // Extra Setzen der 2 Attribute, weil diese nicht im Konstruktor vorkommen
	          // Attribute nicht im Konstruktor, damit bei setzen eines neuen Kunden diese beiden Werte automatisch gesetzt werden können
	            
	            tempkunde.setKundeseit(kundeseit);
	            tempkunde.setKundennr(kundennr);
	            
	          kundenliste.add(tempkunde);
	          }

	    } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }	    
	    return kundenliste;
	  }

public static ArrayList<Kunde> returnAllKunde()  {
	
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
        String sql = returnAllKundeString;
        	        
        PreparedStatement ps = conn.prepareStatement(sql);
        	        
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
        	          	          	         
            Kunde tempkunde = new Kunde(nachname, vorname, strasse, plz, ort, telefon, telefax, handy, email);
            
          // Extra Setzen der 2 Attribute, weil diese nicht im Konstruktor vorkommen
          // Attribute nicht im Konstruktor, damit bei setzen eines neuen Kunden diese beiden Werte automatisch gesetzt werden können
            
            tempkunde.setKundeseit(kundeseit);
            tempkunde.setKundennr(kundennr);
            
          kundenliste.add(tempkunde);
          }
        
    } catch (SQLException e) {
        e.printStackTrace();
      }
    }	    
    return kundenliste;
  }

public boolean insertnewKunde(Kunde newkunde)  {
	
	/**
	 *	@param Übernimmt ein Kunde - Objekt und fügt dieses in die Datenbank ein 
	 *	bei Kundeseit wird aktuelles Datum verwendet
	 *	Kundennummer wird durch Datenbank incrementell erstellt
	*/
	
	boolean ready = false;
	
	Kunde tempkunde = newkunde;
		
	Connection conn = MySQLConnection.getInstance();
	 
    if(conn != null)
    {
    	
      // Anfrage-Statement erzeugen.
      Statement query;
      try {
        query = conn.createStatement();
 
        // Insert-Statement erzeugen (Fragezeichen werden später ersetzt).
        String sql = insertnewKundeString; 
        	        
        PreparedStatement ps = conn.prepareStatement(sql);
     
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        
        // Parameter durch übernommene Daten ersetzen
        preparedStatement.setString(1, tempkunde.getNachname() );
        preparedStatement.setString(2, tempkunde.getVorname() );
        preparedStatement.setString(3, tempkunde.getStrasse() );
        preparedStatement.setInt(4, tempkunde.getPlz() );
        preparedStatement.setString(5, tempkunde.getOrt() );
        preparedStatement.setString(6, tempkunde.getTelefon() );
        preparedStatement.setString(7, tempkunde.getTelefax() );
        preparedStatement.setString(8, tempkunde.getHandy() );
        preparedStatement.setString(9, tempkunde.getEmail() );
                
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

public boolean updateKunde(Kunde oldkunde)  {
	
	/**
	 *	@param Übernimmt ein Kunde - Objekt und updates dieses in der Datenbank
	 *	@param Gibt true zurück, wenn das Update erfolgreich war
	 *	
	*/
	
	boolean ready = false;
	
	Kunde tempkunde = oldkunde;
		
	Connection conn = MySQLConnection.getInstance();
	 
    if(conn != null)
    {
    	
      // Anfrage-Statement erzeugen.
      Statement query;
      try {
        query = conn.createStatement();
 
        // Insert-Statement erzeugen (Fragezeichen werden später ersetzt).
        String sql = updateoldKunde; 
                	        
        PreparedStatement ps = conn.prepareStatement(sql);
     
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        
        // Parameter durch übernommene Daten ersetzen
        preparedStatement.setString(1, tempkunde.getNachname());
        preparedStatement.setString(2, tempkunde.getVorname() );
        preparedStatement.setString(3, tempkunde.getStrasse() );
        preparedStatement.setInt(4, tempkunde.getPlz() );
        preparedStatement.setString(5, tempkunde.getOrt() );
        preparedStatement.setDate(6, tempkunde.getKundeseit() );
        preparedStatement.setString(7, tempkunde.getTelefon() );
        preparedStatement.setString(8, tempkunde.getTelefax() );
        preparedStatement.setString(9, tempkunde.getHandy() );
        preparedStatement.setString(10, tempkunde.getEmail() );
        preparedStatement.setInt(11, tempkunde.getKundennr());
                
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


