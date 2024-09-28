package FontFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FontFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblSize;
	private JLabel lblTest;
	private Font font;
	private JSlider slider;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public FontFrame(JComponent txtArea) {
		setAlwaysOnTop(true);
		setBounds(100, 100, 630, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		{
			lblTest = new JLabel("Hello! How are you?");
			contentPanel.add(lblTest, BorderLayout.NORTH);
			font=lblTest.getFont();
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				slider = new JSlider();
				slider.setPaintTicks(true);
				slider.setPaintLabels(true);
				font=txtArea.getFont();
				slider.setValue(font.getSize());
				slider.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						font=new Font(".SF NS Text", Font.PLAIN, slider.getValue());
						lblSize.setText(String.valueOf(slider.getValue()));
						lblTest.setFont(font);
					}
				});
				panel.add(slider, BorderLayout.CENTER);
			}
			{
				JPanel panelLable = new JPanel();
				panel.add(panelLable, BorderLayout.SOUTH);
				{
					JLabel lblNewLabel = new JLabel("Size: ");
					panelLable.add(lblNewLabel);
				}
				{
					lblSize = new JLabel("");
					lblSize.setText(String.valueOf(slider.getValue()));
					panelLable.add(lblSize);
				}
			}
			
			{
				DefaultComboBoxModel model= new DefaultComboBoxModel();
				int []size=new int[95];
				for(int i=5;i<100;i++) {
					model.addElement(i);
					
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtArea.setFont(font);
						closeAction();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						closeAction();
					}
					
				});
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void closeAction() {
		this.setVisible(false);
	}

}
