package frames;

import generators.GenAdminContent;
import generators.GenFrameContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dialogs.DlgInfo;

//import dialogs.DlgInfo;

public class CtrlMain implements ActionListener {
	
	private final JFrame frame;

	public CtrlMain(JFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		GenFrameContent frameContent = new GenFrameContent(this.frame);
		GenAdminContent adminContent = new GenAdminContent(this.frame);
		
		if (event.getActionCommand().equals("Beenden")) {
			System.exit(0);
		}
		else if (event.getActionCommand().equals("Schlie�en")) {
			this.frame.getContentPane().removeAll();
			this.frame.getContentPane().add(frameContent.closeContent());
			this.frame.pack();
		}
		else if (event.getActionCommand().equals("Mitarbeiterverwaltung")) {
			this.frame.getContentPane().removeAll();
			this.frame.getContentPane().add(adminContent.generateEmployeeContent());
			this.frame.pack();
		}
		else if (event.getActionCommand().equals("Info")) {
			DlgInfo dlgInfo = new DlgInfo();
			dlgInfo.showDialog(true);
		}
	}

}
