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
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection {

	public MySQLConnection() {
	}

	private static Connection conn = null;
	private static boolean isConnected = false;

	public static boolean connect() {
		if (!isConnected) {
			try {

				// Properties auslesen
				InputStream in = MySQLConnection.class
						.getResourceAsStream("settings.properties");
				Properties properties = new Properties();
				try {
					properties.load(in);

				} catch (IOException e) {
					// TO-DO Hier sollte noch ein Fehlerlog eingebaut werden
					System.out
							.println("Fehler beim Einlesen der Properties datei "
									+ e.getMessage());
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
				conn = DriverManager.getConnection("jdbc:mysql://" + dbHost
						+ ":" + dbPort + "/" + dbName + "?" + "user=" + dbUser
						+ "&" + "password=" + dbPassword);

				isConnected = true;

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
		if (conn == null)
			new MySQLConnection();
		return conn;
	}

	public static void schliesseVerbindung() {

		try {
			conn.close();
		}

		catch (SQLException sqle) {
			System.out.println(sqle.toString());
		}
	}

}
