package learn.center.thinkInJava.unit05.Array;

public class InitArray {
	public static void main(String[] args) {
		int[] array01={1,2,3,4,5,12,22};
		int[] array02;
		array02=array01;
		array02[0]=array02[0]+1;
		System.out.println(array01[0]);
	}
}
