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

	// final static String returnAllNutzerString = "SELECT * FROM t_nutzer";
	// final static String updateoldNutzerString =
	// "UPDATE t_nutzer SET benutzername=?, passwort=?, Name=?, Vorname=?, Nutzerrolle=?, Status=? WHERE benutzername=? ";
	// final static String deleteNutzerString =
	// "UPDATE t_nutzer SET Status='Geloescht am', ZeitstempelLoeschung=curDate() WHERE benutzername=? ";

	final static String returnAllNutzerString = "SELECT * FROM t_nutzer";
	final static String updateoldNutzerString = "UPDATE t_nutzer SET benutzername=?, passwort=MD5(?), Name=?, Vorname=?, Nutzerrolle=?, Status=? WHERE benutzername=? ";
	final static String deleteNutzerString = "UPDATE t_nutzer SET Status='Geloescht am', ZeitstempelLoeschung=curDate() WHERE benutzername=? ";
	final static String insertnewNutzerString = "INSERT INTO t_nutzer( benutzername, passwort, Name, Vorname, Nutzerrolle, Status) VALUES (?, MD5(?), ?, ?, ?,?)";
	final static String getpasswordString = "SELECT * FROM t_nutzer where benutzername=? AND passwort=MD5(?) AND Status='Aktiviert' ";

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
		Connection conn = null;

		conn = MySQLConnection.getInstance();

		if (conn != null) {

			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();

				// Ergebnistabelle erzeugen und abholen.
				String sql = "SELECT * FROM t_nutzer";
				ResultSet result = query.executeQuery(sql);

				while (result.next()) {

					if (!(result.getString("benutzername")
							.equals("Administrator"))) {

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
								nachname, vorname, nutzerrolle, status,
								zeitDelete);

						nutzerliste.add(tempnutzer);

					}

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nutzerliste;
	}

	public static boolean updateNutzer(Nutzer oldNutzer, String oldname) {

		/**
		 * @param Übernimmt
		 *            einen Nutzer - Objekt und updatet dieses in der Datenbank
		 * @param gibt
		 *            ein boolean zurück, ob das Update erfolgreich war
		 */

		boolean ready = false;

		Nutzer tempnutzer = oldNutzer;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();

				// Insert-Statement erzeugen (Fragezeichen werden später
				// ersetzt).
				String sql = updateoldNutzerString;

				PreparedStatement ps = conn.prepareStatement(sql);

				PreparedStatement preparedStatement = conn
						.prepareStatement(sql);

				// Parameter durch übernommene Daten ersetzen
				preparedStatement.setString(1, tempnutzer.getUsername());
				preparedStatement.setString(2, tempnutzer.getPassword());
				preparedStatement.setString(3, tempnutzer.getNachname());
				preparedStatement.setString(4, tempnutzer.getVorname());
				preparedStatement.setString(5, tempnutzer.getGruppe());
				preparedStatement.setString(6, tempnutzer.getStatus());
				preparedStatement.setString(7, oldname);

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

	public static boolean deleteNutzer(Nutzer oldNutzer) {

		/**
		 * @param Übernimmt
		 *            einen Nutzer - Objekt und updatet dieses in der Datenbank
		 * @param gibt
		 *            ein boolean zurück, ob das Update erfolgreich war
		 */

		boolean ready = false;

		Nutzer tempnutzer = oldNutzer;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();

				// Insert-Statement erzeugen (Fragezeichen werden später
				// ersetzt).
				String sql = deleteNutzerString;

				PreparedStatement ps = conn.prepareStatement(sql);

				PreparedStatement preparedStatement = conn
						.prepareStatement(sql);

				// Parameter durch übernommene Daten ersetzen
				preparedStatement.setString(1, tempnutzer.getUsername());

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

	public static boolean pruefungPasswort(String benutzername,
			String passwortabfrage) {

		int counter = 0;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Ergebnistabelle erzeugen und abholen.
				String sql = getpasswordString;

				PreparedStatement ps = conn.prepareStatement(sql);

				// Erstes Fragezeichen durch "Name" Parameter ersetzen
				ps.setString(1, benutzername);
				ps.setString(2, passwortabfrage);

				// SQL ausführen.
				ResultSet result = ps.executeQuery();

				// Passwort auslesen
				while (result.next()) {
					counter++;
				}
				
				return counter==1;

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return false;
	}

}
