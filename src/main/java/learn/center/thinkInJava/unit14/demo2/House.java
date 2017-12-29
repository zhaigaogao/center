package learn.center.thinkInJava.unit14.demo2;

public class House extends Building{
	private String color;
	
	public static void main(String[] args) {
		Building building=new Building();
		House house=new House();
		Class<House> houseClass=House.class;
		house=houseClass.cast(building);
		
	}
}
