package learn.center.thinkInJava.unit18.demon06;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
	static String file="rtest.dat";
	static void display() throws IOException{
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		for(int i=0;i<7;i++){
			System.out.println("value "+i+": "+rf.readDouble());
		}
		System.out.println(rf.readUTF());
		rf.close();
	}
	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		for (int i = 0; i < 7; i++) {
			rf.writeDouble(i+1.44);
		}
		rf.writeUTF("老翟你好啊！，你想喝点什么呢？喝奶还是喝茶，还是想啪啪啪!");
		rf.close();
		display();
		rf=new RandomAccessFile(file, "rw");
		rf.seek(5*8);
		rf.writeDouble(47.0001);
		rf.close();
		display();
 	}
}
