package learn.center.json;

public class subString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String imgUrl="69123456,S142000001671232,554545447445";
		String a[]=imgUrl.split(",");
		int end=imgUrl.indexOf(",");
		StringBuilder stringBuilder=new StringBuilder();
		System.out.println(a.length);
		for(int i=0;i<a.length;i++){
			stringBuilder.append("'"+a[i]+"',");
		}
		
		System.out.println();
	}

}
