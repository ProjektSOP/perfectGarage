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
		 *         ArrayList<Fahrzeug> zur�ck, welche sich in der Datenbank
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

				// Ergebniss�tze durchfahren.
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
		 * @param Ben�tigt
		 *            Kundenummer, f�r wen alle Fahrzeuge gesucht werden soll
		 * @return Gibt alle Fahrzeuge ink. aller Informationen in einer
		 *         ArrayList<Fahrzeug> zur�ck, welche zu der Kundennummer
		 *         geh�ren
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

				// SQL ausf�hren.
				ResultSet result = ps.executeQuery();

				// Ergebniss�tze durchfahren.
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
		 * @param Ben�tigt
		 *            FIN, f�r wen alle Fahrzeuge gesucht werden soll
		 * @return Gibt ein FahrzeugObjekt zur�ck, das alle Infos zum Fahrzeug
		 *         mit der �bergebenen FIN enth�lt
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

				// SQL ausf�hren.
				ResultSet result = ps.executeQuery();

				// Ergebniss�tze durchfahren.
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
		 * @param �bernimmt
		 *            ein Fahrzeugobjekt und die FIN(�ndert sich niemals!)
		 *            �ndert alle darin neuen Werte in der Datenbank
		 * @return gibt True / False zur�ck, ob der Updatevorgang erfolgreich
		 *         war
		 * @me Update mit InnerJoin �ber 3 Tabellen ftw
		 */

		boolean done = false;

		Connection conn = MySQLConnection.getInstance();

		if (conn != null) {

			try {
				// Insert-Statement erzeugen (Fragezeichen werden sp�ter
				// ersetzt).

				PreparedStatement preparedStatement = conn
						.prepareStatement(updateFahrzeugString);

				// Parameter durch �bernommene Daten ersetzen
				preparedStatement.setInt(1, neuesFahrzeug.getKundenNr());
				preparedStatement.setString(2, neuesFahrzeug.getKundenname());
				preparedStatement.setString(3, neuesFahrzeug.getHersteller());
				preparedStatement.setString(4, neuesFahrzeug.getModell());
				preparedStatement.setString(5, neuesFahrzeug.getFarbe());
				preparedStatement.setString(6, fin);

				// SQL ausf�hren
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
		 * @param �bernimmt
		 *            ein Fahrzeugsobjekt und f�gt es in die Datenbank ein
		 * 
		 *            Dazu wird erst gepr�ft, ob der KFZ Typ bereits in der
		 *            Tabelle t_kfztyp vorhanden ist wenn ja, wird dieser
		 *            KfZTypNr �bernommen wenn nein, wird dieser neu hinzugef�gt
		 * 
		 *            Danach wird das KFZ in die Tabelle t_kfz eingetragen und
		 *            mit dem Kunden verkn�pft
		 * 
		 * @return gibt ein True / False zur�ck wenn das Einf�gen erfolgreich
		 *         war
		 * 
		 */
		// Pr�fen, ob KFZ_Typ bereits vorhanden

		Connection conn = MySQLConnection.getInstance();
		boolean done = false;
		int kfztypnr = 0;
		if (conn != null) {

			try {

				PreparedStatement ps = conn.prepareStatement(getkfztypNrString);

				// Erstes Fragezeichen durch "Status" Parameter ersetzen
				ps.setString(1, neuesFahrzug.getHersteller());
				ps.setString(2, neuesFahrzug.getModell());

				// SQL ausf�hren.
				ResultSet result = ps.executeQuery();

				// Ergebniss�tze durchfahren.
				while (result.next()) {

					if (!result.next()) {

						// Wenn das ResultSet der Abfrage leer ist, ist f�r die
						// Daten kein kfztypnr in der Tabelle vorhanden und
						// daher m�ssen nun die Daten des Fahrzeugs neu in die
						// Datenbank geschrieben werden

						try {

							PreparedStatement preparedStatement = conn
									.prepareStatement(insertnewFahrzeugKFZTypString);

							preparedStatement.setString(1,
									neuesFahrzug.getHersteller());
							preparedStatement.setString(2,
									neuesFahrzug.getModell());

							// SQL ausf�hren
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
				// Nun m�ssen noch die Daten des neuen Fahrzeuges in die Tabelle t_kfz geschrieben werden

				PreparedStatement preparedStatement = conn
						.prepareStatement(insertnewFahrzeugKFZString);

				// Parameter durch �bernommene Daten ersetzen
				preparedStatement.setString(1, neuesFahrzug.getFIN());
				preparedStatement.setString(2, neuesFahrzug.getFarbe());
				preparedStatement.setInt(3, neuesFahrzug.getKundenNr());
				preparedStatement.setInt(4, kfztypnr);

				// SQL ausf�hren
				preparedStatement.executeUpdate();

				done = true;

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return done;
	}

}
