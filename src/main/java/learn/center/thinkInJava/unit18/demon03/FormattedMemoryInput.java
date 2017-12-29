package learn.center.thinkInJava.unit18.demon03;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {
	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(
				new ByteArrayInputStream( 
						BufferedInputFile.read("E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/test.txt").getBytes()
						));
		while(true){
			System.out.print((char)in.readByte());
		}
	}
}
