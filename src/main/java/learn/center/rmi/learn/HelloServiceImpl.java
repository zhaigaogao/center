package learn.center.rmi.learn;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService{

	/** 
	 * 
	 */
	private static final long serialVersionUID = 2190821006339815103L;

	protected HelloServiceImpl() throws RemoteException {
		super();
	}

	public String sayHello(String someOne) throws RemoteException {
		return "Hello,"+someOne;
	}

}
