package learn.center.thinkInJava.unit18.IOUtils;

import java.util.Map;

public class Copy4File {
	public static void main(String[] args) {
		try {
			Map<String , Object> result = IOUtils.byteRead("H:/我的/软件/isoCentos/CentOS-6.5-x86_64-bin-DVD1.rar");
			IOUtils.ioWriter("I:/功能软件/Linux系统x86/CentOS-6.5-x86_64-bin-DVD1.rar", result.get("data").toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
