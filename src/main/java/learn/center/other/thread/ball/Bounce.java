package learn.center.other.thread.ball;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Bounce {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new BounceFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
