package ColorFrame;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ColorPanel extends JPanel {
	
	private JColorChooser colorChooser;

	/**
	 * Create the panel.
	 */
	public ColorPanel(JTextArea txtArea ) {
		setLayout(new BorderLayout(0, 0));
		colorChooser=new JColorChooser();
		this.add(colorChooser, BorderLayout.CENTER);

	}

	public JColorChooser getColorChooser() {
		return colorChooser;
	}
	
	

}
