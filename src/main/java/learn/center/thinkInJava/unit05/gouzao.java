package learn.center.thinkInJava.unit05;

public class gouzao {
	public gouzao() {
		// TODO Auto-generated constructor stub
		System.out.println("我是一个构造函数，你来new我啊！草");
	}
	public gouzao(int x){
		System.out.println("我是第二个"+x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gouzao g=new gouzao();
//		g.toString();
		gouzao g2=new gouzao(3);
	}

}
