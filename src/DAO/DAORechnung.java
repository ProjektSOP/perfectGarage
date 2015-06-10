package DAO;

/**
 * 
 * @author mrothe
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mySQLConnector.MySQLConnection;
import objects.Rechnung;

public class DAORechnung {

	final static String returnAllRechnungenString = "SELECT rechnungsnr, rechnungsdatum, zahltag, rechnungsstatus FROM t_rechnung";
	final static String returnAllRechnungenbyStatusString = "SELECT rechnungsnr, rechnungsdatum, zahltag, rechnungsstatus FROM t_rechnung where rechnungsstatus=? ";
	final static String returnAllueberfaelleRechnungenString = "SELECT rechnungsnr, rechnungsdatum, zahltag, rechnungsstatus FROM t_rechnung where curDate() > zahltag ";
	final static String updateRechnungString = "UPDATE t_rechnung SET rechnungsdatum=?, zahltag=?, rechnungsstatus=? WHERE rechnungsnr=? ";
	final static String insertnewRechnungString = "INSERT INTO t_rechnung( rechnungsdatum, zahltag, rechnungsstatus) VALUES (?, ?, ?)";

	public static ArrayList<Rechnung> returnAllRechnungen() {

		/**
		 * @return Gibt alle Rechnungen in einer ArrayList<Rechnung> zurück,
		 *         welche sich in der Datenbank befinden
		 */

		ArrayList<Rechnung> rechnungsliste = new ArrayList<Rechnung>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();

				// Ergebnistabelle erzeugen und abholen.
				
				ResultSet result = query.executeQuery(returnAllRechnungenString);

				// Ergebnissätze durchfahren.
				while (result.next()) {

					int rechnungsnr = result.getInt("rechnungsnr");
					Date rechnungsdatum = result.getDate("rechnungsdatum");
					Date zahltag = result.getDate("zahltag");
					String rechnungsstatus = result
							.getString("rechnungsstatus");

					Rechnung temprechnung = new Rechnung(rechnungsnr,
							rechnungsdatum, zahltag, rechnungsstatus);

					rechnungsliste.add(temprechnung);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rechnungsliste;
	}

	public static ArrayList<Rechnung> returnAllueberfaelligeRechnungen() {

		/**
		 * @return gibt eine ArrayList<Rechnung> von Rechnungen zurück, welche
		 *         überfällig beim Zahltag ab dem aktuellem Datum sind
		 * 
		 */

		ArrayList<Rechnung> rechnungsliste = new ArrayList<Rechnung>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();

				// Ergebnistabelle erzeugen und abholen.

				ResultSet result = query
						.executeQuery(returnAllueberfaelleRechnungenString);

				// Ergebnissätze durchfahren.
				while (result.next()) {

					int rechnungsnr = result.getInt("rechnungsnr");
					Date rechnungsdatum = result.getDate("rechnungsdatum");
					Date zahltag = result.getDate("zahltag");
					String rechnungsstatus = result
							.getString("rechnungsstatus");

					Rechnung temprechnung = new Rechnung(rechnungsnr,
							rechnungsdatum, zahltag, rechnungsstatus);

					rechnungsliste.add(temprechnung);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rechnungsliste;
	}

	public static ArrayList<Rechnung> returnAllRechnungenbyStatus(String status) {

		/**
		 * @param Übernimmt
		 *            einen Status einer Rechnung als String
		 * @return gibt alle Rechnungen in einer ArrayList<Rechnung> zurück, die
		 *         diesen Status haben
		 */

		ArrayList<Rechnung> rechnungsliste = new ArrayList<Rechnung>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Ergebnistabelle erzeugen und abholen.

				PreparedStatement ps = conn
						.prepareStatement(returnAllRechnungenbyStatusString);

				// Erstes Fragezeichen durch "Status" Parameter ersetzen
				ps.setString(1, status);

				// SQL ausführen.
				ResultSet result = ps.executeQuery();

				// Ergebnissätze durchfahren.
				while (result.next()) {
					int rechnungsnr = result.getInt("rechnungsnr");
					Date rechnungsdatum = result.getDate("rechnungsdatum");
					Date zahltag = result.getDate("zahltag");
					String rechnungsstatus = result
							.getString("rechnungsstatus");

					Rechnung temprechnung = new Rechnung(rechnungsnr,
							rechnungsdatum, zahltag, rechnungsstatus);

					rechnungsliste.add(temprechnung);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rechnungsliste;
	}

	public static boolean updateRechnung(Rechnung neuerechnung) {

		/**
		 * @param Übernimmt
		 *            ein Rechnungsobjekt
		 * @return gibt True / False zurück, ob der Updatevorgang erfolgreich
		 *         war
		 */

		boolean done = false;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Insert-Statement erzeugen (Fragezeichen werden später
				// ersetzt).

				PreparedStatement preparedStatement = conn
						.prepareStatement(updateRechnungString);

				// Parameter durch übernommene Daten ersetzen
				preparedStatement.setDate(1, neuerechnung.getRechnungsdatum());
				preparedStatement.setDate(2, neuerechnung.getZahltag());
				preparedStatement.setString(3,
						neuerechnung.getRechnungsstatus());

				// SQL ausführen
				preparedStatement.executeUpdate();

				done = true;

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return done;
	}

	public static boolean insertnewRechnung(Rechnung neuerechnung) {

		/**
		 * @param Übernimmt
		 *            ein Rechnungsobjekt und fügt es in die Datenbank ein
		 * @return gibt ein True / False zurück wenn das Einfügen erfolgreich
		 *         war
		 * 
		 */

		boolean done = false;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Insert-Statement erzeugen (Fragezeichen werden später
				// ersetzt).
				
				PreparedStatement preparedStatement = conn
						.prepareStatement(insertnewRechnungString);

				// Parameter durch übernommene Daten ersetzen
				preparedStatement.setDate(1, neuerechnung.getRechnungsdatum());
				preparedStatement.setDate(1, neuerechnung.getZahltag() );
				preparedStatement.setString(3, neuerechnung.getRechnungsstatus());
				
				// SQL ausführen
				preparedStatement.executeUpdate();

				done = true;

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return done;
	}

}
