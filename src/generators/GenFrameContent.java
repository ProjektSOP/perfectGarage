package generators;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GenFrameContent {
	
	JFrame frame;
	
	public GenFrameContent(JFrame frame){
		this.frame = frame;
	}
	
	private Dimension getContentSize(){
		
		Dimension frameSize = this.frame.getContentPane().getSize();
		int frameWidth = (int)frameSize.getWidth();
		int frameHeight = (int)frameSize.getHeight();
		
		return new Dimension(frameWidth, frameHeight);
	}
	
	public JPanel closeContent(){
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(this.getContentSize());
		
		return panel;
	}
	
}
