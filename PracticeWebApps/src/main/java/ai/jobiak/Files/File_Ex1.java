package ai.jobiak.Files;
import java.io.*;
public class File_Ex1 {
	public static void main(String[] args) throws Exception{
	
		//creation  of directory
		File f=new File("Group");//
		f.mkdir();
		System.out.println("directory created !");
		
		File f1=new File("input.txt");
		f1.createNewFile();
		System.out.println("file created !");
		
		File f2=new File(f,"output.txt");
		f2.createNewFile();
		System.out.println("file created inside directory !");
	
	}

}
