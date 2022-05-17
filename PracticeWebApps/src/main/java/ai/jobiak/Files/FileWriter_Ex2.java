package ai.jobiak.Files;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Ex2 {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw=new FileWriter("output.txt");
		fw.write(97);//a
		char[ ] t= {'p','p'};
		fw.write(t);
		fw.write("le");
		fw.write("ghhh");
	//	fw.write(10);
		fw.close();
		System.out.println("data successful");
		

	}

}
