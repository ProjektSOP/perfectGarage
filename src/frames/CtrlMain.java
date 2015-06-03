package frames;

import generators.GenAdminContent;
import generators.GenFrameContent;
import generators.GenMeisterContent;
import generators.GenServiceContent;
import generators.GenWerkstattContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dialogs.DlgInfo;
import dialogs.DlgNutzer;

public class CtrlMain implements ActionListener {
	
	private final JFrame frame;

	public CtrlMain(JFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		GenFrameContent frameContent = new GenFrameContent(this.frame);
		GenAdminContent adminContent = new GenAdminContent(this.frame);
		GenServiceContent serviceContent = new GenServiceContent(this.frame);
		GenMeisterContent meisterContent = new GenMeisterContent(this.frame);
		GenWerkstattContent werkstattContent = new GenWerkstattContent(this.frame);
		
		// Frame
		if (event.getActionCommand().equals("Beenden")) {
			System.exit(0);
		}
		else if (event.getActionCommand().equals("Schlieﬂen")) {
			this.frame.getContentPane().removeAll();
			this.frame.getContentPane().add(frameContent.closeContent());
			this.frame.pack();
		}
		else if (event.getActionCommand().equals("Info")) {
			DlgInfo dlgInfo = new DlgInfo();
			dlgInfo.showDialog(true);
		}
		
	}

}
