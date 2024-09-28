package MainFrame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ColorFrame.ColorFrame;
import DateModel.Date;
import DateModel.Model;
import FontFrame.FontFrame;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;

public class WrittingPanel extends JPanel {
	
	private JTextArea txtArea;
	private JLabel label;
	private Date date;
	private Model model;
	private SQLCommand sql;
	private  TablePanel tablePanel;

	/**
	 * Create the panel.
	 */
	public WrittingPanel() {
		setLayout(new BorderLayout(0, 0));
		
		sql=new SQLCommand();
		date=new Date();
		model=new Model(date,"");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		txtArea = new JTextArea();
		txtArea.setWrapStyleWord(true);
		txtArea.setBackground(new Color(204, 255, 255));
		txtArea.setLineWrap(true);
		txtArea.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
		txtArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idWatcher();
			}
		});
		scrollPane.setViewportView(txtArea);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBackground(new Color(0, 204, 204));
		addPopup(txtArea, popupMenu);
		
		JMenuItem mntmFontSetting = new JMenuItem("Font size");
		mntmFontSetting.setBackground(new Color(0, 204, 204));
		mntmFontSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FontFrame fontFrame=new FontFrame(txtArea);
			}
		});
		popupMenu.add(mntmFontSetting);
		
		JMenuItem mntmColor = new JMenuItem("Color setting");
		mntmColor.setBackground(new Color(0, 204, 204));
		mntmColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColorFrame sf=new ColorFrame(txtArea);
			}
		});
		popupMenu.add(mntmColor);
		
		JMenuItem mntmClear = new JMenuItem("Clear");
		mntmClear.setBackground(new Color(0, 204, 204));
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArea.setText("");
			}
		});
		popupMenu.add(mntmClear);
		
		label = new JLabel("");
		label.setText(date.getTime());
		scrollPane.setColumnHeaderView(label);
		
		JButton saveBttn = new JButton("Save");
		saveBttn.setBackground(new Color(255, 240, 245));
		saveBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveAction();
			}
			
		});
		add(saveBttn, BorderLayout.SOUTH);
		

	}
	
	
	
	public void nullMessage() {
		JOptionPane optionPane=new  JOptionPane();
		optionPane.showMessageDialog(this,"Fill the content!","Message", 1);
	}
	
	
	
	public void saveAction() {
		String s=txtArea.getText();
		Model model=new Model(date,s);
		
		
		SQLCommand sql=new SQLCommand();
		
		if(s.equals("")) {
			this.nullMessage();
		}
		else {
			sql.addDiary(model.getId(), model.getContent(), label.getText());
			tablePanel.showAllcontent();
		}
	}
	
	public void idWatcher() {
		int id=model.getId();
		ResultSet rs=sql.searchResult(id);
		
		try {
			if(rs.next()) {
				JOptionPane optionPane=new  JOptionPane();
				optionPane.showMessageDialog(this,"There exist the same id. You can update the content.","Message", 1);
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setTablePanel(TablePanel tablePanel) {
		this.tablePanel=tablePanel;
	}
	

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public Date Date() {
		return date;
	}



	public JLabel getLabel() {
		return label;
	}
	
}
