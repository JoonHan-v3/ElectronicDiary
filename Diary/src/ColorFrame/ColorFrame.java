package ColorFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class ColorFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private  ColorPanel colorPanel;
	private  JTextArea txtArea;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public ColorFrame(JComponent txtArea1) {
		setAlwaysOnTop(true);
		setResizable(false);
		setBounds(100, 100, 610, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
			txtArea= new JTextArea();
			txtArea.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			txtArea.setText("Time will tell you everything!");
			contentPanel.add(txtArea, BorderLayout.SOUTH);
		
		{
			colorPanel = new ColorPanel(txtArea);
			contentPanel.add(colorPanel, BorderLayout.CENTER);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton backgroundBttn = new JButton("Background");
				backgroundBttn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtArea.setBackground(colorPanel.getColorChooser().getColor());
						txtArea1.setBackground(colorPanel.getColorChooser().getColor());
					}
				});
				buttonPane.add(backgroundBttn);
			}
			{
				JButton foregroundBttn = new JButton("Foreground");
				foregroundBttn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtArea.setForeground(colorPanel.getColorChooser().getColor());
						txtArea1.setForeground(colorPanel.getColorChooser().getColor());
						
					}
				});
				foregroundBttn.setActionCommand("OK");
				buttonPane.add(foregroundBttn);
				getRootPane().setDefaultButton(foregroundBttn);
			}
			{
				JButton btnDone = new JButton("Done");
				btnDone.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeAction();
					}
				});
				buttonPane.add(btnDone);
			}
			
		}
	}
	
	public void closeAction() {
		this.setVisible(false);
	}

}
