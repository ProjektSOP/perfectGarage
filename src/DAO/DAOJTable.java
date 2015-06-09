package DAO;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import objects.Kunde;
import objects.Nutzer;

/**
 * @author treichert
 *
 */

public class DAOJTable {

	public static JTable createTableUsers(ArrayList<Nutzer> list) {
		
		// DefaultTableModel erzeugen
		DefaultTableModel model = new DefaultTableModel();

		if (list.size() >= 1) {
			model = fillTableUsers(list);
		}

		// JTable erzeugen
		JTable table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int x, int y) {
				return false;
			}
		};

		return table;
	}

	public static DefaultTableModel fillTableUsers(ArrayList<Nutzer> list) {
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Username");
		model.addColumn("Name");
		model.addColumn("Vorname");
		model.addColumn("Nutzerrolle");
		model.addColumn("Status");
		model.addColumn("Geloescht am");
		
		for (Nutzer n : list) {
			model.addRow(n.getNutzerInfo());
		}

		return model;
	}

	public static JTable createTableCustomers(ArrayList<Kunde> list) {
		
		// DefaultTableModel erzeugen
		DefaultTableModel model = new DefaultTableModel();

		if (list.size() >= 1) {
			model = fillTableCustomers(list);
		}

		// JTable erzeugen
		JTable table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int x, int y) {
				return false;
			}
		};

		return table;
	}
	
	public static DefaultTableModel fillTableCustomers(ArrayList<Kunde> list) {
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("KundeNr");
		model.addColumn("Name");
		model.addColumn("Vorname");
		model.addColumn("Strasse");
		model.addColumn("PLZ");
		model.addColumn("Ort");
		model.addColumn("Kunde seit");
		model.addColumn("Telefon");
		model.addColumn("Telefax");
		model.addColumn("Handy");
		model.addColumn("E-Mail");
		
		for (Kunde n : list) {
			model.addRow(n.getKundeInfo());
		}

		return model;
	}
	
	public static JTable createTableCars() {
		
		// DefaultTableModel erzeugen
		DefaultTableModel model = new DefaultTableModel();

		model = fillTableCars();

		// JTable erzeugen
		JTable table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int x, int y) {
				return false;
			}
		};

		return table;
	}
	
	public static DefaultTableModel fillTableCars() {
		
		DefaultTableModel model = new DefaultTableModel();
        model.addColumn("FIN");
        model.addColumn("Hersteller");
        model.addColumn("Modell");
        model.addColumn("Farbe");

		return model;
	}
	
}
