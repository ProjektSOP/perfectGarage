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

import dialogs.DlgNutzer;
import frames.CtrlMain;
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
	
	public JPanel showAllUsers(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(this.getContentSize());
		
		final ArrayList<Nutzer> users = new ArrayList<Nutzer>();
		//
		Nutzer user1 = new Nutzer();
		user1.createNutzer("user1", "", "Tester", "Theo", "Admin");
		users.add(user1);
		Nutzer user2 = new Nutzer();
		user2.createNutzer("user2", "", "Tester", "Theoline", "Service");
		users.add(user2);
		Nutzer user3 = new Nutzer();
		user3.createNutzer("user3", "", "Mustermann", "Max", "Meister");
		users.add(user3);
		Nutzer user4 = new Nutzer();
		user4.createNutzer("user4", "", "Mustermann", "Maxeline", "Werkstatt");
		users.add(user4);
		//
		
		// JTable mit Nutzerinformationen füllen
        final DefaultTableModel modelUsers = new DefaultTableModel();
        modelUsers.addColumn("Username");
        modelUsers.addColumn("Name");
        modelUsers.addColumn("Vorname");
        modelUsers.addColumn("Nutzerrolle");
        
        for(int i=0;i<users.size();i++){
        	// Nutzerinformationen auslesen
        	Nutzer user = new Nutzer();
        	user = users.get(i);
        	String[] userdata = user.getNutzerInfo();
        	// Nutzerinformationen in die Tabelle eintragen
            Vector tableRow = new Vector();
            tableRow.add(userdata[0]);
            tableRow.add(userdata[1]);
            tableRow.add(userdata[2]);
            tableRow.add(userdata[3]);
            modelUsers.addRow(tableRow);
        }
        
        final JTable tableUsers = new JTable(modelUsers) {
            public boolean isCellEditable(int x, int y) {
                return false;
            }
        };
        
        tableUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tableUsers.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(final MouseEvent e) {
        		//Doppelklick auf einen Tabelleneintrag
        		if (e.getClickCount() == 2) {
	    			DlgNutzer dlgNutzer = new DlgNutzer();
	    			dlgNutzer.editNutzer(users.get(tableUsers.getSelectedRow()));
        		}
        	}
        });

        //System.out.println(modelUsers.getValueAt(0,1));
        
        JScrollPane scrollTable = new JScrollPane(tableUsers);
		
		scrollTable.setPreferredSize(new Dimension(
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 210	));
		
		scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(BorderFactory.createTitledBorder("Suchergebnis"));
		panelCenter.add(scrollTable);
		
		JButton btnNewNutzer = new JButton();
		btnNewNutzer.setText("Neuer Benutzer");
		
		JButton btnEditNutzer = new JButton();
		btnEditNutzer.setText("Benutzer editieren");
		btnEditNutzer.addActionListener(new CtrlAdminContent(users.get(0)));
		
		JPanel panelTop = new JPanel();
		panelTop.add(btnNewNutzer);
		panelTop.add(btnEditNutzer);
		panelTop.setLayout((new BoxLayout (panelTop, BoxLayout.X_AXIS)));
		panelTop.setBorder(BorderFactory.createTitledBorder("Aktionsmöglichkeiten (Benutzer)"));
		panelTop.setPreferredSize(new Dimension(400, 100));
		
		panel.setLayout(new BorderLayout());
		panel.add(panelTop, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		
		return panel;
	}
	
}
