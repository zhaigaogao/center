package learn.center.other.thread.ball;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceFrame extends JFrame{
	
	/** 
	 * 序列号
	 */
	private static final long serialVersionUID = -580255480495885904L;

	private BallComponent comp;
	
	public static final int STEPS = 1000;
	
	public static final int DELAY = 3;
	
	public BounceFrame(){
		setTitle("翟二远");
		comp = new BallComponent();
		add(comp,BorderLayout.CENTER);
		JPanel button = new JPanel();
		addButton(button,"开始",event -> addBall());
		addButton(button,"关闭",event -> System.exit(0));
		add(button,BorderLayout.SOUTH);
		pack();
	}
	
	public void addButton(Container c,String title,ActionListener listener){
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	public void addBall(){
		Runnable runnable =() ->{
			try {
				Ball ball = new Ball();
				
				comp.add(ball);
				for(int i=1;i<=STEPS;i++){
					ball.move(comp.getBounds());
					comp.paint(comp.getGraphics());
					Thread.sleep(DELAY);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
