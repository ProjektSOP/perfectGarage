package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mySQLConnector.MySQLConnection;
import objects.Nutzer;

public class DAONutzer {

	final static String returnAllNutzerString = "SELECT * FROM t_nutzer";
	final static String returnAllNutzerWithoutAdminString = "SELECT * FROM t_nutzer WHERE benutzername != 'Administrator' ";
	final static String updateoldNutzerString = "UPDATE t_nutzer SET benutzername=?, Name=?, Vorname=?, Nutzerrolle=?, Status=? WHERE benutzername=? ";
	final static String deleteNutzerString = "UPDATE t_nutzer SET Status='Geloescht am', ZeitstempelLoeschung=curDate() WHERE benutzername=? ";
	final static String insertnewNutzerString = "INSERT INTO t_nutzer( benutzername, passwort, Name, Vorname, Nutzerrolle, Status) VALUES (?, MD5(?), ?, ?, ?,?)";
	final static String getpasswordString = "SELECT * FROM t_nutzer where benutzername=? AND passwort=MD5(?) AND Status='Aktiviert' ";
	final static String anzahlKundenString = "select count(kundennr) as 'Anzahl Kunden' from t_kunde";
	final static String updateNutzerRolleString = "UPDATE t_nutzer SET Nutzerrolle=? WHERE benutzername=? ";
	final static String updateNutzerPwString = "UPDATE t_nutzer SET passwort=MD5(?) WHERE benutzername=? ";

