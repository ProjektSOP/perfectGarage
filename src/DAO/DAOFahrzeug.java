package DAO;

/**
 * 
 * @author mrothe
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mySQLConnector.MySQLConnection;
import objects.Fahrzeug;

public class DAOFahrzeug {

	final static String returnAllFahrzeugInfosString = "Select kundennr, name, fin, hersteller, Modellcode, farbe from (t_kunde inner join t_kfz on fk_t_kunde_kundennr = kundennr) inner join t_kfztyp on fk_t_kfztyp_kfztypnr = kfztypnr";
	final static String returnAllFahrzeugInfosbyKundenNrString = "Select kundennr, name, fin, hersteller, Modellcode, farbe from (t_kunde inner join t_kfz on fk_t_kunde_kundennr = kundennr) inner join t_kfztyp on fk_t_kfztyp_kfztypnr = kfztypnr where kundennr =?";
	final static String returnAllFahrzeugInfosbyFINString = "Select kundennr, name, fin, hersteller, Modellcode, farbe from (t_kunde inner join t_kfz on fk_t_kunde_kundennr = kundennr) inner join t_kfztyp on fk_t_kfztyp_kfztypnr = kfztypnr where fin =?";
	final static String updateFahrzeugString = "UPDATE t_kunde INNER JOIN t_kfz ON fk_t_kunde_kundennr = kundennr INNER JOIN t_kfztyp ON fk_t_kfztyp_kfztypnr = kfztypnr SET kundennummer=?, name=?, hersteller=?, Modellcode=?, farbe=? WHERE fin = ?";

	final static String insertnewFahrzeugKFZTypString = "INSERT INTO t_kfztyp( Hersteller, Modellcode) VALUES (?, ?)";
	final static String getkfztypNrString = "Select kfztypnr from t_kfztyp where Hersteller=? AND Modellcode =?";
	final static String insertnewFahrzeugKFZString = "INSERT INTO t_kfz( fin, farbe, fk_t_kunde_kundennummer, fk_t_kfztyp_kfztypnr) VALUES (?, ?, ?, ?)";

	public static ArrayList<Fahrzeug> returnAllFahrzeugInfos() {

		/**
		 * @return Gibt alle Fahrzeuge ink. aller Informationen in einer
		 *         ArrayList<Fahrzeug> zurück, welche sich in der Datenbank
		 *         befinden
		 */

		ArrayList<Fahrzeug> fahrzeugliste = new ArrayList<Fahrzeug>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();

				// Ergebnistabelle erzeugen und abholen.
				ResultSet result = query
						.executeQuery(returnAllFahrzeugInfosString);

				// Ergebnissätze durchfahren.
				while (result.next()) {

					int kundennr = result.getInt("kundennr");
					String name = result.getString("name");
					String fin = result.getString("fin");
					String hersteller = result.getString("hersteller");
					String Modellcode = result.getString("Modellcode");
					String farbe = result.getString("farbe");

					Fahrzeug tempfahrzeug = new Fahrzeug(kundennr, fin,
							hersteller, Modellcode, farbe);

					/**
					 * Extra setzen des Kundennamens beim Fahrzeug, da im
					 * Konstruktur nicht gewollt
					 */

					tempfahrzeug.setKundenname(name);

					fahrzeugliste.add(tempfahrzeug);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fahrzeugliste;
	}

	public static ArrayList<Fahrzeug> returnAllFahrzeugInfosbyKundenNr(int kundennummer) {

		/**
		 * @param Benötigt
		 *            Kundenummer, für wen alle Fahrzeuge gesucht werden soll
		 * @return Gibt alle Fahrzeuge ink. aller Informationen in einer
		 *         ArrayList<Fahrzeug> zurück, welche zu der Kundennummer
		 *         gehören
		 */

		ArrayList<Fahrzeug> fahrzeugliste = new ArrayList<Fahrzeug>();

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Ergebnistabelle erzeugen und abholen.

				PreparedStatement ps = conn
						.prepareStatement(returnAllFahrzeugInfosbyKundenNrString);

				// Erstes Fragezeichen durch "Status" Parameter ersetzen
				ps.setInt(1, kundennummer);

				// SQL ausführen.
				ResultSet result = ps.executeQuery();

				// Ergebnissätze durchfahren.
				while (result.next()) {

					int kundennr = result.getInt("kundennr");
					String name = result.getString("name");
					String fin = result.getString("fin");
					String hersteller = result.getString("hersteller");
					String Modellcode = result.getString("Modellcode");
					String farbe = result.getString("farbe");

					Fahrzeug tempfahrzeug = new Fahrzeug(kundennr, fin,
							hersteller, Modellcode, farbe);

					/**
					 * Extra setzen des Kundennamens beim Fahrzeug, da im
					 * Konstruktur nicht gewollt
					 */

					tempfahrzeug.setKundenname(name);

					fahrzeugliste.add(tempfahrzeug);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fahrzeugliste;
	}

	public Fahrzeug returnAllFahrzeugInfosbyFIN(int tempfin) {

		/**
		 * @param Benötigt
		 *            FIN, für wen alle Fahrzeuge gesucht werden soll
		 * @return Gibt ein FahrzeugObjekt zurück, das alle Infos zum Fahrzeug
		 *         mit der übergebenen FIN enthält
		 */

		Fahrzeug tempfahrzeug = null;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Ergebnistabelle erzeugen und abholen.

				PreparedStatement ps = conn
						.prepareStatement(returnAllFahrzeugInfosbyFINString);

				// Erstes Fragezeichen durch "Status" Parameter ersetzen
				ps.setInt(1, tempfin);

				// SQL ausführen.
				ResultSet result = ps.executeQuery();

				// Ergebnissätze durchfahren.
				while (result.next()) {

					int kundennr = result.getInt("kundennr");
					String name = result.getString("name");
					String fin = result.getString("fin");
					String hersteller = result.getString("hersteller");
					String Modellcode = result.getString("Modellcode");
					String farbe = result.getString("farbe");

					tempfahrzeug = new Fahrzeug(kundennr, fin, hersteller,
							Modellcode, farbe);

					/**
					 * Extra setzen des Kundennamens beim Fahrzeug, da im
					 * Konstruktur nicht gewollt
					 */

					tempfahrzeug.setKundenname(name);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tempfahrzeug;
	}

	public boolean updateFahrzeug(Fahrzeug neuesFahrzeug, String fin) {

		/**
		 * @param Übernimmt
		 *            ein Fahrzeugobjekt und die FIN(ändert sich niemals!)
		 *            ändert alle darin neuen Werte in der Datenbank
		 * @return gibt True / False zurück, ob der Updatevorgang erfolgreich
		 *         war
		 * @me Update mit InnerJoin über 3 Tabellen ftw
		 */

		boolean done = false;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Insert-Statement erzeugen (Fragezeichen werden später
				// ersetzt).

				PreparedStatement preparedStatement = conn
						.prepareStatement(updateFahrzeugString);

				// Parameter durch übernommene Daten ersetzen
				preparedStatement.setInt(1, neuesFahrzeug.getKundenNr());
				preparedStatement.setString(2, neuesFahrzeug.getKundenname());
				preparedStatement.setString(3, neuesFahrzeug.getHersteller());
				preparedStatement.setString(4, neuesFahrzeug.getModell());
				preparedStatement.setString(5, neuesFahrzeug.getFarbe());
				preparedStatement.setString(6, fin);

				// SQL ausführen
				preparedStatement.executeUpdate();

				done = true;

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return done;
	}

	public boolean insertnewFahrzeug(Fahrzeug neuesFahrzug) {

		/**
		 * @param Übernimmt
		 *            ein Fahrzeugsobjekt und fügt es in die Datenbank ein
		 * 
		 *            Dazu wird erst geprüft, ob der KFZ Typ bereits in der
		 *            Tabelle t_kfztyp vorhanden ist wenn ja, wird dieser
		 *            KfZTypNr übernommen wenn nein, wird dieser neu hinzugefügt
		 * 
		 *            Danach wird das KFZ in die Tabelle t_kfz eingetragen und
		 *            mit dem Kunden verknüpft
		 * 
		 * @return gibt ein True / False zurück wenn das Einfügen erfolgreich
		 *         war
		 * 
		 */
		// Prüfen, ob KFZ_Typ bereits vorhanden

		Connection conn = MySQLConnection.getInstance();
		boolean done = false;
		int kfztypnr = 0;
		if (conn != null) {

			try {

				PreparedStatement ps = conn.prepareStatement(getkfztypNrString);

				// Erstes Fragezeichen durch "Status" Parameter ersetzen
				ps.setString(1, neuesFahrzug.getHersteller());
				ps.setString(2, neuesFahrzug.getModell());

				// SQL ausführen.
				ResultSet result = ps.executeQuery();

				// Ergebnissätze durchfahren.
				while (result.next()) {

					if (!result.next()) {

						// Wenn das ResultSet der Abfrage leer ist, ist für die
						// Daten kein kfztypnr in der Tabelle vorhanden und
						// daher müssen nun die Daten des Fahrzeugs neu in die
						// Datenbank geschrieben werden

						try {

							PreparedStatement preparedStatement = conn
									.prepareStatement(insertnewFahrzeugKFZTypString);

							preparedStatement.setString(1,
									neuesFahrzug.getHersteller());
							preparedStatement.setString(2,
									neuesFahrzug.getModell());

							// SQL ausführen
							preparedStatement.executeUpdate();

							// Nach erfolgreichen Eintragen in die Tabelle muss
							// nun noch die KfZTypNr ermittelt werden

							try {
								PreparedStatement ps2 = conn
										.prepareStatement(getkfztypNrString);

								ps2.setString(1, neuesFahrzug.getHersteller());
								ps2.setString(2, neuesFahrzug.getModell());

								ResultSet result2 = ps.executeQuery();

								while (result2.next()) {
									kfztypnr = result2.getInt("kfztypnr");
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}

						} catch (SQLException e) {
							e.printStackTrace();
						}

					} else {		// Wenn das ResultSet aus der ersten Abfrage nicht leer ist

						kfztypnr = result.getInt("kfztypnr");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {

			try {
				// Nun müssen noch die Daten des neuen Fahrzeuges in die Tabelle t_kfz geschrieben werden

				PreparedStatement preparedStatement = conn
						.prepareStatement(insertnewFahrzeugKFZString);

				// Parameter durch übernommene Daten ersetzen
				preparedStatement.setString(1, neuesFahrzug.getFIN());
				preparedStatement.setString(2, neuesFahrzug.getFarbe());
				preparedStatement.setInt(3, neuesFahrzug.getKundenNr());
				preparedStatement.setInt(4, kfztypnr);

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
