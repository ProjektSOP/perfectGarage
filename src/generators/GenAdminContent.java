package generators;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GenAdminContent {
	
	JFrame frame;
	
	public GenAdminContent(JFrame frame){
		this.frame = frame;
	}
	
	private Dimension getContentSize(){
		
		Dimension frameSize = this.frame.getContentPane().getSize();
		int frameWidth = (int)frameSize.getWidth();
		int frameHeight = (int)frameSize.getHeight();
		
		return new Dimension(frameWidth, frameHeight);
	}
	
	public JPanel generateEmployeeContent(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(this.getContentSize());
		
		JPanel panelTop = new JPanel();
		panelTop.setBorder(BorderFactory.createTitledBorder("Suchfilter"));
		panelTop.setPreferredSize(new Dimension(400, 100));
		
		JTable tableSearch = new JTable(40, 15);
		JScrollPane scrollTable = new JScrollPane(tableSearch);
		scrollTable.setPreferredSize(new Dimension(1360, 640));
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
