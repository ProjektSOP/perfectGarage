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
import java.awt.event.ActionListener;
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

import objects.Fahrzeug;
import objects.Kunde;
import DAO.DAOFahrzeug;
import DAO.DAOJTable;
import DAO.DAOKunde;

public class GenServiceContent {

	private JFrame frame;
	private ArrayList<Kunde> customers;
	private ArrayList<Fahrzeug> cars;
	
	private JTable tableSearchCar;
	
	public GenServiceContent(JFrame frame){
		this.frame = frame;
	}
	
	private Dimension getContentSize(){
		
		/**
		 * @return	Dimension(frameWidth, frameHeight) 
		 * 			Gibt Höhe und Breite des Frames zurück
		 */
		
		Dimension frameSize = this.frame.getContentPane().getSize();
		int frameWidth = (int)frameSize.getWidth();
		int frameHeight = (int)frameSize.getHeight();
		
		return new Dimension(frameWidth, frameHeight);
	}
	
	public JPanel showServicePanel(){
		
		/**
		 * @return	JPanel panel 
		 * 			Gibt das panel mit Meister-Content zurück
		 */
		
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
		
		/**
		 * @return	JPanel panel 
		 * 			Gibt das panel mit Kunden- und Fahrzeuginformationen zurück
		 */
		
		// DAO-Objekt und ArrayList<Kunde> wird erstellt
		//final ArrayList<Kunde> customers = DAOKunde.returnAllKunde();
		customers = DAOKunde.returnAllKunde();
		
		// DAO-Objekt und ArrayList<Fahrzeug> wird erstellt
		//final ArrayList<Fahrzeug> cars;
		
		JPanel panel = new JPanel();
		panel.setLayout (new BorderLayout());
		
		// Erstelle JPanel.
		JPanel panelTop = new JPanel();
		
		// Eigenschaften setzen
		panelTop.setLayout (new FlowLayout (FlowLayout.LEFT, 5, 5));
		panelTop.setBorder(BorderFactory.createTitledBorder("Aktionsmöglichkeiten"));
		panelTop.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20, 60));
		
		// JButton "Neuer Kunde" erzeugen
		JButton btnNewCustomer = new JButton();
		btnNewCustomer.setText("Neuer Kunde");
		final ActionListener serviceContent = new CtrlServiceContent();
		btnNewCustomer.addActionListener(serviceContent);
		
		// JButton "Kunde editieren" erzeugen
		JButton btnChangeCustomer = new JButton();
		btnChangeCustomer.setText("Kunde editieren");
		btnChangeCustomer.addActionListener(serviceContent);

		// JButton "Kunde löschen" erzeugen
		JButton btnDeleteCustomer = new JButton();
		btnDeleteCustomer.setText("Kunde löschen");
		btnDeleteCustomer.addActionListener(serviceContent);
		
		// JButton "Kunde suchen" erzeugen
		JButton btnSearchCustomer = new JButton();
		btnSearchCustomer.setText("Kunde suchen");
		btnSearchCustomer.addActionListener(serviceContent);
		
		// JButton`s dem PanelTop hinzufügen
		panelTop.add(btnNewCustomer);
		panelTop.add(btnChangeCustomer);
		panelTop.add(btnDeleteCustomer);
		panelTop.add(btnSearchCustomer);
		
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
		JPanel panelCarDetails = new JPanel();
		
		// Eigenschaften setzen
		panelCarDetails.setBorder(BorderFactory.createTitledBorder("Details zum ausgewählten Fahrzeug"));
		panelCarDetails.setPreferredSize(new Dimension(100, 430));

		// JLabel erstellen
		JLabel lblFIN = new JLabel("FIN:");
		lblFIN.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtFIN = new JTextField();
		txtFIN.setEditable(false);
		txtFIN.setPreferredSize(new Dimension(210, 20));
		
		// JLabel und JTextField hinzufügen
		panelCarDetails.add(lblFIN);
		panelCarDetails.add(txtFIN);
		
		// JLabel erstellen
		JLabel lblFarbe = new JLabel("Farbe:");
		lblFarbe.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtFarbe = new JTextField();
		txtFarbe.setEditable(false);
		txtFarbe.setPreferredSize(new Dimension(210, 20));
		
		// JLabel und JTextField hinzufügen
		panelCarDetails.add(lblFarbe);
		panelCarDetails.add(txtFarbe);
		
		// JLabel erstellen
		JLabel lblHersteller = new JLabel("Hersteller:");
		lblHersteller.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtHersteller = new JTextField();
		txtHersteller.setEditable(false);
		txtHersteller.setPreferredSize(new Dimension(210, 20));
		
		// JLabel und JTextField hinzufügen
		panelCarDetails.add(lblHersteller);
		panelCarDetails.add(txtHersteller);
		
		// JLabel erstellen
		JLabel lblModell = new JLabel("Modell:");
		lblModell.setPreferredSize(new Dimension(80, 20));
		
		// JTextField erstellen
		final JTextField txtModell = new JTextField();
		txtModell.setEditable(false);
		txtModell.setPreferredSize(new Dimension(210, 20));
		
		// JLabel und JTextField hinzufügen
		panelCarDetails.add(lblModell);
		panelCarDetails.add(txtModell);
		
		// Erstelle JPanel
		JPanel panelCar = new JPanel();
		
		// Eigenschaften setzen
		panelCar.setLayout((new BoxLayout (panelCar, BoxLayout.Y_AXIS)));
		panelCar.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 600 - 20, 200));
		
		// Erstelle JPanel
		JPanel panelCarSelect = new JPanel();
		panelCarSelect.setBorder(BorderFactory.createTitledBorder("Vorhandene Fahrzeuge"));
		panelCarSelect.setPreferredSize(new Dimension(100, 430));
		
		// Leere Liste erzeugen, wenn noch kein Fahrzeug ausgewählt wurde
		if(cars == null){
			cars = new ArrayList<Fahrzeug>();
		}
				
		// Erstelle JTable mit JScrollPane
		tableSearchCar = DAOJTable.createTableCars(cars);
		
		JScrollPane scrollTableCar = new JScrollPane(tableSearchCar);
		scrollTableCar.setPreferredSize(new Dimension(600, 70));
		scrollTableCar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
        // ActionListener für JTable erzeugen
		tableSearchCar.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(final MouseEvent e) {
        		// Einfacher Klick auf einen Tabelleneintrag
        		if (e.getClickCount() == 1) {
        			if(cars.size() >= 1){
        				// Kundeninformationen zum ausgewählten Kunden einlesen
        				txtFIN.setText(""+cars.get(tableSearchCar.getSelectedRow()).getFIN());
        				txtFarbe.setText(cars.get(tableSearchCar.getSelectedRow()).getFarbe());
        				txtHersteller.setText(cars.get(tableSearchCar.getSelectedRow()).getHersteller());
        				txtModell.setText(cars.get(tableSearchCar.getSelectedRow()).getModell());
        			}
        		}
        	}
        });
		
		// JTable mit JScrollPane zum JPanel hinzufügen
		panelCarSelect.add(scrollTableCar);

		// Hinzufügen der JPanel's
		panelCar.add(panelCarSelect);
		panelCar.add(panelCarDetails);
		
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
        				txtFIN.setText("");
        				txtFarbe.setText("");
        				txtHersteller.setText("");
        				txtModell.setText("");
        				cars = DAOFahrzeug.returnAllFahrzeugInfosbyKundenNr(customers.get(tableSearchCustomer.getSelectedRow()).getKundennr());
        				tableSearchCar.setModel( DAOJTable.fillTableCars(cars) );
        			}
        		}
        	}
        });
		
		
		// Hinzufügen der JPanel's
		panelCenter.add(panelCustomer);
		panelCenter.add(panelCar);		
		
		// Erstelle JPanel.
		JPanel panelBottom = new JPanel();
		panelBottom.setBorder(BorderFactory.createTitledBorder("Suchergebnis"));
		panelBottom.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20, 650));
		
		//Hinzufügen des Labels.
		panelBottom.add(scrollTableCustomer);

		// Eigenschaften setzen
		panel.setLayout(new BorderLayout());
		panel.add(panelTop, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(panelBottom, BorderLayout.SOUTH);

		return panel;
	}
	
	
	
	private JPanel createTaskPanel(){
		
		/**
		 * @return	JPanel panel 
		 * 			Gibt das panel mit Auftragsinformationen zurück
		 */
		
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
		
		/**
		 * @return	JPanel panel 
		 * 			Gibt das panel mit Rechnungsinformationen zurück
		 */
		
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
