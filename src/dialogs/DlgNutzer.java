package dialogs;

/**
 * @author treichert
 *
 */

import interfaces.DlgInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import objects.Nutzer;

public class DlgNutzer implements DlgInterface {
	
	private JTable tableUsers;
	private JDialog dialog = new JDialog();
	private JPanel panel;
	
	public DlgNutzer(){
		Nutzer user = new Nutzer();
		
		this.dialog.setTitle("DlgNutzer");
		
		this.createPanel(user);
		this.dialog.add(this.panel);

		this.dialog.pack();
		this.dialog.setLocationRelativeTo(null);
		this.dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.dialog.setModal(true);
		
	}
	
	public void newNutzer(JTable tableUsers, Nutzer user) {
		
		this.dialog.setTitle("Neuen Nutzer anlegen");
		this.tableUsers = tableUsers;
		this.dialog.remove(this.panel);
		this.createPanel(user);
		this.dialog.add(this.panel);
		
		this.showDialog(true);
	}
	
	public void editNutzer(JTable tableUsers, Nutzer user) {
		
		this.dialog.setTitle("Nutzer bearbeiten");
		this.tableUsers = tableUsers;
		this.dialog.remove(this.panel);
		this.createPanel(user);
		this.dialog.add(this.panel);
		
		this.showDialog(true);
	}
	
	private void createPanel(Nutzer user){
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(BorderFactory.createTitledBorder("Informationen zum Nutzer"));
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setPreferredSize(new Dimension(80, 20));
		JTextField txtUsername = new JTextField();
		txtUsername.setPreferredSize(new Dimension(150, 20));
		txtUsername.setText(user.getUsername());
		panelCenter.add(lblUsername);
		panelCenter.add(txtUsername);
		
		JLabel lblNachname = new JLabel("Name");
		lblNachname.setPreferredSize(new Dimension(80, 20));
		JTextField txtNachname = new JTextField();
		txtNachname.setPreferredSize(new Dimension(150, 20));
		txtNachname.setText(user.getNachname());
		panelCenter.add(lblNachname);
		panelCenter.add(txtNachname);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setPreferredSize(new Dimension(80, 20));
		JTextField txtVorname = new JTextField();
		txtVorname.setPreferredSize(new Dimension(150, 20));
		txtVorname.setText(user.getVorname());
		panelCenter.add(lblVorname);
		panelCenter.add(txtVorname);
		
		JLabel lblGruppe = new JLabel("Nutzerrolle");
		lblGruppe.setPreferredSize(new Dimension(80, 20));
		JTextField txtGruppe = new JTextField();
		txtGruppe.setPreferredSize(new Dimension(150, 20));
		txtGruppe.setText(user.getGruppe());
		panelCenter.add(lblGruppe);
		panelCenter.add(txtGruppe);
		
		JButton btnSave = new JButton("Speichern");
		btnSave.addActionListener(new CtrlNutzer(this.tableUsers, this.dialog, user, txtUsername, txtNachname, txtVorname, txtGruppe));
		this.showDialog(false);
		
		JButton btnAbort = new JButton("Abbrechen");
		btnAbort.addActionListener(new CtrlNutzer(this.tableUsers, this.dialog));
		this.showDialog(false);
		
		JPanel panelBottom = new JPanel();
		panelBottom.add(btnSave);
		panelBottom.add(btnAbort);
		
		this.panel = new JPanel();
		this.panel.setLayout(new BorderLayout());
		this.panel.add(panelCenter, BorderLayout.CENTER);
		this.panel.add(panelBottom, BorderLayout.SOUTH);
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
