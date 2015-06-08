package dialogs;

/**
 * @author treichert
 *
 */

import interfaces.DlgInterface;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DlgInfo implements DlgInterface {
	
	JDialog dialog = new JDialog();
	JPanel panel = new JPanel();
	
	public DlgInfo(){
		this.dialog.setTitle("Info");
		
		this.createPanel();
		this.dialog.add(this.panel);
		
		this.dialog.pack();
		this.dialog.setLocationRelativeTo(null);
		this.dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.dialog.setModal(true);
	}
	
	private void createPanel(){
		// Logo
		JLabel lblLogo = new JLabel(new ImageIcon("project.jpg"));
		
		// Text
		JTextArea txtInfo = new JTextArea();
		txtInfo.setText("InfoText");
		
		JPanel panelInfo = new JPanel();
		panelInfo.add(txtInfo);
		
		// Buttons
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new CtrlInfo(this.dialog));
		
		// Zusammenbau
		JPanel panelLogo = new JPanel();
		panelLogo.add(lblLogo);
		
		JPanel panelContent = new JPanel();
		panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
		panelContent.add(panelLogo);
		panelContent.add(panelInfo);
		
		JPanel panelButtons = new JPanel();
		panelButtons.add(btnOK);
		
		this.panel.setLayout(new BorderLayout());
		this.panel.add(panelContent, BorderLayout.CENTER);
		this.panel.add(panelButtons, BorderLayout.SOUTH);
	}

	@Override
	public void showDialog(boolean b) {
		if(b==true){
			this.dialog.setVisible(true);
		}else if(b==false){
			this.dialog.setVisible(false);
		}
	}
	
}
