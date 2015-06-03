package generators;

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

import dialogs.DlgNutzer;
import objects.Kunde;
import objects.Nutzer;
import DAO.DAOKunde;

public class GenServiceContent {

	JFrame frame;
	
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
		// Setze bevorzugte Größe.
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
		
		DAOKunde daoKunde = new DAOKunde();
		final ArrayList<Kunde> customers = daoKunde.returnAllKunde();
		
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
		
		
		JLabel lblKundenNr = new JLabel("Kunden-Nr.:");
		lblKundenNr.setPreferredSize(new Dimension(80, 20));
		
		final JTextField txtKundenNr = new JTextField();
		txtKundenNr.setPreferredSize(new Dimension(190, 20));
		
		panelCustomer.add(lblKundenNr);
		panelCustomer.add(txtKundenNr);
		
		
		JLabel lblKundenSeit = new JLabel("Kunden seit:");
		lblKundenSeit.setPreferredSize(new Dimension(80, 20));
		
		final JTextField txtKundenSeit = new JTextField();
		txtKundenSeit.setPreferredSize(new Dimension(190, 20));
		
		panelCustomer.add(lblKundenSeit);
		panelCustomer.add(txtKundenSeit);
		
		
		JLabel lblName = new JLabel("Name:");
		lblName.setPreferredSize(new Dimension(80, 20));
		
		final JTextField txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(190, 20));
		
		panelCustomer.add(lblName);
		panelCustomer.add(txtName);
		
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setPreferredSize(new Dimension(80, 20));
		
		final JTextField txtVorname = new JTextField();
		txtVorname.setPreferredSize(new Dimension(190, 20));
		
		panelCustomer.add(lblVorname);
		panelCustomer.add(txtVorname);
		
		
		JLabel lblStrasse = new JLabel("Strasse:");
		lblStrasse.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtStrasse = new JTextField();
		txtStrasse.setPreferredSize(new Dimension(470, 20));
		
		panelCustomer.add(lblStrasse);
		panelCustomer.add(txtStrasse);
		
		
		JLabel lblPostleitzahl = new JLabel("Postleitzahl:");
		lblPostleitzahl.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtPostleitzahl = new JTextField();
		txtPostleitzahl.setPreferredSize(new Dimension(190, 20));
		
		panelCustomer.add(lblPostleitzahl);
		panelCustomer.add(txtPostleitzahl);
		
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtOrt = new JTextField();
		txtOrt.setPreferredSize(new Dimension(190, 20));
		
		panelCustomer.add(lblOrt);
		panelCustomer.add(txtOrt);
		
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtTelefon = new JTextField();
		txtTelefon.setPreferredSize(new Dimension(190, 20));
		
		panelCustomer.add(lblTelefon);
		panelCustomer.add(txtTelefon);
		
		
		JLabel lblTelefax = new JLabel("Telefax:");
		lblTelefax.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtTelefax = new JTextField();
		txtTelefax.setPreferredSize(new Dimension(190, 20));
		
		panelCustomer.add(lblTelefax);
		panelCustomer.add(txtTelefax);
		
		
		JLabel lblHandy = new JLabel("Handy:");
		lblHandy.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtHandy = new JTextField();
		txtHandy.setPreferredSize(new Dimension(190, 20));
		
		panelCustomer.add(lblHandy);
		panelCustomer.add(txtHandy);
		
		
		JLabel lblMail = new JLabel("E-Mail:");
		lblMail.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtMail = new JTextField();
		txtMail.setPreferredSize(new Dimension(190, 20));
		
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
		
		// Erstelle JTable mit JScrollPane
		JTable tableSearchCar = new JTable(3, 4);
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
		
		
		
		
		
		JLabel lblFIN = new JLabel("FIN:");
		lblFIN.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtFIN = new JTextField();
		txtFIN.setPreferredSize(new Dimension(210, 20));
		
		panelCarDetails.add(lblFIN);
		panelCarDetails.add(txtFIN);
		
		
		JLabel lblFarbe = new JLabel("Farbe:");
		lblFarbe.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtFarbe = new JTextField();
		txtFarbe.setPreferredSize(new Dimension(210, 20));
		
		panelCarDetails.add(lblFarbe);
		panelCarDetails.add(txtFarbe);
		
		
		JLabel lblHersteller = new JLabel("Hersteller:");
		lblHersteller.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtHersteller = new JTextField();
		txtHersteller.setPreferredSize(new Dimension(210, 20));
		
		panelCarDetails.add(lblHersteller);
		panelCarDetails.add(txtHersteller);
		
		
		JLabel lblModell = new JLabel("Modell:");
		lblModell.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtModell = new JTextField();
		txtModell.setPreferredSize(new Dimension(210, 20));
		
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
		
		
		
		
		// DefaultTableModel erzeugen
        DefaultTableModel modelCustomers = new DefaultTableModel();
        modelCustomers.addColumn("KundeNr");
        modelCustomers.addColumn("Name");
        modelCustomers.addColumn("Vorname");
        modelCustomers.addColumn("Strasse");
        modelCustomers.addColumn("PLZ");
        modelCustomers.addColumn("Ort");
        modelCustomers.addColumn("Kunde seit");
        modelCustomers.addColumn("Telefon");
        modelCustomers.addColumn("Telefax");
        modelCustomers.addColumn("Handy");
        modelCustomers.addColumn("E-Mail");
		
		if(customers.size() >= 1){
			modelCustomers = createCustomerTable(customers, modelCustomers);			
		}
		
        // JTable erzeugen 
        final JTable tableSearchCustomer = new JTable(modelCustomers) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int x, int y) {
                return false;
            }
        };
        
        // Eigenschaften setzen
        tableSearchCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
		
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
        				txtKundenNr.setText(""+customers.get(tableSearchCustomer.getSelectedRow()).getKundennr());
        				txtKundenSeit.setText(""+customers.get(tableSearchCustomer.getSelectedRow()).getKundeseit());
        				txtName.setText(customers.get(tableSearchCustomer.getSelectedRow()).getNachname());
        				txtVorname.setText(customers.get(tableSearchCustomer.getSelectedRow()).getVorname());
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
	
	private DefaultTableModel createCustomerTable(ArrayList<Kunde> customers, DefaultTableModel modelCustomers){
		
		for( Kunde n : customers ){
			modelCustomers.addRow(n.getKundeInfo());
        }
		
		return modelCustomers;
	}
	
	
	
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
