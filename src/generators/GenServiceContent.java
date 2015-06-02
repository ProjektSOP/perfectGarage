package generators;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

		// Hinzufügen des Labels.
		tabbedPanel.add (this.createCustomerPanel());

		// Erstelle Registrierkarte.
		tabbedPanel = new JPanel ();
		// Hinzufügen von Panel zu Registrierkarte.
		tabbedPane.addTab ("Fahrzeugverwaltung", tabbedPanel);

		// Hinzufügen des Labels.
		tabbedPanel.add (this.createCarPanel());
		
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
	
	private JPanel createCustomerPanel(){
		JPanel panel = new JPanel();
		panel.setLayout (new BorderLayout());
		
		// Erstelle JPanel.
		JPanel panelTop = new JPanel();
		panelTop.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20, 300));
		
		// Erstelle JLabel.
		JLabel lblText1 = new JLabel ("Kundeninformationen", JLabel.LEFT);
		
		// Setze Format.
		lblText1.setFont (new Font ("Arial", Font.BOLD, 16));

		//Hinzufügen des Labels.
		panelTop.add(lblText1);
		
		
		// Erstelle JPanel.
		JPanel panelCenter = new JPanel();
		panelCenter.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20, 300));
		

		//Hinzufügen des Labels.
		//panelCenter.add(label);
		
		
		// Erstelle JPanel.
		JPanel panelBottom = new JPanel();
		panelBottom.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20, 300));
		
		
		JTable tableSearch = new JTable(16, 15);
		JScrollPane scrollTable = new JScrollPane(tableSearch);
		
		scrollTable.setPreferredSize(new Dimension(
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 754	));
		scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//Hinzufügen des Labels.
		panelBottom.add(scrollTable);

		// Eigenschaften setzen
		panel.setLayout(new BorderLayout());
		panel.add(panelTop, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(panelBottom, BorderLayout.SOUTH);
		return panel;
	}
	
	private JPanel createCarPanel(){
		JPanel panel = new JPanel();
		panel.setLayout (new BorderLayout());
		
		// Erstelle JPanel.
		JPanel panelTop = new JPanel();
		panelTop.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20, 300));
		
		// Erstelle JLabel.
		JLabel lblText1 = new JLabel ("Fahrzeuginformationen", JLabel.LEFT);
		
		// Setze Format.
		lblText1.setFont (new Font ("Arial", Font.BOLD, 16));

		//Hinzufügen des Labels.
		panelTop.add(lblText1);
		
		
		// Erstelle JPanel.
		JPanel panelCenter = new JPanel();
		panelCenter.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20, 300));
		

		//Hinzufügen des Labels.
		//panelCenter.add(label);
		
		
		// Erstelle JPanel.
		JPanel panelBottom = new JPanel();
		panelBottom.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20, 300));
		
		
		JTable tableSearch = new JTable(16, 15);
		JScrollPane scrollTable = new JScrollPane(tableSearch);
		
		scrollTable.setPreferredSize(new Dimension(
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 754	));
		scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//Hinzufügen des Labels.
		panelBottom.add(scrollTable);

		// Eigenschaften setzen
		panel.setLayout(new BorderLayout());
		panel.add(panelTop, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(panelBottom, BorderLayout.SOUTH);
		return panel;
	}
	
	private JPanel createTaskPanel(){
		JPanel panel = new JPanel();
		
		// Erstelle JLabel.
		JLabel label = new JLabel ("Auftragsinformationen", JLabel.LEFT);
		
		// Setze Format.
		label.setFont (new Font ("Arial", Font.BOLD, 16));

		//Hinzufügen des Labels.
		panel.add(label);
		
		return panel;
	}
	
	private JPanel createBillingPanel(){
		JPanel panel = new JPanel();
		
		// Erstelle JLabel.
		JLabel label = new JLabel ("Rechnungsinformationen", JLabel.LEFT);
		
		// Setze Format.
		label.setFont (new Font ("Arial", Font.BOLD, 16));

		//Hinzufügen des Labels.
		panel.add(label);
		
		return panel;
	}
	
}
