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
import objects.Arbeitsteilauftrag;
import objects.Auftragsmappe;

public class DAOArbeitsteilauftrag {

	final static String returnAllArbeitsteilauftraegeString = "SELECT arbeitsteilauftragnr, Arbeitsteilauftragsbezeichnung,KundenlesbareForm, Erstellungsdatum, ArbeitsteilauftragStatus, Abnahmedatum, Fremdvergabe, Kosten, ArbeitsteilauftragsPrioritaet FROM t_arbeitsteilauftrag";
	final static String returnAllArbeitsteilauftragByPrioritaetString = "SELECT arbeitsteilauftragnr, Arbeitsteilauftragsbezeichnung,KundenlesbareForm, Erstellungsdatum, ArbeitsteilauftragStatus, Abnahmedatum, Fremdvergabe, Kosten, ArbeitsteilauftragsPrioritaet FROM t_arbeitsteilauftrag Where ArbeitsteilauftragsPrioritaet =? ";
	final static String returnAllArbeitsteilauftragByAuftragsNrString = "SELECT fk_t_auftrag_AuftragsNr, arbeitsteilauftragnr, Arbeitsteilauftragsbezeichnung,KundenlesbareForm, Erstellungsdatum, ArbeitsteilauftragStatus, Abnahmedatum, Fremdvergabe, Kosten, ArbeitsteilauftragsPrioritaet FROM t_arbeitsteilauftrag Where fk_t_auftrag_AuftragsNr =? ";
	final static String updateArbeitsteilauftragString = "UPDATE t_arbeitsteilauftrag SET Arbeitsteilauftragsbezeichnung=?,KundenlesbareForm=?, ArbeitsteilauftragStatus=?, Abnahmedatum=?, Fremdvergabe=?, Kosten=?, ArbeitsteilauftragsPrioritaet=?   WHERE arbeitsteilauftragnr=? ";
	final static String insertnewArbeitsteilauftragString = "INSERT INTO t_arbeitsteilauftrag( Arbeitsteilauftragsbezeichnung,KundenlesbareForm, Erstellungsdatum, ArbeitsteilauftragStatus, Abnahmedatum, Fremdvergabe, Kosten, ArbeitsteilauftragsPrioritaet, fk_t_auftrag_AuftragsNr     ) VALUES (?, ?, curDate(), ?, ?, ?, ?, ?, ?)";

