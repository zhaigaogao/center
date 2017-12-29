package learn.center.mq.utils;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

public class ConnectionManager {
	private static final Logger log = Logger.getLogger(ConnectionManager.class);
	
	/**
	 * 
	 * @param object
	 * @return
	 * @author zhaieryuan
	 * @date 2017年10月10日 下午5:41:35
	 */
	public static MessageProducer sendMessage(String quene){
		ConnectionFactory connectionFactory;
		Connection connection;
		Session session;
		Destination destination;
		MessageProducer producer = null;
		
		connectionFactory = new ActiveMQConnectionFactory("admin","admin","tcp://192.168.3.159:61616");
		try {
			log.info("开始连接");
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			destination = session.createQueue(quene);
			producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return producer;
	}
	
	public static void main(String[] args) {
		MessageProducer producer = sendMessage("yuan");
		//producer.send("2017/10/10");
	}
	
}
