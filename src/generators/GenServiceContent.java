package generators;

/**
 * @author treichert
 *
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import objects.Kunde;
import DAO.DAOJTable;
import DAO.DAOKunde;

public class GenServiceContent {

	private JFrame frame;
	
	public GenServiceContent(JFrame frame){
		this.frame = frame;
	}
	
	private Dimension getContentSize(){
		
		Dimension frameSize = this.frame.getContentPane().getSize();
		int frameWidth = (int)frameSize.getWidth();
		int frameHeight = (int)frameSize.getHeight();
		
		return new Dimension(frameWidth, frameHeight);
	}
	
	public JPanel showServicePanel(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(this.getContentSize());
		panel.setLayout (new FlowLayout());
		
		// Erstelle Registrierkarten.
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 10,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 100	));
	      
		// Erstelle Registrierkarte.
		JPanel tabbedPanel = new JPanel ();
		// Hinzufügen von Panel zu Registrierkarte.
		tabbedPane.addTab ("Kunden- und Fahrzeugverwaltung", tabbedPanel);

		// Hinzufügen des Labels.
		tabbedPanel.add (this.createCustomerCarsPanel());

		// Erstelle Registrierkarte.
		tabbedPanel = new JPanel ();
		// Hinzufügen von Panel zu Registrierkarte.
		tabbedPane.addTab ("Auftragsverwaltung", tabbedPanel);
		
		// Hinzufügen des Labels.
		tabbedPanel.add (this.createTaskPanel());
		
		// Erstelle Registrierkarte.
		tabbedPanel = new JPanel ();
		// Hinzufügen von Panel zu Registrierkarte.
		tabbedPane.addTab ("Rechnungsverwaltung", tabbedPanel);
		
		// Hinzufügen des Labels.
		tabbedPanel.add (this.createBillingPanel());
		
		// Hinzufügen zum Fenster.
		panel.add(tabbedPane);
		
		return panel;
	}
	
	private JPanel createCustomerCarsPanel(){
		JPanel panel = new JPanel();
		panel.setLayout (new BorderLayout());
		
		// Erstelle JPanel.
		JPanel panelTop = new JPanel();
		
		// Eigenschaften setzen
		panelTop.setLayout (new FlowLayout (FlowLayout.LEFT, 5, 5));
		panelTop.setBorder(BorderFactory.createTitledBorder("Aktionsmöglichkeiten"));
		panelTop.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20, 60));
		
		// JButton "Suchen" erzeugen
		JButton btnSearchCustomer = new JButton();
		btnSearchCustomer.setText("Suchen");
		//btnNewCustomer.addActionListener(new CtrlAdminContent());
		
		// JButton "Neuer Kunde" erzeugen
		JButton btnNewCustomer = new JButton();
		btnNewCustomer.setText("Neuer Kunde");
		//btnNewCustomer.addActionListener(new CtrlAdminContent());
		
		// JButton`s dem PanelTop hinzufügen
		panelTop.add(btnSearchCustomer);
		panelTop.add(btnNewCustomer);
		
		// Erstelle JPanel
		JPanel panelCenter = new JPanel();
		
		// Eigenschaften setzen
		panelCenter.setLayout((new BoxLayout (panelCenter, BoxLayout.X_AXIS)));
		panelCenter.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20, 200));

		// Erstelle JPanel
		JPanel panelCustomer = new JPanel();
		
		// Eigenschaften setzen
		panelCustomer.setBorder(BorderFactory.createTitledBorder("Kundeninformationen"));
		panelCustomer.setLayout (new FlowLayout (FlowLayout.LEFT, 5, 5));
		panelCustomer.setPreferredSize(new Dimension(600, 300));
		
		// JLabel erstellen
		JLabel lblKundenNr = new JLabel("Kunden-Nr.:");
		lblKundenNr.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtKundenNr = new JTextField();
		txtKundenNr.setEditable(false);
		txtKundenNr.setPreferredSize(new Dimension(190, 20));
		
		// JLabel und JTextField hinzufügen
		panelCustomer.add(lblKundenNr);
		panelCustomer.add(txtKundenNr);
		
		// JLabel erstellen
		JLabel lblKundenSeit = new JLabel("Kunden seit:");
		lblKundenSeit.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstllen
		final JTextField txtKundenSeit = new JTextField();
		txtKundenSeit.setEditable(false);
		txtKundenSeit.setPreferredSize(new Dimension(190, 20));
		
		// JLabel und JTextField hinzufügen
		panelCustomer.add(lblKundenSeit);
		panelCustomer.add(txtKundenSeit);
		
		// JLabel erstellen
		JLabel lblName = new JLabel("Name:");
		lblName.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setPreferredSize(new Dimension(190, 20));
		
		// JLabel und JTextField hinzufügen
		panelCustomer.add(lblName);
		panelCustomer.add(txtName);
		
		// JLabel erstellen
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtVorname = new JTextField();
		txtVorname.setEditable(false);
		txtVorname.setPreferredSize(new Dimension(190, 20));

		// JLabel und JTextField hinzufügen
		panelCustomer.add(lblVorname);
		panelCustomer.add(txtVorname);
		
		// JLabel erstellen
		JLabel lblStrasse = new JLabel("Strasse:");
		lblStrasse.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtStrasse = new JTextField();
		txtStrasse.setEditable(false);
		txtStrasse.setPreferredSize(new Dimension(470, 20));
		
		// JLabel und JTextField hinzufügen
		panelCustomer.add(lblStrasse);
		panelCustomer.add(txtStrasse);
		
		// JLabel erstellen
		JLabel lblPostleitzahl = new JLabel("Postleitzahl:");
		lblPostleitzahl.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstelllen
		final JTextField txtPostleitzahl = new JTextField();
		txtPostleitzahl.setEditable(false);
		txtPostleitzahl.setPreferredSize(new Dimension(190, 20));
		
		// JLabel und JTextField hinzufügen
		panelCustomer.add(lblPostleitzahl);
		panelCustomer.add(txtPostleitzahl);
		
		// JLabel erstellen
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtOrt = new JTextField();
		txtOrt.setEditable(false);
		txtOrt.setPreferredSize(new Dimension(190, 20));
		
		// JLabel und JTextField hinzufügen
		panelCustomer.add(lblOrt);
		panelCustomer.add(txtOrt);
		
		// JLabel erstellen
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtTelefon = new JTextField();
		txtTelefon.setEditable(false);
		txtTelefon.setPreferredSize(new Dimension(190, 20));
		
		// JLabel und JTextField hinzufügen
		panelCustomer.add(lblTelefon);
		panelCustomer.add(txtTelefon);
		
		// JLabel erstellen
		JLabel lblTelefax = new JLabel("Telefax:");
		lblTelefax.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtTelefax = new JTextField();
		txtTelefax.setEditable(false);
		txtTelefax.setPreferredSize(new Dimension(190, 20));
		
		// JLabel und JTextField hinzufügen
		panelCustomer.add(lblTelefax);
		panelCustomer.add(txtTelefax);
		
		// JLabel erstellen
		JLabel lblHandy = new JLabel("Handy:");
		lblHandy.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtHandy = new JTextField();
		txtHandy.setEditable(false);
		txtHandy.setPreferredSize(new Dimension(190, 20));
		
		// JLabel und JTextField hinzufügen
		panelCustomer.add(lblHandy);
		panelCustomer.add(txtHandy);
		
		// JLabel erstellen
		JLabel lblMail = new JLabel("E-Mail:");
		lblMail.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtMail = new JTextField();
		txtMail.setEditable(false);
		txtMail.setPreferredSize(new Dimension(190, 20));
		
		// JLabel und JTextField hinzufügen
		panelCustomer.add(lblMail);
		panelCustomer.add(txtMail);
		
		// Erstelle JPanel
		JPanel panelCar = new JPanel();
		
		// Eigenschaften setzen
		panelCar.setLayout((new BoxLayout (panelCar, BoxLayout.Y_AXIS)));
		panelCar.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 600 - 20, 200));
		
		// Erstelle JPanel
		JPanel panelCarSelect = new JPanel();
		panelCarSelect.setBorder(BorderFactory.createTitledBorder("Vorhandene Fahrzeuge"));
		panelCarSelect.setPreferredSize(new Dimension(100, 430));
		

		
		
		
		
		
		
		
		/*
		// DefaultTableModel erzeugen
        DefaultTableModel modelCars = new DefaultTableModel();
        modelCars.addColumn("FIN");
        modelCars.addColumn("Hersteller");
        modelCars.addColumn("Modell");
        modelCars.addColumn("Farbe");
		*/
		
        /*
		if(customers.size() >= 1){
			modelCars = fillCarTable(cars, modelCars);			
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Erstelle JTable mit JScrollPane
		//JTable tableSearchCar = new JTable(modelCars);
		final JTable tableSearchCar = DAOJTable.createTableCars();
		
		JScrollPane scrollTableCar = new JScrollPane(tableSearchCar);
		scrollTableCar.setPreferredSize(new Dimension(600, 70));
		scrollTableCar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		// JTable mit JScrollPane zum JPanel hinzufügen
		panelCarSelect.add(scrollTableCar);
		
		// Erstelle JPanel
		JPanel panelCarDetails = new JPanel();
		
		// Eigenschaften setzen
		panelCarDetails.setBorder(BorderFactory.createTitledBorder("Details zum ausgewählten Fahrzeug"));
		panelCarDetails.setPreferredSize(new Dimension(100, 430));

		// JLabel erstellen
		JLabel lblFIN = new JLabel("FIN:");
		lblFIN.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		JTextField txtFIN = new JTextField();
		txtFIN.setPreferredSize(new Dimension(210, 20));
		
		// JLabel und JTextField hinzufügen
		panelCarDetails.add(lblFIN);
		panelCarDetails.add(txtFIN);
		
		// JLabel erstellen
		JLabel lblFarbe = new JLabel("Farbe:");
		lblFarbe.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		JTextField txtFarbe = new JTextField();
		txtFarbe.setPreferredSize(new Dimension(210, 20));
		
		// JLabel und JTextField hinzufügen
		panelCarDetails.add(lblFarbe);
		panelCarDetails.add(txtFarbe);
		
		// JLabel erstellen
		JLabel lblHersteller = new JLabel("Hersteller:");
		lblHersteller.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		JTextField txtHersteller = new JTextField();
		txtHersteller.setPreferredSize(new Dimension(210, 20));
		
		// JLabel und JTextField hinzufügen
		panelCarDetails.add(lblHersteller);
		panelCarDetails.add(txtHersteller);
		
		// JLabel erstellen
		JLabel lblModell = new JLabel("Modell:");
		lblModell.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		JTextField txtModell = new JTextField();
		txtModell.setPreferredSize(new Dimension(210, 20));
		
		// JLabel und JTextField hinzufügen
		panelCarDetails.add(lblModell);
		panelCarDetails.add(txtModell);

		// Hinzufügen der JPanel's
		panelCar.add(panelCarSelect);
		panelCar.add(panelCarDetails);
		
		// Erstelle JPanel
		JPanel panelBlank = new JPanel();
		
		// Eigenschaften setzen
		panelBlank.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 850 - 20, 200));
		
		// Hinzufügen der JPanel's
		panelCenter.add(panelCustomer);
		panelCenter.add(panelCar);
		panelCenter.add(panelBlank);		
		
		// Erstelle JPanel.
		JPanel panelBottom = new JPanel();
		panelBottom.setBorder(BorderFactory.createTitledBorder("Suchergebnis"));
		panelBottom.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20, 650));
		
		// DAO-Objekt und ArrayList<Kunde> wird erstellt
		final ArrayList<Kunde> customers = DAOKunde.returnAllKunde();
		
		// JTable erzeugen
		final JTable tableSearchCustomer = DAOJTable.createTableCustomers(customers);
		
        // Eigenschaften setzen
        tableSearchCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JScrollPane erstellen
		JScrollPane scrollTableCustomer = new JScrollPane(tableSearchCustomer);
		scrollTableCustomer.setPreferredSize(new Dimension(
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 30,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 424	));
		scrollTableCustomer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
        // ActionListener für JTable erzeugen
		tableSearchCustomer.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(final MouseEvent e) {
        		// Einfacher Klick auf einen Tabelleneintrag
        		if (e.getClickCount() == 1) {
        			if(customers.size() >= 1){
        				// Kundeninformationen zum ausgewählten Kunden einlesen
        				txtKundenNr.setText(""+customers.get(tableSearchCustomer.getSelectedRow()).getKundennr());
        				txtKundenSeit.setText(""+customers.get(tableSearchCustomer.getSelectedRow()).getKundeseit());
        				txtName.setText(customers.get(tableSearchCustomer.getSelectedRow()).getNachname());
        				txtVorname.setText(customers.get(tableSearchCustomer.getSelectedRow()).getVorname());
        				txtStrasse.setText(customers.get(tableSearchCustomer.getSelectedRow()).getStrasse());
        				txtPostleitzahl.setText(""+customers.get(tableSearchCustomer.getSelectedRow()).getPlz());
        				txtOrt.setText(customers.get(tableSearchCustomer.getSelectedRow()).getOrt());
        				txtTelefon.setText(customers.get(tableSearchCustomer.getSelectedRow()).getTelefon());
        				txtTelefax.setText(customers.get(tableSearchCustomer.getSelectedRow()).getTelefax());
        				txtHandy.setText(customers.get(tableSearchCustomer.getSelectedRow()).getHandy());
        				txtMail.setText(customers.get(tableSearchCustomer.getSelectedRow()).getEmail());
        				// Fahrzeuge zum ausgewählten Kunden einlesen
        				
        			}
        		}
        	}
        });
		
		//Hinzufügen des Labels.
		panelBottom.add(scrollTableCustomer);

		// Eigenschaften setzen
		panel.setLayout(new BorderLayout());
		panel.add(panelTop, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(panelBottom, BorderLayout.SOUTH);
		
		
		
		return panel;
	}
	
	private DefaultTableModel fillCustomerTable(ArrayList<Kunde> customers, DefaultTableModel modelCustomers){
		
		for( Kunde n : customers ){
			modelCustomers.addRow(n.getKundeInfo());
        }
		
		return modelCustomers;
	}
	
	/*
	private DefaultTableModel fillcarTable(){
		

	}
	*/
	
	private JPanel createTaskPanel(){
		JPanel panel = new JPanel();
		
		// Erstelle JLabel.
		JLabel label = new JLabel ("This site is under construction", JLabel.LEFT);
		
		// Setze Format.
		label.setFont (new Font ("Arial", Font.BOLD, 16));

		//Hinzufügen des Labels.
		panel.add(label);
		
		return panel;
	}
	
	private JPanel createBillingPanel(){
		JPanel panel = new JPanel();
		
		// Erstelle JLabel.
		JLabel label = new JLabel ("This site is under construction", JLabel.LEFT);
		
		// Setze Format.
		label.setFont (new Font ("Arial", Font.BOLD, 16));

		//Hinzufügen des Labels.
		panel.add(label);
		
		return panel;
	}
	
}