	public static ArrayList<Nutzer> returnAllNutzer() {

		ArrayList<Nutzer> nutzerliste = new ArrayList<Nutzer>();
		Connection conn = null;

		conn = MySQLConnection.getInstance();

		if (conn != null) {

			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();

				// Ergebnistabelle erzeugen und abholen.
				ResultSet result = query.executeQuery(returnAllNutzerString);

				// Ergebniss�tze durchfahren.
				while (result.next()) {

					String benutzername = result.getString("benutzername");
					String passwort = result.getString("passwort");
					String nachname = result.getString("Name"); //
					String vorname = result.getString("Vorname");
					String nutzerrolle = result.getString("Nutzerrolle");
					String status = result.getString("Status");
					Date zeitstempelLoeschung = result
							.getDate("zeitstempelLoeschung");
					String delete = "" + zeitstempelLoeschung;

					Nutzer tempnutzer = new Nutzer(benutzername, passwort,
							nachname, vorname, nutzerrolle, status, delete);

					nutzerliste.add(tempnutzer);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nutzerliste;
	}

	public static ArrayList<Nutzer> returnAllNutzerWithoutAdmin() {

		ArrayList<Nutzer> nutzerliste = new ArrayList<Nutzer>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();

				// Ergebnistabelle erzeugen und abholen.
				ResultSet result = query.executeQuery(returnAllNutzerWithoutAdminString);

				while (result.next()) {

					String benutzername = result.getString("benutzername");
					String passwort = result.getString("passwort");
					String nachname = result.getString("Name"); //
					String vorname = result.getString("Vorname");
					String nutzerrolle = result.getString("Nutzerrolle");
					String status = result.getString("Status");
					Date zeitstempelLoeschung = result
							.getDate("zeitstempelLoeschung");
					String zeitDelete = "" + zeitstempelLoeschung;

					Nutzer tempnutzer = new Nutzer(benutzername, passwort,
							nachname, vorname, nutzerrolle, status, zeitDelete);

					nutzerliste.add(tempnutzer);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return nutzerliste;
	}

	public static boolean updateNutzer(Nutzer tempnutzer, String oldname) {

		/**
		 * @param �bernimmt
		 *            einen Nutzer - Objekt und den Namen des Benutzers (falls
		 *            der Name ge�ndert werden soll) und updatet dieses in der
		 *            Datenbank
		 * @param gibt
		 *            ein boolean zur�ck, ob das Update erfolgreich war
		 */

		boolean ready = false;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Insert-Statement erzeugen (Fragezeichen werden sp�ter
				// ersetzt).
				PreparedStatement preparedStatement = conn
						.prepareStatement(updateoldNutzerString);

				// Parameter durch �bernommene Daten ersetzen
				preparedStatement.setString(1, tempnutzer.getUsername());
				preparedStatement.setString(2, tempnutzer.getNachname());
				preparedStatement.setString(3, tempnutzer.getVorname());
				preparedStatement.setString(4, tempnutzer.getGruppe());
				preparedStatement.setString(5, tempnutzer.getStatus());
				preparedStatement.setString(6, oldname);

				// SQL ausf�hren
				preparedStatement.executeUpdate();

				ready = true;

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return ready;
	}
	
	public static boolean updateNutzerRolle(Nutzer tempnutzer) {

		/**
		 * @param �bernimmt
		 *            einen Nutzer - Objekt und updatet dieses in der
		 *            Datenbank
		 * @param gibt
		 *            ein boolean zur�ck, ob das Update erfolgreich war
		 */

		boolean done = false;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Insert-Statement erzeugen (Fragezeichen werden sp�ter
				// ersetzt).
				PreparedStatement preparedStatement = conn
						.prepareStatement(updateNutzerRolleString);

				// Parameter durch �bernommene Daten ersetzen
				preparedStatement.setString(1, tempnutzer.getGruppe());
				preparedStatement.setString(2, tempnutzer.getUsername());

				// SQL ausf�hren
				preparedStatement.executeUpdate();

				done = true;

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return done;
	}
		public static boolean updateNutzerPw(Nutzer tempnutzer) {

			/**
			 * @param �bernimmt
			 *            einen Nutzer - Objekt und updatet das Passwort in der
			 *            Datenbank
			 * @param gibt
			 *            ein boolean zur�ck, ob das Update erfolgreich war
			 */

			boolean done = false;

			Connection conn = MySQLConnection.getInstance();

			if (conn != null) {

				try {
					// Insert-Statement erzeugen (Fragezeichen werden sp�ter
					// ersetzt).
					PreparedStatement preparedStatement = conn
							.prepareStatement(updateNutzerPwString);

					// Parameter durch �bernommene Daten ersetzen
					preparedStatement.setString(1, tempnutzer.getPassword());
					preparedStatement.setString(2, tempnutzer.getUsername());

					// SQL ausf�hren
					preparedStatement.executeUpdate();

					done = true;

				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
			return done;
	}

	public static boolean deleteNutzer(Nutzer oldNutzer) {

		/**
		 * @param �bernimmt
		 *            einen Nutzer - Objekt und updatet dieses in der Datenbank
		 * @param gibt
		 *            ein boolean zur�ck, ob das Update erfolgreich war
		 */

		boolean ready = false;

		Nutzer tempnutzer = oldNutzer;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Insert-Statement erzeugen (Fragezeichen werden sp�ter
				// ersetzt).
				PreparedStatement preparedStatement = conn
						.prepareStatement(deleteNutzerString);

				// Parameter durch �bernommene Daten ersetzen
				preparedStatement.setString(1, tempnutzer.getUsername());

				// SQL ausf�hren
				preparedStatement.executeUpdate();

				ready = true;

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return ready;
	}

	public static boolean pruefungPasswort(String benutzername,
			String passwortabfrage) {

		int counter = 0;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Ergebnistabelle erzeugen und abholen.
				PreparedStatement ps = conn.prepareStatement(getpasswordString);

				// Erstes Fragezeichen durch "Name" Parameter ersetzen
				ps.setString(1, benutzername);
				ps.setString(2, passwortabfrage);

				// SQL ausf�hren.
				ResultSet result = ps.executeQuery();

				// Passwort auslesen
				while (result.next()) {
					counter++;
				}

				return counter == 1;

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return false;
	}

	public static boolean insertNutzer(Nutzer tempnutzer) {

		/**
		 * @param �bernimmt
		 *            einen Nutzer - Objekt und updatet dieses in der Datenbank
		 * @param gibt
		 *            ein boolean zur�ck, ob das Update erfolgreich war
		 */

		boolean ready = false;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Insert-Statement erzeugen (Fragezeichen werden sp�ter
				// ersetzt).
				PreparedStatement preparedStatement = conn
						.prepareStatement(insertnewNutzerString);

				// Parameter durch �bernommene Daten ersetzen
				preparedStatement.setString(1, tempnutzer.getUsername());
				preparedStatement.setString(2, tempnutzer.getPassword());
				preparedStatement.setString(3, tempnutzer.getNachname());
				preparedStatement.setString(4, tempnutzer.getVorname());
				preparedStatement.setString(5, tempnutzer.getGruppe());
				preparedStatement.setString(6, tempnutzer.getStatus());

				// SQL ausf�hren
				preparedStatement.executeUpdate();

				ready = true;

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return ready;
	}

	public static int returnanzahlKunden() {
		
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

}
