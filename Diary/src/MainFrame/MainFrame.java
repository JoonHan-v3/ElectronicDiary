package MainFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private ReadingPanel readingPanel;
	private WrittingPanel writtingPanel;
	private TablePanel tablePanel;
	private SearchPanel searchPanel;
	private ButtonPanel bttnPanel;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		setContentPane(contentPane);

		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);

		readingPanel = new ReadingPanel();
		splitPane.setLeftComponent(readingPanel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane);

		writtingPanel = new WrittingPanel();
		tabbedPane.addTab("Writting", null, writtingPanel, null);

		tablePanel = new TablePanel();
		tabbedPane.add("Table", tablePanel);

		searchPanel = new SearchPanel();
		tabbedPane.add("Search", searchPanel);
		
		bttnPanel = new ButtonPanel();
		contentPane.add(bttnPanel, BorderLayout.NORTH);
		
		

		setting();
	}

	public void setting() {
		JTextArea textArea = readingPanel.getTextArea();
		JTable table = tablePanel.getTable();

		tablePanel.setTextArea(textArea);
		tablePanel.setReadingPanel(readingPanel);
		readingPanel.setTable(table);
		tablePanel.setReadingPanel(readingPanel);

		JLabel label = readingPanel.getLabel();
		tablePanel.setLabel(label);

		searchPanel.setReadingPanel(readingPanel);
		searchPanel.setTablePanel(tablePanel);

		writtingPanel.setTablePanel(tablePanel);
		
		bttnPanel.setDate(writtingPanel.Date());
		bttnPanel.setLabel(writtingPanel.getLabel());

	}
}