	public static ArrayList<Arbeitsteilauftrag> returnAllArbeitsteilauftraege() {

		/**
		 * @return Gibt alle Arbeitsteilauftraege in einer
		 *         ArrayList<Arbeitsteilauftrag> zurück, welche sich in der
		 *         Datenbank befinden
		 */

		ArrayList<Arbeitsteilauftrag> arbeitsteilauftragliste = new ArrayList<Arbeitsteilauftrag>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();

				// Ergebnistabelle erzeugen und abholen.

				ResultSet result = query
						.executeQuery(returnAllArbeitsteilauftraegeString);

				// Ergebnissätze durchfahren.
				while (result.next()) {

					int ataNr = result.getInt("arbeitsteilauftragnr");
					String ataBezeichnung = result
							.getString("Arbeitsteilauftragsbezeichnung");
					String kdnLesbareForm = result
							.getString("KundenlesbareForm");
					Date erstellungsdatum = result.getDate("Erstellungsdatum");
					String ataStatus = result
							.getString("ArbeitsteilauftragStatus");
					Date abnahmedatum = result.getDate("Abnahmedatum");
					String fremdvergabe = result.getString("Fremdvergabe");
					String kosten = result.getString("Kosten");
					String ataPriotitaet = result
							.getString("ArbeitsteilauftragsPrioritaet");

					Arbeitsteilauftrag temparbeitsteilauftrag = new Arbeitsteilauftrag(
							ataBezeichnung, kdnLesbareForm, erstellungsdatum,
							ataStatus, abnahmedatum, fremdvergabe, kosten,
							ataPriotitaet);

					temparbeitsteilauftrag.setAtaNummer(ataNr);

					arbeitsteilauftragliste.add(temparbeitsteilauftrag);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arbeitsteilauftragliste;
	}

	public static ArrayList<Arbeitsteilauftrag> returnAllArbeitsteilauftraegebyPrioriteat(
			String prio) {

		/**
		 * @param Übernimmt
		 *            Priorität einer Rechnung als String
		 * 
		 * @return Gibt alle Arbeitsteilauftraege in einer
		 *         ArrayList<Arbeitsteilauftrag> zurück, welche sich mit diesem
		 *         Status in der Datenbank befinden
		 */

		ArrayList<Arbeitsteilauftrag> arbeitsteilauftragliste = new ArrayList<Arbeitsteilauftrag>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Ergebnistabelle erzeugen und abholen.

				PreparedStatement ps = conn
						.prepareStatement(returnAllArbeitsteilauftragByPrioritaetString);

				// Erstes Fragezeichen durch "Status" Parameter ersetzen
				ps.setString(1, prio);

				// SQL ausführen.
				ResultSet result = ps.executeQuery();

				// Ergebnissätze durchfahren.
				while (result.next()) {
					int ataNr = result.getInt("arbeitsteilauftragnr");
					String ataBezeichnung = result
							.getString("Arbeitsteilauftragsbezeichnung");
					String kdnLesbareForm = result
							.getString("KundenlesbareForm");
					Date erstellungsdatum = result.getDate("Erstellungsdatum");
					String ataStatus = result
							.getString("ArbeitsteilauftragStatus");
					Date abnahmedatum = result.getDate("Abnahmedatum");
					String fremdvergabe = result.getString("Fremdvergabe");
					String kosten = result.getString("Kosten");
					String ataPriotitaet = result
							.getString("ArbeitsteilauftragsPrioritaet");

					Arbeitsteilauftrag temparbeitsteilauftrag = new Arbeitsteilauftrag(
							ataBezeichnung, kdnLesbareForm, erstellungsdatum,
							ataStatus, abnahmedatum, fremdvergabe, kosten,
							ataPriotitaet);

					temparbeitsteilauftrag.setAtaNummer(ataNr);

					arbeitsteilauftragliste.add(temparbeitsteilauftrag);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arbeitsteilauftragliste;
	}

	public static Auftragsmappe returnAllArbeitsteilauftraegebyAuftragsNr(
			int Auftragsnummer) {

		/**
		 * @param Übernimmt
		 *            Int Wert einer Auftragsnummer
		 * 
		 * @return Gibt alle Arbeitsteilauftraege in einer
		 *         ArrayList<Arbeitsteilauftrag> zurück, welche zu dieser
		 *         Auftragsnummer gehören
		 */

		Auftragsmappe newAuftragsmappe = new Auftragsmappe();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Ergebnistabelle erzeugen und abholen.

				PreparedStatement ps = conn
						.prepareStatement(returnAllArbeitsteilauftragByPrioritaetString);

				// Erstes Fragezeichen durch "Status" Parameter ersetzen
				ps.setInt(1, Auftragsnummer);

				// SQL ausführen.
				ResultSet result = ps.executeQuery();

				// Ergebnissätze durchfahren.
				while (result.next()) {
					int ataNr = result.getInt("arbeitsteilauftragnr");
					int auftragsNr = result.getInt("fk_t_auftrag_AuftragsNr");
					String ataBezeichnung = result
							.getString("Arbeitsteilauftragsbezeichnung");
					String kdnLesbareForm = result
							.getString("KundenlesbareForm");
					Date erstellungsdatum = result.getDate("Erstellungsdatum");
					String ataStatus = result
							.getString("ArbeitsteilauftragStatus");
					Date abnahmedatum = result.getDate("Abnahmedatum");
					String fremdvergabe = result.getString("Fremdvergabe");
					String kosten = result.getString("Kosten");
					String ataPriotitaet = result
							.getString("ArbeitsteilauftragsPrioritaet");

					Arbeitsteilauftrag temparbeitsteilauftrag = new Arbeitsteilauftrag(
							ataBezeichnung, kdnLesbareForm, erstellungsdatum,
							ataStatus, abnahmedatum, fremdvergabe, kosten,
							ataPriotitaet);

					temparbeitsteilauftrag.setAtaNummer(ataNr);
					temparbeitsteilauftrag.setAuftragsNr(auftragsNr);

					newAuftragsmappe.add(temparbeitsteilauftrag);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newAuftragsmappe;
	}

	public static boolean updateArbeitsteilauftrag(Arbeitsteilauftrag tempauftrag) {
		/**
		 * @param Übernimmt
		 *            einen Arbeitsteilauftrag und updatet diesen in der
		 *            Datenbank
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
						.prepareStatement(updateArbeitsteilauftragString);

				// Parameter durch übernommene Daten ersetzen
				preparedStatement.setString(1, tempauftrag.getAtaBezeichnung());
				preparedStatement.setString(2, tempauftrag.getKndLesbareForm());
				preparedStatement.setString(3, tempauftrag.getAtaStatus());
				preparedStatement.setDate(4, tempauftrag.getAbnahmedatum());
				preparedStatement.setString(5, tempauftrag.getFremdvergabe());
				preparedStatement.setString(6, tempauftrag.getKosten());
				preparedStatement.setString(7, tempauftrag.getAtaPriorität());
				preparedStatement.setInt(8, tempauftrag.getAtaNummer());

				// SQL ausführen
				preparedStatement.executeUpdate();

				done = true;

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return done;
	}

	public static boolean insertnewArbeitsteilauftrag(Arbeitsteilauftrag tempauftrag) {

		/**
		 * @param Übernimmt
		 *            einen Arbeitsteilauftrag und fügt es in die Datenbank ein
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
						.prepareStatement(insertnewArbeitsteilauftragString);

				// Parameter durch übernommene Daten ersetzen
				preparedStatement.setString(1, tempauftrag.getAtaBezeichnung());
				
				preparedStatement.setString(1, tempauftrag.getAtaBezeichnung());
				preparedStatement.setString(2, tempauftrag.getKndLesbareForm());
				preparedStatement.setString(3, tempauftrag.getAtaStatus());
				preparedStatement.setDate(4, tempauftrag.getAbnahmedatum());
				preparedStatement.setString(5, tempauftrag.getFremdvergabe());
				preparedStatement.setString(6, tempauftrag.getKosten());
				preparedStatement.setString(7, tempauftrag.getAtaPriorität());
				preparedStatement.setInt(8, tempauftrag.getAtaNummer());

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
