package learn.center.rmi.learn;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientMain {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		HelloService helloService = (HelloService) Naming.lookup("rmi://localhost:8801/helloService");
		
		System.out.println("RMI 服务器返回结果是： "+helloService.sayHello("zhai"));
	}
}
