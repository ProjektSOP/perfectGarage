package generators;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

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
		tabbedPane.addTab ("Kundenverwaltung", tabbedPanel);

		// Erstelle Registrierkarte.
		tabbedPanel = new JPanel ();
		// Hinzufügen von Panel zu Registrierkarte.
		tabbedPane.addTab ("Fahrzeugverwaltung", tabbedPanel);

		// Erstelle Registrierkarte.
		tabbedPanel = new JPanel ();
		// Hinzufügen von Panel zu Registrierkarte.
		tabbedPane.addTab ("Auftragsverwaltung", tabbedPanel);
		
		// Erstelle Registrierkarte.
		tabbedPanel = new JPanel ();
		// Hinzufügen von Panel zu Registrierkarte.
		tabbedPane.addTab ("Rechnungsverwaltung", tabbedPanel);
	      
		// Hinzufügen zum Fenster.
		panel.add(tabbedPane);
		
		return panel;
	}
	
	public JPanel showAllCustomers(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(this.getContentSize());
		
		JPanel panelTop = new JPanel();
		panelTop.setBorder(BorderFactory.createTitledBorder("Suchfilter (Kunden)"));
		panelTop.setPreferredSize(new Dimension(400, 100));
		
		JTable tableSearch = new JTable(50, 15);
		JScrollPane scrollTable = new JScrollPane(tableSearch);
		
		scrollTable.setPreferredSize(new Dimension(
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 210	));
		
		scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(BorderFactory.createTitledBorder("Suchergebnis"));
		panelCenter.add(scrollTable);
		
		panel.setLayout(new BorderLayout());
		panel.add(panelTop, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		
		return panel;
	}
	
	public JPanel showAllCars(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(this.getContentSize());
		
		JPanel panelTop = new JPanel();
		panelTop.setBorder(BorderFactory.createTitledBorder("Suchfilter (Fahrzeuge)"));
		panelTop.setPreferredSize(new Dimension(400, 100));
		
		JTable tableSearch = new JTable(50, 15);
		JScrollPane scrollTable = new JScrollPane(tableSearch);
		
		scrollTable.setPreferredSize(new Dimension(
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 210	));
		
		scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(BorderFactory.createTitledBorder("Suchergebnis"));
		panelCenter.add(scrollTable);
		
		panel.setLayout(new BorderLayout());
		panel.add(panelTop, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		
		return panel;
	}
	
}
