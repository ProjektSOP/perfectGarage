/**
 * 
 */
package mySQLConnector;

/**
 * @author mrothe
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class MySQLConnection {
	 
	  private static Connection conn = null;
	  private static boolean isConnected = false;
	 
	 
public static boolean connect() {
		if (!isConnected) {
	    try {
	    	
	       // Properties auslesen 
	       	InputStream in = MySQLConnection.class.getResourceAsStream("settings.properties");
	         Properties properties = new Properties();
	         try {
				properties.load(in);
				
			} catch (IOException e) {
				// TO-DO Hier sollte noch ein Fehlerlog eingebaut werden
				System.out.println("Fehler beim Einlesen der Properties datei " + e.getMessage() );
			}
	       	        
	      // Properties setzen   
	         String dbHost = properties.getProperty("db.host");
	         String dbPort = properties.getProperty("db.port");
	         String dbName = properties.getProperty("db.name");
	         String dbUser = properties.getProperty("db.user");
	         String dbPassword = properties.getProperty("db.password");
	         
	      // Datenbanktreiber für ODBC Schnittstellen laden.
	      
	      Class.forName("com.mysql.jdbc.Driver");
	 
	      
	      // Es wird die JDBC-ODBC-Brücke verwendet.
	      conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?" + "user=" + dbUser + "&"
	          + "password=");
	    } catch (ClassNotFoundException e) {
	    	System.out.println("Treiber nicht gefunden");
	    	
	    } catch (SQLException e) {
	    	System.out.println("Connect nicht moeglich");
	    	System.out.println(e.getMessage());
	    }
	    	    
	  }
	return isConnected;
}
	 
public static Connection getInstance() {
	    if(conn == null)
	      new MySQLConnection();
	    return conn;
	  }
	  
	 
	  /**
	   * Schreibt die Namensliste in die Konsole
	   */
public static void printNameList()
	  {
	    conn = getInstance();
	 
	    if(conn != null)
	    {
	      // Anfrage-Statement erzeugen.
	      Statement query;
	      try {
	        query = conn.createStatement();
	 
	        // Ergebnistabelle erzeugen und abholen.
	        String sql = "SELECT benutzername, passwort, name, vorname, nutzerrolle FROM t_nutzer";
	        ResultSet result = query.executeQuery(sql);
	 
	        // Ergebnissätze durchfahren.
	        while (result.next()) {
	          String benutzername = result.getString("benutzername"); 
	          String passwort = result.getString("passwort"); 
	          String name = result.getString("Name"); // 
	          String vorname = result.getString("Vorname"); 
	          String nutzerrolle = result.getString("Nutzerrolle");
	          System.out.println(vorname + ", " + name + ", " + passwort + ", " + benutzername + ", " + nutzerrolle + "\n");
	        }
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	  }
	 
	  /**
	   * Fügt einen neuen Datensatz hinzu 
	   
	  public static void insertName(String firstName, String lastName)
	  {
	    conn = getInstance();
	 
	    if(conn != null)
	    {
	      try {
	 
	        // Insert-Statement erzeugen (Fragezeichen werden später ersetzt).
	        String sql = "INSERT INTO actor(first_name, last_name) " +
	                     "VALUES(?, ?)";
	        PreparedStatement preparedStatement = conn.prepareStatement(sql);
	        // Erstes Fragezeichen durch "firstName" Parameter ersetzen
	        preparedStatement.setString(1, firstName);
	        // Zweites Fragezeichen durch "lastName" Parameter ersetzen
	        preparedStatement.setString(2, lastName);
	        // SQL ausführen.
	        preparedStatement.executeUpdate();
	 
	        // Es wird der letzte Datensatz abgefragt
	        String lastActor = "SELECT actor_id, first_name, last_name " +
	                           "FROM actor " +
	                           "ORDER BY actor_id DESC LIMIT 1";
	        ResultSet result = preparedStatement.executeQuery(lastActor);
	 
	        // Wenn ein Datensatz gefunden wurde, wird auf diesen zugegriffen 
	        if(result.next())
	        {
	          System.out.println("(" + result.getInt(1) + ")" + 
	              result.getString(2) + " " + 
	              result.getString(3));
	        }
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	  }*/
	 
	  /**
	   * Aktualisiert den Datensatz mit der übergebenen actorId 
	  
	  public static void updateName(String firstName, String lastName, int actorId)
	  {
	    conn = getInstance();
	 
	    if(conn != null)
	    {
	      try {
	 
	        String querySql = "SELECT actor_id, first_name, last_name " +
	                          "FROM actor " +
	                          "WHERE actor_id = ?";
	         
	        // PreparedStatement erzeugen.
	        PreparedStatement preparedQueryStatement = conn.prepareStatement(querySql);
	        preparedQueryStatement.setInt(1, actorId);
	        ResultSet result = preparedQueryStatement.executeQuery();
	 
	        if(result.next())
	        {
	          // Vorher
	          System.out.println("VORHER: (" + result.getInt(1) + ")" + 
	                                           result.getString(2) + " " + 
	                                           result.getString(3));
	        }
	 
	        // Ergebnistabelle erzeugen und abholen.
	        String updateSql = "UPDATE actor " +
	                           "SET first_name = ?, last_name = ? " +
	                           "WHERE actor_id = ?";
	        PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateSql);
	        // Erstes Fragezeichen durch "firstName" Parameter ersetzen
	        preparedUpdateStatement.setString(1, firstName);
	        // Zweites Fragezeichen durch "lastName" Parameter ersetzen
	        preparedUpdateStatement.setString(2, lastName);
	        // Drittes Fragezeichen durch "actorId" Parameter ersetzen
	        preparedUpdateStatement.setInt(3, actorId);
	        // SQL ausführen
	        preparedUpdateStatement.executeUpdate();
	         
	        // Es wird der letzte Datensatz abgefragt
	        result = preparedQueryStatement.executeQuery();
	 
	        if(result.next())
	        {
	          System.out.println("NACHHER: (" + result.getInt(1) + ")" + 
	                                            result.getString(2) + " " + 
	                                            result.getString(3));
	        }
	 
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	  } */
	}
