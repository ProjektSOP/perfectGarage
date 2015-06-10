package DAO;

/**
 * @author mrothe
 * 
 * Diese DAO ist im Lastenheft nicht gefordert, für das Fach DB aber die Funktion Aggregatfunktion noch gewünscht
 * 
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mySQLConnector.MySQLConnection;

public class DAOStatistik {

	final static String anzahlKundenString = "select count(kundennr) as 'Anzahl Kunden' from t_kunde";
	final static String durschnittKostenString = "select avg(kosten) as 'Durschnittliche Kosten' from t_arbeitsteilauftrag;";


	public static int returnanzahlKunden() {
		
		/**
		 * @return gibt zur Auswertung die Anzahl aller Kunden zurück 
		 */

		int anzahlkunden = 0;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			Statement query;
			try {
				query = conn.createStatement();

				ResultSet result = query.executeQuery(anzahlKundenString);

				while (result.next()) {

					anzahlkunden = result.getInt("Anzahl Kunden");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return anzahlkunden;
	}
	
	public static int returndurschnittKosten() {
		
		/**
		 * @return gibt zur Durchschnittlichen Kosten aller Aufträge zurück 
		 */

		int durschnittKosten = 0;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			Statement query;
			try {
				query = conn.createStatement();

				ResultSet result = query.executeQuery(durschnittKostenString);

				while (result.next()) {

					durschnittKosten = result.getInt("Durschnittliche Kosten");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return durschnittKosten;
	}

}
