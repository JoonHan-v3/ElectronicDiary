package FileExplorer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
	public FileChooser(){
	JFileChooser fc=new JFileChooser();
	
	fc.setFileFilter(new FileNameExtensionFilter("txt","All txt  File"));
	int result=fc.showOpenDialog(fc);
	
	
	
	
	if(result==0) {
		try {
			Scanner scan = new Scanner(new FileReader(fc.getSelectedFile().getAbsolutePath()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileChooser  fc=new FileChooser();
	}

}
