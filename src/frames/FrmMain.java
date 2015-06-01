package frames;

import generators.GenAdminContent;

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
	
	public FrmMain(){
		this.frame.setTitle("FrmAdmin");
		this.panel.setLayout(new BorderLayout());
		
		this.createMenubar();
		this.frame.setJMenuBar(this.menubar);
		
		this.createPanel();
		this.frame.add(this.panel);
				
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void createMenubar(){
		// Menü Datei
		JMenu mnuFile = new JMenu("Datei");
		this.menubar.add(mnuFile);

		JMenuItem mnuItemClose = new JMenuItem("Schließen");
		mnuItemClose.addActionListener(new CtrlMain(this.frame));
		mnuFile.add(mnuItemClose);
		mnuFile.addSeparator();
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
		
		//Menü Stammdaten
		JMenu mnuKeyData = new JMenu("Stammdaten");
		this.menubar.add(mnuKeyData);
		
		JMenuItem mnuItemEmployee = new JMenuItem("Mitarbeiterverwaltung");
		mnuItemEmployee.addActionListener(new CtrlMain(this.frame));
		mnuKeyData.add(mnuItemEmployee);
		
		//Menü Hilfe
		JMenu mnuHelp = new JMenu("Hilfe");
		this.menubar.add(mnuHelp);
		
		JMenuItem mnuItemInfo = new JMenuItem("Info");
		mnuItemInfo.addActionListener(new CtrlMain(this.frame));
		mnuHelp.add(mnuItemInfo);
	}
	
	private void createPanel(){
		GenAdminContent adminContent = new GenAdminContent();
		this.panel = adminContent.resetContent();
	}

	public void showFrame(boolean b) {
		if(b==true){
			this.frame.setVisible(true);
		}else if(b==false){
			this.frame.setVisible(false);
		}
	}
	
}
