package MainFrame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SearchPanel extends JPanel {
	private JTextField textField;
	private ReadingPanel readingPanel;
	private TablePanel tablePanel;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		JButton searchBttn = new JButton("Search");
		searchBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchAction();
			}
		});
		panel.add(searchBttn);

	}

	public void searchAction() {
		try {
			int id1 = Integer.parseInt(textField.getText());

			for (int i = 0; i < tablePanel.getTable().getRowCount(); i++) {
				int id2 = (int) tablePanel.getTable().getValueAt(i, 1);
				if (id1 == id2) {
					readingPanel.getTextArea().setText((String) tablePanel.getTable().getValueAt(i, 2));
					readingPanel.getLabel().setText((String) tablePanel.getTable().getValueAt(i, 3));
					readingPanel.setCurrentRow(i);
					return;
				} else {
					readingPanel.getLabel().setText("There  is no result!");
					readingPanel.getTextArea().setText("");
				}
			}
		} catch (Exception e) {
			readingPanel.getLabel().setText("Input just number!");
		}

	}

	public void setReadingPanel(ReadingPanel readingPanel) {
		this.readingPanel = readingPanel;
	}

	public void setTablePanel(TablePanel tablePanel) {
		this.tablePanel = tablePanel;
	}
}
