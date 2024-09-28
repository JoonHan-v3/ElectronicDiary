package MainFrame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import ColorFrame.ColorFrame;
import FontFrame.FontFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.awt.Font;
import javax.swing.JInternalFrame;

public class ReadingPanel extends JPanel {
	
	private JTextArea txtArea;
	private JTable table;
	private JLabel label;
	private int currentRow;
	private JButton nextBttn;
	private JButton backBttn;
	private JButton updateBttn;
	private SQLCommand sql;
	private JPopupMenu popupMenu;
	private JButton rewriteBttn;
	private JButton clearBttn;
	private JButton btnFontSize;
	private JButton colorBttn;
	private JButton btnTxt;
	/**
	 * Create the panel.
	 */
	public ReadingPanel() {
		panelDefine();

	}
	
	public void panelDefine() {
		setLayout(new BorderLayout(0, 0));
		
		sql=new SQLCommand();
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		txtArea = new JTextArea();
		txtArea.setBackground(new Color(204, 255, 255));
		txtArea.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
		txtArea.setWrapStyleWord(true);
		txtArea.setEditable(false);
		txtArea.setLineWrap(true);
		txtArea.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				String s=txtArea.getText();
				if(s.equals("")) {
					rewriteBttn.setEnabled(false);
				}else {
					rewriteBttn.setEnabled(true);
				}
			}
		});
		scrollPane.setViewportView(txtArea);
		
		label = new JLabel("");
		scrollPane.setColumnHeaderView(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		add(panel, BorderLayout.SOUTH);
		
		
		backBttn = new JButton("Back");
		backBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backAction();
			}
		});
		panel.add(backBttn);
		
		
		updateBttn = new JButton("Update");
		updateBttn.setEnabled(false);
		updateBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAction();
			}
		});
		panel.add(updateBttn);
		
		
		nextBttn = new JButton("Next");
		nextBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextAction();
			}
		});
		panel.add(nextBttn);
		
		
		popupMenu = new JPopupMenu();
		popupMenu.setBackground(new Color(0, 204, 204));
		addPopup(txtArea, popupMenu);
		
		rewriteBttn = new JButton("Rewrite         ");
		rewriteBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rewriteAction();
			}
		});
		popupMenu.add(rewriteBttn);
		
		clearBttn = new JButton("Clear             ");
		clearBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAction();
			}
		});
		popupMenu.add(clearBttn);
		
		btnFontSize = new JButton("Font size");
		btnFontSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FontFrame fontFrame=new FontFrame(txtArea);
			}
		});
		popupMenu.add(btnFontSize);
		
		colorBttn = new JButton("Color setting ");
		colorBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColorFrame sf=new ColorFrame(txtArea);
				
			}
		});
		popupMenu.add(colorBttn);
		
		btnTxt = new JButton("Save to  text");
		btnTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream fos=null;
				OutputStreamWriter osw=null;
				BufferedWriter bw=null;
			}
		});
		popupMenu.add(btnTxt);
	}
	
	protected void backAction() {
		// TODO Auto-generated method stub
		currentRow--;
		
		if(currentRow>=0) {
			String s1=(String) table.getValueAt(currentRow, 2);
			String s2=(String) table.getValueAt(currentRow, 3);
			txtArea.setText(s1);
			label.setText(s2);
			nextBttn.setEnabled(true);
		}else {
			label.setText("There is no information to show!");
			txtArea.setText("");
			backBttn.setEnabled(false);
		}
		
		updateBttn.setEnabled(false);
	}

	protected void nextAction() {
		currentRow++;
		int rowCount=table.getRowCount();
		
		if(currentRow<rowCount) {
			String s=(String) table.getValueAt(currentRow, 2);
			String s2=(String) table.getValueAt(currentRow, 3);
			txtArea.setText(s);
			label.setText(s2);
			backBttn.setEnabled(true);
		}else {
			label.setText("There is no information to show!");
			txtArea.setText("");
			nextBttn.setEnabled(false);
		}	
		
		updateBttn.setEnabled(false);
	}
	
	protected  void updateAction() {
		String s=txtArea.getText();
		int id=(int) table.getValueAt(currentRow, 1);
		sql.update(id, s);
		table.setValueAt(s, currentRow, 2);
		txtArea.setEditable(false);
		updateBttn.setEnabled(false);
	}
	
	protected void rewriteAction() {
		txtArea.setEditable(true);
		updateBttn.setEnabled(true);
		popupMenu.setVisible(false);
	}
	
	protected void clearAction() {
		txtArea.setText("");
		label.setText("");
		popupMenu.setVisible(false);
	}
	
	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public JTextArea getTextArea() {
		return txtArea;
	}
	
	
	public void setTable(JTable table) {
		this.table=table;
	}
	
	public JLabel getLabel(){
		return label;
		
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
}
