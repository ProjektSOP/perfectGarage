package generators;

/**
 * @author treichert
 *
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import objects.Nutzer;
import DAO.DAOJTable;
import DAO.DAONutzer;
import dialogs.DlgNutzer;

public class GenAdminContent {
	
	private JFrame frame;
	
	public GenAdminContent(JFrame frame){
		this.frame = frame;
	}
	
	private Dimension getContentSize(){
		
		Dimension frameSize = this.frame.getContentPane().getSize();
		int frameWidth = (int)frameSize.getWidth();
		int frameHeight = (int)frameSize.getHeight();
		
		return new Dimension(frameWidth, frameHeight);
	}
	
	public JPanel showAdminPanel(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(this.getContentSize());
		
		// ArrayList erzeugen
		final ArrayList<Nutzer> users = DAONutzer.returnAllNutzerWithoutAdmin();
		
		// JTable erzeugen
		final JTable tableUsers = DAOJTable.createTableUsers(users);
        
        // Eigenschaften setzen
        tableUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // JScrollPane erzeugen
        JScrollPane scrollTable = new JScrollPane(tableUsers);
		
		scrollTable.setPreferredSize(new Dimension(
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 10,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 170	));
		
		scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		// PanelCenter erzeugen
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(BorderFactory.createTitledBorder("Suchergebnis"));
		panelCenter.add(scrollTable);
		
		
		// JButton "Neuer Benutzer" erzeugen
		JButton btnNewNutzer = new JButton();
		btnNewNutzer.setText("Neuer Benutzer");
		final ActionListener adminContent = new CtrlAdminContent(tableUsers);
		btnNewNutzer.addActionListener(adminContent);
		
		// JButton "Benutzer editieren" erzeugen
		final JButton btnEditNutzer = new JButton();
		btnEditNutzer.setText("Benutzer editieren");
		btnEditNutzer.addActionListener(adminContent);
		btnEditNutzer.setEnabled(false);
		
		// JButton "Benutzer löschen" erzeugen
		final JButton btnDeleteNutzer = new JButton();
		btnDeleteNutzer.setText("Benutzer löschen");
		btnDeleteNutzer.addActionListener(adminContent);
		btnDeleteNutzer.setEnabled(false);
		
		// JButton "Benutzer deaktivieren" erzeugen
		final JButton btnDeactivateNutzer = new JButton();
		btnDeactivateNutzer.setText("Benutzerstatus ändern");
		btnDeactivateNutzer.addActionListener(adminContent);
		btnDeactivateNutzer.setEnabled(false);
		
		// JButton "Benutzerpasswort zurücksetzen" erzeugen
		final JButton btnChangePassword = new JButton();
		btnChangePassword.setText("Benutzerpasswort zurücksetzen");
		btnChangePassword.addActionListener(adminContent);
		btnChangePassword.setEnabled(false);		
		
        // ActionListener für JTable erzeugen
        tableUsers.addMouseListener(new MouseAdapter() {

			public void mouseClicked(final MouseEvent e) {
        		// Einfacher Klick auf einen Tabelleneintrag
        		if (e.getClickCount() == 1) {
        			if(users.size() >= 1){
        				btnEditNutzer.setEnabled(true);
        				btnDeleteNutzer.setEnabled(true);
        				btnDeactivateNutzer.setEnabled(true);
        				btnChangePassword.setEnabled(true);
        			}
        		}
        		
        		// Doppelklick auf einen Tabelleneintrag
        		if (e.getClickCount() == 2) {
	    			DlgNutzer dlgNutzer = new DlgNutzer();
	    			dlgNutzer.editNutzerInt(tableUsers, tableUsers.getSelectedRow());
        		}
        	}
        });
		
        
        // PanelTop erzeugen
		JPanel panelTop = new JPanel();

		// JButton's hinzufügen
		panelTop.add(btnNewNutzer);
		panelTop.add(btnEditNutzer);
		panelTop.add(btnDeleteNutzer);
		panelTop.add(btnDeactivateNutzer);
		panelTop.add(btnChangePassword);
		
		// Eigenschaften setzen
		panelTop.setLayout (new FlowLayout (FlowLayout.LEFT, 5, 5));
		panelTop.setBorder(BorderFactory.createTitledBorder("Aktionsmöglichkeiten"));
		panelTop.setPreferredSize(new Dimension(400, 60));
		
				
		panel.setLayout(new BorderLayout());
		panel.add(panelTop, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		
		
		return panel;
	}
	
}
