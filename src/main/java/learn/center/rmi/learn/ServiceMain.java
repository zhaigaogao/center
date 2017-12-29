package learn.center.rmi.learn;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServiceMain {
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		//创建服务
		HelloService helloService = new HelloServiceImpl();
		
		//注册服务
		LocateRegistry.createRegistry(8801);
		
		Naming.bind("rmi://localhost:8801/helloService", helloService);
		
		System.out.println("ServeMain provide RPC Service now");
	}
}
