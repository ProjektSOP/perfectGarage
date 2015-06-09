package dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class CtrlInfo implements ActionListener {
	
	private JDialog dialog;
	
	public CtrlInfo(JDialog dialog){
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("OK")) {
			this.dialog.setVisible(false);
		}
	}
	
}
