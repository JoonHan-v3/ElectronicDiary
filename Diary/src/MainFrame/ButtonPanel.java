package MainFrame;

import javax.swing.JPanel;

import DateFrame.DateFrame;
import DateModel.Date;
import PasswordFrame.PasswordFrame;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonPanel extends JPanel {
	private Date date;
	private JLabel label;

	/**
	 * Create the panel.
	 */
	public ButtonPanel() {
		
		JButton dateBttn = new JButton("Date setting");
		dateBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFrame df=new DateFrame(date,label);
			}
		});
		add(dateBttn);
		
		JButton explorerBttn = new JButton("File explorer");
		add(explorerBttn);
		
		JButton btnPasswordSetting = new JButton("Change password");
		btnPasswordSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordFrame dialog = new PasswordFrame();
			}
		});
		add(btnPasswordSetting);

	}
	
	public void setDate(Date date) {
		this.date=date;
	}
	
	public void setLabel(JLabel label) {
		this.label=label;
	}

}
