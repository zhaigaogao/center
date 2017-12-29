package learn.center.thinkInJava.unit12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
	private BufferedReader in;
	public InputFile(String fname) throws Exception{
		try {
			in=new BufferedReader(new FileReader(fname));
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("Could not open "+fname);
			throw e;
		}catch (Exception e) {
			// TODO: handle exception
			try {
				in.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
			throw e;
		}finally{
			
		}
	}
	public String getLine(){
		String string;
		try {
			string=in.readLine();
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
		return string;
	}
	
	public void dispose(){
		try {
			in.close();
			System.out.println();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
