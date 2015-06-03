package frames;

import generators.GenAdminContent;
import generators.GenMeisterContent;
import generators.GenServiceContent;
import generators.GenWerkstattContent;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FrmMain {
	
	JFrame frame = new JFrame();
	JMenuBar menubar = new JMenuBar();
	JPanel panel = new JPanel();
	
	String modul = new String();
	
	
	public FrmMain(String modul){
		
		this.modul = modul;
		
		if (this.modul.equals("Admin")){
			this.frame.setTitle("perfectGarage - Administrator");
		}
		else if(this.modul.equals("Service")){
			this.frame.setTitle("perfectGarage - Service");
		}
		else if(this.modul.equals("Meister")){
			this.frame.setTitle("perfectGarage - Meister");
		}
		else if(this.modul.equals("Werkstatt")){
			this.frame.setTitle("perfectGarage - Werkstatt");
		}
		
		this.panel.setLayout(new BorderLayout());
		
		this.createMenubar();
		this.frame.setJMenuBar(this.menubar);
		
		this.createPanel();
		this.frame.add(this.panel);
				
		this.frame.pack();
		this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void createMenubar(){
		// Menü Datei
		JMenu mnuFile = new JMenu("Datei");
		this.menubar.add(mnuFile);

		JMenuItem mnuItemExit = new JMenuItem("Beenden");
		mnuItemExit.addActionListener(new CtrlMain(this.frame));
		mnuFile.add(mnuItemExit);
		
		// Menü Bearbeiten
		JMenu mnuEdit = new JMenu("Bearbeiten");
		this.menubar.add(mnuEdit);
		
		JMenuItem mnuItemCut = new JMenuItem("Ausschneiden");
		mnuEdit.add(mnuItemCut);
		JMenuItem mnuItemCopy = new JMenuItem("Kopieren");
		mnuEdit.add(mnuItemCopy);
		JMenuItem mnuItemPaste = new JMenuItem("Einfügen");
		mnuEdit.add(mnuItemPaste);
		mnuEdit.addSeparator();
		JMenuItem mnuItemSelectAll = new JMenuItem("Alles markieren");
		mnuEdit.add(mnuItemSelectAll);
		
		//Menü Hilfe
		JMenu mnuHelp = new JMenu("Hilfe");
		this.menubar.add(mnuHelp);
		
		JMenuItem mnuItemInfo = new JMenuItem("Info");
		mnuItemInfo.addActionListener(new CtrlMain(this.frame));
		mnuHelp.add(mnuItemInfo);
	}
	
	private void createPanel(){
		
		if (this.modul.equals("Admin")){
			GenAdminContent adminContent = new GenAdminContent(this.frame);
			this.panel = adminContent.showAdminPanel();
		}
		else if (this.modul.equals("Service")){
			GenServiceContent serviceContent = new GenServiceContent(this.frame);
			this.panel = serviceContent.showServicePanel();
		}
		else if (this.modul.equals("Meister")){
			GenMeisterContent meisterContent = new GenMeisterContent(this.frame);
			this.panel = meisterContent.showMeisterPanel();			
		}
		else if (this.modul.equals("Werkstatt")){
			GenWerkstattContent werkstattContent = new GenWerkstattContent(this.frame);
			this.panel = werkstattContent.showWerkstattPanel();
		}
		
	}

	public void showFrame(boolean b) {
		if(b==true){
			this.frame.setVisible(true);
		}else if(b==false){
			this.frame.setVisible(false);
		}
	}
	
}
