package DAO;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import objects.Nutzer;

/**
 * @author treichert
 *
 */

public class DAOJTable {

	public static JTable createTableUsers(ArrayList<Nutzer> users) {
		
		// DefaultTableModel erzeugen
		DefaultTableModel modelUsers = new DefaultTableModel();

		if (users.size() >= 1) {
			modelUsers = fillTableUsers(users );
		}

		// JTable erzeugen
		JTable tableUsers = new JTable(modelUsers) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int x, int y) {
				return false;
			}
		};

		return tableUsers;
	}

	public static DefaultTableModel fillTableUsers(ArrayList<Nutzer> users) {
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Username");
		model.addColumn("Name");
		model.addColumn("Vorname");
		model.addColumn("Nutzerrolle");
		model.addColumn("Status");
		
		for (Nutzer n : users) {
			model.addRow(n.getNutzerInfo());
		}

		return model;
	}

}
