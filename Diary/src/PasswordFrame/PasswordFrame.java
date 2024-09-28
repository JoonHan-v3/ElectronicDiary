package PasswordFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PasswordFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public PasswordFrame() {
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		contentPanel.setLayout(new GridLayout(2, 2, 0, 0));
		{
			JLabel lblPassword = new JLabel("Enter your password.");
			contentPanel.add(lblPassword);
		}
		{
			txtPassword = new JPasswordField();
			contentPanel.add(txtPassword);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changeAction();					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void changeAction() {
		SQLCommand sql=new SQLCommand();
		if(sql.getPassword().equals(txtPassword.getText())) {			
			PasswordSetting dialog = new PasswordSetting();
			this.setVisible(false);
		}else {
			JOptionPane op=new JOptionPane();
			op.showMessageDialog(this, "Wrong password!. Check it  again.","Erro", 1);
		}

		
	}

}
