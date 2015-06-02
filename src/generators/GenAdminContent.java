package generators;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_Nutzer;
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
		
		DAO_Nutzer daoNutzer = new DAO_Nutzer();
		final ArrayList<Nutzer> users = daoNutzer.returnAllNutzer();
		
		// DefaultTableModel erzeugen
        final DefaultTableModel modelUsers = new DefaultTableModel();
        modelUsers.addColumn("Username");
        modelUsers.addColumn("Name");
        modelUsers.addColumn("Vorname");
        modelUsers.addColumn("Nutzerrolle");
        
        // Alle Benutzer in Model eintragen
        for(int i=0;i<users.size();i++){
        	
        	// Nutzerinformationen auslesen
        	Nutzer user = new Nutzer("user5", "", "Mustermann", "Maxeline", "Werkstatt");
        	user = users.get(i);
        	String[] userdata = user.getNutzerInfo();
        	
        	// Nutzerinformationen eintragen
            Vector tableRow = new Vector();
            tableRow.add(userdata[0]);
            tableRow.add(userdata[1]);
            tableRow.add(userdata[2]);
            tableRow.add(userdata[3]);
            modelUsers.addRow(tableRow);
            
        }
        
        // JTable erzeugen 
        final JTable tableUsers = new JTable(modelUsers) {
            public boolean isCellEditable(int x, int y) {
                return false;
            }
        };
        
        // ActionListener für JTable erzeugen
        tableUsers.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(final MouseEvent e) {
        		//Doppelklick auf einen Tabelleneintrag
        		if (e.getClickCount() == 2) {
	    			DlgNutzer dlgNutzer = new DlgNutzer();
	    			dlgNutzer.editNutzer(users.get(tableUsers.getSelectedRow()));
        		}
        	}
        });
        
        // Eigenschaften setzen
        
        tableUsers.addRowSelectionInterval(1, 2);
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
		
		// JButton "Benutzer editieren" erzeugen
		JButton btnEditNutzer = new JButton();
		btnEditNutzer.setText("Benutzer editieren");
		btnEditNutzer.addActionListener(new CtrlAdminContent(users.get(0)));
		
		// JButton "Benutzer löschen" erzeugen
		JButton btnDeleteNutzer = new JButton();
		btnDeleteNutzer.setText("Benutzer löschen");
		btnDeleteNutzer.addActionListener(new CtrlAdminContent(users.get(0)));
		
		// JButton "Benutzer deaktivieren" erzeugen
		JButton btnDeactivateNutzer = new JButton();
		btnDeactivateNutzer.setText("Benutzer deaktivieren");
		btnDeactivateNutzer.addActionListener(new CtrlAdminContent(users.get(0)));
		
		// PanelTop erzeugen
		JPanel panelTop = new JPanel();

		// JButton's hinzufügen
		panelTop.add(btnNewNutzer);
		panelTop.add(btnEditNutzer);
		panelTop.add(btnDeleteNutzer);
		panelTop.add(btnDeactivateNutzer);
		
		// Eigenschaften setzen
		panelTop.setLayout((new BoxLayout (panelTop, BoxLayout.X_AXIS)));
		panelTop.setBorder(BorderFactory.createTitledBorder("Aktionsmöglichkeiten (Benutzer)"));
		panelTop.setPreferredSize(new Dimension(400, 60));
		
				
		panel.setLayout(new BorderLayout());
		panel.add(panelTop, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		
		return panel;
	}
	
}
