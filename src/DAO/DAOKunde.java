package DAO;

/**
 * 
 * @author mrothe
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import mySQLConnector.MySQLConnection;
import objects.Kunde;

public class DAOKunde {

	final String returnKundebyPLZString = "SELECT * FROM t_kunde WHERE plz LIKE ? ";
	final String returnKundebyKundenNrString = "SELECT * FROM t_kunde WHERE kundennr LIKE ? ";
	final String returnKundebyNameString = "SELECT * FROM t_kunde WHERE name LIKE ? ";
	
	final String returnCarbyKundenNrString = "Select name, fin, hersteller, Modellcode, farbe from (t_kunde inner join t_kfz on fk_t_kunde_kundennr = kundennr) inner join t_kfztyp on fk_t_kfztyp_kfztypnr = kfztypnr where kundennr = ?";
	
	final static String returnAllKundeString = "SELECT * FROM t_kunde ";
	final String insertnewKundeString = "INSERT INTO t_kunde( name, vorname, strasse, plz, ort, kundeseit, telefon, fax, handy, mail) VALUES (?, ?, ?, ?, ?, curDate(), ?, ?,?,?)";
	final String updateoldKunde = "UPDATE t_kunde SET name=?, vorname=?, strasse=?, plz=?, ort=?, kundeseit=?, telefon=?, fax=?, handy=?, mail=? WHERE kundennr=? ";

	public ArrayList<Kunde> returnKundebyPLZ(int postleitzahl) {

		ArrayList<Kunde> kundenliste = new ArrayList<Kunde>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Ergebnistabelle erzeugen und abholen.

				PreparedStatement ps = conn
						.prepareStatement(returnKundebyPLZString);

				// Erstes Fragezeichen durch "PLZ" Parameter ersetzen
				ps.setInt(1, postleitzahl);

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
					Kunde tempkunde = new Kunde(nachname, vorname, strasse,
							plz, ort, telefon, telefax, handy, email);

					// Extra Setzen der 2 Attribute, weil diese nicht im
					// Konstruktor vorkommen
					// Attribute nicht im Konstruktor, damit bei setzen eines
					// neuen Kunden diese beiden Werte automatisch gesetzt
					// werden können

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

	public ArrayList<Kunde> returnKundebyKundenNr(int kundennummer) {

		ArrayList<Kunde> kundenliste = new ArrayList<Kunde>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Ergebnistabelle erzeugen und abholen.

				PreparedStatement ps = conn
						.prepareStatement(returnKundebyKundenNrString);

				// Erstes Fragezeichen durch "Kundennummer" Parameter ersetzen
				ps.setInt(1, kundennummer);

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
					Kunde tempkunde = new Kunde(nachname, vorname, strasse,
							plz, ort, telefon, telefax, handy, email);

					// Extra Setzen der 2 Attribute, weil diese nicht im
					// Konstruktor vorkommen
					// Attribute nicht im Konstruktor, damit bei setzen eines
					// neuen Kunden diese beiden Werte automatisch gesetzt
					// werden können

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

	public ArrayList<Kunde> returnKundebyName(String kundenname) {

		ArrayList<Kunde> kundenliste = new ArrayList<Kunde>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Ergebnistabelle erzeugen und abholen.

				PreparedStatement ps = conn
						.prepareStatement(returnKundebyNameString);

				// Erstes Fragezeichen durch "Name" Parameter ersetzen
				ps.setString(1, kundenname);

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
					Kunde tempkunde = new Kunde(nachname, vorname, strasse,
							plz, ort, telefon, telefax, handy, email);

					// Extra Setzen der 2 Attribute, weil diese nicht im
					// Konstruktor vorkommen
					// Attribute nicht im Konstruktor, damit bei setzen eines
					// neuen Kunden diese beiden Werte automatisch gesetzt
					// werden können

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

	public static ArrayList<Kunde> returnAllKunde() {

		ArrayList<Kunde> kundenliste = new ArrayList<Kunde>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Ergebnistabelle erzeugen und abholen.

				PreparedStatement ps = conn
						.prepareStatement(returnAllKundeString);

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

					Kunde tempkunde = new Kunde(nachname, vorname, strasse,
							plz, ort, telefon, telefax, handy, email);

					// Extra Setzen der 2 Attribute, weil diese nicht im
					// Konstruktor vorkommen
					// Attribute nicht im Konstruktor, damit bei setzen eines
					// neuen Kunden diese beiden Werte automatisch gesetzt
					// werden können

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

	public boolean insertnewKunde(Kunde tempkunde) {

		/**
		 * @param Übernimmt
		 *            ein Kunde - Objekt und fügt dieses in die Datenbank ein
		 *            bei Kundeseit wird aktuelles Datum verwendet Kundennummer
		 *            wird durch Datenbank incrementell erstellt
		 */

		boolean ready = false;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Insert-Statement erzeugen (Fragezeichen werden später
				// ersetzt).
				
				PreparedStatement preparedStatement = conn
						.prepareStatement(insertnewKundeString);

				// Parameter durch übernommene Daten ersetzen
				preparedStatement.setString(1, tempkunde.getNachname());
				preparedStatement.setString(2, tempkunde.getVorname());
				preparedStatement.setString(3, tempkunde.getStrasse());
				preparedStatement.setInt(4, tempkunde.getPlz());
				preparedStatement.setString(5, tempkunde.getOrt());
				preparedStatement.setString(6, tempkunde.getTelefon());
				preparedStatement.setString(7, tempkunde.getTelefax());
				preparedStatement.setString(8, tempkunde.getHandy());
				preparedStatement.setString(9, tempkunde.getEmail());

				// SQL ausführen
				preparedStatement.executeUpdate();

				ready = true;

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return ready;
	}

	public boolean updateKunde(Kunde tempkunde) {

		/**
		 * @param Übernimmt
		 *            ein Kunde - Objekt und updates dieses in der Datenbank
		 * @param Gibt
		 *            true zurück, wenn das Update erfolgreich war
		 *
		 */

		boolean ready = false;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Insert-Statement erzeugen (Fragezeichen werden später
				// ersetzt).
				
				PreparedStatement preparedStatement = conn
						.prepareStatement(updateoldKunde);

				// Parameter durch übernommene Daten ersetzen
				preparedStatement.setString(1, tempkunde.getNachname());
				preparedStatement.setString(2, tempkunde.getVorname());
				preparedStatement.setString(3, tempkunde.getStrasse());
				preparedStatement.setInt(4, tempkunde.getPlz());
				preparedStatement.setString(5, tempkunde.getOrt());
				preparedStatement.setDate(6, tempkunde.getKundeseit());
				preparedStatement.setString(7, tempkunde.getTelefon());
				preparedStatement.setString(8, tempkunde.getTelefax());
				preparedStatement.setString(9, tempkunde.getHandy());
				preparedStatement.setString(10, tempkunde.getEmail());
				preparedStatement.setInt(11, tempkunde.getKundennr());

				// SQL ausführen
				preparedStatement.executeUpdate();

				ready = true;

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return ready;
	}

}
