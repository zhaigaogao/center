package learn.center.other.thread.ball;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
	private static final int XSIZE=15;
	
	private static final int YSIZE=15;
	
	private double x = 0;
	
	private double y = 0;
	
	private double dx = 1;
	
	private double dy = 1;
	
	/**
	 * 圆球运动轨迹方法
	 * @param bounds
	 * @author zhaieryuan
	 * @date 2017年11月29日 下午5:18:30
	 */
	public void move(Rectangle2D bounds){
		x += dx;
		y += dy;
		if(x<bounds.getMinX()){
			x=bounds.getMaxX();
			dx=-dx;
		}
		if(x + XSIZE >= bounds.getMaxX()){
			x=bounds.getMaxX()-XSIZE;
			dx=-dx;
		}
		if(y<bounds.getMinY()){
			y=bounds.getMaxY();
			dy=-dy;
		}
		if(y + YSIZE >= bounds.getMaxY()){
			y=bounds.getMaxY()-YSIZE;
			dy=-dy;
		}
	}
	
	/**
	 * 设置球的形状
	 * @return
	 * @author zhaieryuan
	 * @date 2017年11月29日 下午5:18:13
	 */
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}
}
