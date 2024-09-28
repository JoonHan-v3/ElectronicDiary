package DateFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DateModel.Date;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DateFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textYear;
	private JComboBox cbDate;
	private JComboBox cbMonth;
	private JComboBox cbTime;
	private JComboBox cbMinute; 
	private JComboBox cbSecond;
	private Date date= new Date();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public DateFrame(Date dt, JLabel lbl) {
		setAlwaysOnTop(true);
		setResizable(false);
		setBounds(100, 100, 575, 155);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.setVisible(true);
		{
			JLabel lblNewLabel = new JLabel("Year: ");
			contentPanel.add(lblNewLabel);
		}
		{
			textYear = new JTextField();
			textYear.setText("2019");
			contentPanel.add(textYear);
			textYear.setColumns(10);
		}
		{
			JLabel lblMonth = new JLabel("Month: ");
			contentPanel.add(lblMonth);
		}
		{
			cbMonth = new JComboBox();
			cbMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
			cbMonth.setSelectedIndex(date.getMonth());
			contentPanel.add(cbMonth);
		}
		{
			JLabel lblDate = new JLabel("Date: ");
			contentPanel.add(lblDate);
		}
		{
			cbDate = new JComboBox();
			cbDate.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDate.setSelectedIndex(date.getDate()-1);
			contentPanel.add(cbDate);
		}
		{
			JLabel lblTime = new JLabel("Hour: ");
			contentPanel.add(lblTime);
		}
		{
			cbTime = new JComboBox();
			cbTime.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
			cbTime.setSelectedIndex(date.getHour());
			contentPanel.add(cbTime);
		}
		{
			JLabel lblMinute = new JLabel("Minute: ");
			contentPanel.add(lblMinute);
		}
		{
			cbMinute = new JComboBox();
			cbMinute.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
			cbMinute.setSelectedIndex(date.getMinute());
			contentPanel.add(cbMinute);
		}
		{
			JLabel lblSecond = new JLabel("Second: ");
			contentPanel.add(lblSecond);
		}
		{
			cbSecond = new JComboBox();
			cbSecond.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
			cbSecond.setSelectedIndex(date.getScond());
			contentPanel.add(cbSecond);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton doneBttn = new JButton("Done");
				doneBttn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String year=textYear.getText();
						String month=(String) cbMonth.getSelectedItem();
						String date=(String) cbDate.getSelectedItem();
						String hour=(String) cbTime.getSelectedItem();
						String minute=(String) cbMinute.getSelectedItem();
						String second=(String) cbSecond.getSelectedItem();
						
						dt.setDate(year, month, date, hour, minute, second);
						lbl.setText(dt.getTime());
						
						closeAction();
					}
				});
				doneBttn.setActionCommand("OK");
				buttonPane.add(doneBttn);
				getRootPane().setDefaultButton(doneBttn);
			}
			{
				JButton nowBttn = new JButton("Now's time");
				nowBttn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dt.setDefaultDay();
						lbl.setText(dt.getTime());
						closeAction();
					}
				});
				nowBttn.setActionCommand("Cancel");
				buttonPane.add(nowBttn);
			}
		}
	}
	
	public  void closeAction(){
		this.setVisible(false);
	}

}
