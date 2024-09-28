package Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class T3 {
	public  T3() {
	File file=new File("/Users/napoleonponapart/Workspaces/MyEclipse CI/Diary/diary.TXt/go.txt");
	try {
		FileWriter writer=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(writer);
		bw.write("go");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T3 t=new T3();
		
	}

}
