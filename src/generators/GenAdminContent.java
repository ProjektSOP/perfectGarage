package generators;

/**
 * @author treichert
 *
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
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
import javax.swing.table.DefaultTableModel;

import DAO.DAONutzer;
import dialogs.DlgNutzer;
import objects.Nutzer;

public class GenAdminContent {
	
	JFrame frame;
	
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
		
		DAONutzer daoNutzer = new DAONutzer();
		final ArrayList<Nutzer> users = daoNutzer.returnAllNutzerWithoutAdmin();
		
		//users.clear();
		
		// DefaultTableModel erzeugen
        DefaultTableModel modelUsers = new DefaultTableModel();
        modelUsers.addColumn("Username");
        modelUsers.addColumn("Name");
        modelUsers.addColumn("Vorname");
        modelUsers.addColumn("Nutzerrolle");
        modelUsers.addColumn("Status");
		
		if(users.size() >= 1){
			modelUsers = createUserTable(users, modelUsers);			
		}
		
        // JTable erzeugen 
        final JTable tableUsers = new JTable(modelUsers) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int x, int y) {
                return false;
            }
        };
        
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
		btnNewNutzer.addActionListener(new CtrlAdminContent(new Nutzer("","","","","","")));
		
		// JButton "Benutzer editieren" erzeugen
		final JButton btnEditNutzer = new JButton();
		btnEditNutzer.setText("Benutzer editieren");
		btnEditNutzer.setEnabled(false);
		
		// JButton "Benutzer löschen" erzeugen
		final JButton btnDeleteNutzer = new JButton();
		btnDeleteNutzer.setText("Benutzer löschen");
		btnDeleteNutzer.setEnabled(false);
		
		// JButton "Benutzer deaktivieren" erzeugen
		final JButton btnDeactivateNutzer = new JButton();
		btnDeactivateNutzer.setText("Benutzer deaktivieren");
		btnDeactivateNutzer.setEnabled(false);
		
		// JButton "Passwort zurücksetzen"
		final JButton btnSetPassword = new JButton();
		btnSetPassword.setText("Passwort zurücksetzen");
		btnSetPassword.setEnabled(false);
		
		// JButton "Passwort des Administrators ändern"
		final JButton btnSetAdminPassword = new JButton();
		btnSetAdminPassword.setText("Passwort des Administrators ändern");
		
        // ActionListener für JTable erzeugen
        tableUsers.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(final MouseEvent e) {
        		// Einfacher Klick auf einen Tabelleneintrag
        		if (e.getClickCount() == 1) {
        			if(users.size() >= 1){
        				btnEditNutzer.setEnabled(true);
        				btnEditNutzer.addActionListener(new CtrlAdminContent(users.get(tableUsers.getSelectedRow())));
        				btnDeleteNutzer.setEnabled(true);
        				btnDeleteNutzer.addActionListener(new CtrlAdminContent(users.get(tableUsers.getSelectedRow())));
        				btnDeactivateNutzer.setEnabled(true);
        				btnDeactivateNutzer.addActionListener(new CtrlAdminContent(users.get(tableUsers.getSelectedRow())));
        				btnSetPassword.setEnabled(true);
        			}
        		}
        		
        		// Doppelklick auf einen Tabelleneintrag
        		if (e.getClickCount() == 2) {
	    			DlgNutzer dlgNutzer = new DlgNutzer();
	    			dlgNutzer.editNutzer(users.get(tableUsers.getSelectedRow()));
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
		panelTop.add(btnSetPassword);
		panelTop.add(btnSetAdminPassword);
		
		// Eigenschaften setzen
		panelTop.setLayout (new FlowLayout (FlowLayout.LEFT, 5, 5));
		panelTop.setBorder(BorderFactory.createTitledBorder("Aktionsmöglichkeiten"));
		panelTop.setPreferredSize(new Dimension(400, 60));
		
				
		panel.setLayout(new BorderLayout());
		panel.add(panelTop, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		
		
		return panel;
	}
	
	private DefaultTableModel createUserTable(ArrayList<Nutzer> users, DefaultTableModel modelUsers){
		
		for( Nutzer n : users ){
			modelUsers.addRow(n.getNutzerInfo());
        }
		
		return modelUsers;
	}
	
}
