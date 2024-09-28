package MainFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import ColorFrame.ColorFrame;
import DateModel.Model;
import FileExplorer.DirectoryChooser;
import FontFrame.FontFrame;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class TablePanel extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private SQLCommand sql;
	private JTextArea textArea;
	private JPopupMenu popupMenu;
	private JLabel label;
	private ReadingPanel readingPanel;

	/**
	 * Create the panel.
	 */
	public TablePanel() {
		panelDefine();
		showAllcontent();
	}
	
	public TablePanel(String s) {
		
	}
	
	public void panelDefine() {
		
		setLayout(new BorderLayout(0, 0));
		
		sql=new SQLCommand();
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(new DefaultTableModel(null,new Object[] {"Number","Id","Content","Date"}));
		table.setFillsViewportHeight(true);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
		table.setBackground(new Color(204, 255, 255));
		table.setFont(new Font(".SF NS Text", Font.PLAIN, 14));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		popupMenu = new JPopupMenu();
		popupMenu.setBackground(new Color(102, 204, 204));
		addPopup(table, popupMenu);
		
		JButton readBttn = new JButton("Read  ");
		readBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readAction();
			}
		});
		popupMenu.add(readBttn);
		
		JButton deleteBttn = new JButton("Delete");
		deleteBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAction();
			}
		});
		popupMenu.add(deleteBttn);
		
		JButton renderingTxt = new JButton("Save to TXT");
		renderingTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderingTxtAction();
			}
		});
		
		JButton btnFontSize = new JButton("Font size");
		btnFontSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FontFrame frame=new FontFrame(table);
			}
		});
		popupMenu.add(btnFontSize);
		popupMenu.add(renderingTxt);
		
		JButton btnColorSetting = new JButton("Color setting");
		btnColorSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColorFrame colorFrame=new ColorFrame(table);
			}
		});
		popupMenu.add(btnColorSetting);
		tableModel=(DefaultTableModel) table.getModel();
		
		
		scrollPane.setViewportView(table);
	}
	
	protected void renderingTxtAction() {
		// TODO Auto-generated method stub
		DirectoryChooser dc=new DirectoryChooser(this);
		String s1=dc.getUri()+"/";
		
		FileOutputStream fos=null;
		OutputStreamWriter osw=null;
		BufferedWriter bw=null;
		
		
		int[]row=table.getSelectedRows();
		for(int i=0;i<row.length;i++) {
			String s2=String.valueOf(table.getValueAt(row[i], 1))+".txt";
			String content=(String) table.getValueAt(row[i], 2);
			
			try {
	
				fos=new FileOutputStream(s1+s2);
				osw=new OutputStreamWriter(fos);
				bw=new BufferedWriter(osw);
				bw.newLine();  bw.newLine(); bw.newLine();
				bw.write(content);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				try {
					bw.close();
					fos.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public  void showAllcontent() {
		
		tableModel.setRowCount(0);
		
		ResultSet rs=sql.selectAll();
		Object[]data=new Object[4];
		
		try {
			for(int i=0;i<table.getRowCount();i++) {
				tableModel.removeRow(i);
			}
			
			while(rs.next()) {
				data[0]=table.getRowCount()+1;
				data[1]=rs.getInt(1);
				data[2]=rs.getString(2);
				data[3]=rs.getString(3);
				
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readAction() {
		int row=table.getSelectedRow();
		String s1=(String) table.getValueAt(row, 3);
		String s2=(String) table.getValueAt(table.getSelectedRow(), 2);
		label.setText(s1);
		textArea.setText(s2);
		readingPanel.setCurrentRow(row);
		popupMenu.setVisible(false);
	}
	
	public void  deleteAction() {
		int[]row=table.getSelectedRows();
		for(int i=0;i<row.length;i++) {
		int id=(int) table.getValueAt(row[i], 1);
		sql.deleteRow(id);
		}
		showAllcontent();
		popupMenu.setVisible(false);
	}

	public JTable getTable() {
		return table;
	}


	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	
	public void setTextArea(JTextArea textArea) {
		this.textArea=textArea;
	}
	
	public void setLabel(JLabel label) {
		this.label=label;
	}
	
	public void setReadingPanel(ReadingPanel readingPanel) {
		this.readingPanel=readingPanel;
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
