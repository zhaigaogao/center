package learn.center.other.thread.task;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Dos {
	public static void main(String[] args) {
		try {
			String cmd = "cmd /c ping baidu.com";  
            Runtime rt = Runtime.getRuntime(); // 获取运行时系统  
            Process proc = rt.exec(cmd); // 执行命令  
            InputStream stderr =  proc.getInputStream(); // 获取输入流  
            InputStreamReader isr = new InputStreamReader(stderr,"UTF-8");  
            BufferedReader br = new BufferedReader(isr);  
            String line = null;  
            while ((line = br.readLine()) != null) { // 打印出命令执行的结果  
                System.out.println(line);  
            }  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
