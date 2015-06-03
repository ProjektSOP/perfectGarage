package generators;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GenMeisterContent {

	JFrame frame;
	
	public GenMeisterContent(JFrame frame){
		this.frame = frame;
	}
	
	private Dimension getContentSize(){
		
		Dimension frameSize = this.frame.getContentPane().getSize();
		int frameWidth = (int)frameSize.getWidth();
		int frameHeight = (int)frameSize.getHeight();
		
		return new Dimension(frameWidth, frameHeight);
	}
	
	public JPanel showMeisterPanel(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(this.getContentSize());
		
		JPanel panelTop = new JPanel();
		panelTop.setPreferredSize(new Dimension(400, 100));
		
		// Erstelle JLabel.
		JLabel lblText1 = new JLabel ("This site is under construction", JLabel.LEFT);
		// Setze Format.
		lblText1.setFont (new Font ("Arial", Font.BOLD, 16));
		// Hinzufügen von Label zu Panel.
		panelTop.add(lblText1);
		
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
