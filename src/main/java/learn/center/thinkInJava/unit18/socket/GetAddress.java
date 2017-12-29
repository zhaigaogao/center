package learn.center.thinkInJava.unit18.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetAddress {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress  address = InetAddress.getLocalHost();
		String hostName = address.getHostName();
		String ad = address.getHostAddress();
		byte[] hostip=address.getAddress();
		System.out.println(hostName+":"+ad);
		//System.out.println(hostip);
		
		/**
		 * 以下是三种获取主机信息的方法
		 */
		InetAddress address2 =InetAddress.getByName("其他主机名");
		byte[] ip = null;
		String remote = "10.1.0.22";
		ip=remote.getBytes();
		InetAddress address3 =InetAddress.getByAddress("SKY-20151204TVH",ip);
		String remoteName = address3.getHostName();
		System.out.println(remoteName);
		
	}
}
