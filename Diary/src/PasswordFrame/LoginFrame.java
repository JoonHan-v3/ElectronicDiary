package PasswordFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainFrame.MainFrame;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPassword;
	private String password;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setAlwaysOnTop(true);
		setTitle("Log in ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 72);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		setContentPane(contentPane);
		
		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("If this is the first log in, the password is \"00000\"!");
		txtPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
		contentPane.add(txtPassword, BorderLayout.CENTER);
		
		JButton btnLogin = new JButton("Log in");
		btnLogin.setForeground(new Color(204, 102, 102));
		btnLogin.setBackground(new Color(51, 204, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callMianFrame();
			}
		});
		contentPane.add(btnLogin, BorderLayout.EAST);
	}
	
	public String getPassword() {
		password=txtPassword.getText();
		return password;
	}
	
	public void callMianFrame() {
		SQLCommand sql=new SQLCommand();
		if(getPassword().equals(sql.getPassword())) {
			MainFrame frame=new MainFrame();
			this.hide();
		}else {
			JOptionPane op=new JOptionPane();
			op.showMessageDialog(this, "You input the wrong password! Try it again.", "Wrong Password!", 1);
			txtPassword.setText("");
		}
		
		
	}

}
