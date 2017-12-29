package learn.center.other.thread.ball;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BallComponent extends JPanel{
	/** 
	 * 序列值
	 */
	private static final long serialVersionUID = -8621610108755549405L;
	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 350;
	
	ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public void add(Ball ball){
		balls.add(ball);
	}
	
	public void painComponent(Graphics graphics){
		super.paintComponent(graphics);
		Graphics2D g2=(Graphics2D)graphics;
		
		for(Ball item : balls){
			g2.fill(item.getShape());
		}
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}
