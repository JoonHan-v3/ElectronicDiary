package FileExplorer;

import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFileChooser;

import MainFrame.TablePanel;

public class DirectoryChooser{
	private String uri;
	
	public DirectoryChooser(JComponent com) {
		JFileChooser   chooser=new JFileChooser();
		chooser.setVisible(true);
		chooser.setFileSelectionMode(1);
		int result=chooser.showDialog(com, "Save");
		
		if(result==0) {
			uri=chooser.getSelectedFile().getAbsolutePath();
		}
	}
	
	public String getUri() {
		return uri;
		
	}
	

}
