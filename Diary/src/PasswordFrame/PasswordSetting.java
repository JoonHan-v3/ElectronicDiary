package PasswordFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PasswordSetting extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField txtNewPassword;
	private JPasswordField txtConfirm;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public PasswordSetting() {
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 221);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		contentPanel.setLayout(new GridLayout(4, 4, 0, 0));
		{
			JLabel lblNewPassword = new JLabel("New password:");
			contentPanel.add(lblNewPassword);
		}
		{
			txtNewPassword = new JPasswordField();
			contentPanel.add(txtNewPassword);
		}
		{
			JLabel lblConfirm = new JLabel("Confirm: ");
			contentPanel.add(lblConfirm);
		}
		{
			txtConfirm = new JPasswordField();
			contentPanel.add(txtConfirm);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changePasswordAction();
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
	
	public void changePasswordAction() {
		if(!txtNewPassword.getText().equals("")) {
			if(txtNewPassword.getText().equals(txtConfirm.getText())) {
				SQLCommand sql=new SQLCommand();
				sql.update(txtNewPassword.getText());
				setVisible(false);
			}else {
				JOptionPane op=new JOptionPane();
				op.showMessageDialog(this, "The  new password  and  the confirm aren't same. Check it  again.","Erro", 1);
			}
		}else {
			JOptionPane op=new JOptionPane();
			op.showMessageDialog(this, "Input new password. Check it  again.","Erro", 1);
		}
	}
}


