package learn.center.thinkInJava.unit10.demo03;

public class Sequence {
	
	private Object[] items;
	
	private int next = 0;
	
	public Sequence(int size){
		items=new Object[size];
	}
	
	public void add(Object x){
		if(next < items.length){
			items[next++] = x;
		}
	}
	
	@SuppressWarnings("unused")
	private class SequenceSelector implements Selector{
		
		private int i=0;
		
		public boolean end() {
			
			return i==items.length;
		}

		public Object current() {
			
			return items[i];
		}

		public void next() {
			if(i<items.length){
				i++;
			}
		}
	}
	
	public Selector selector(){
		return new SequenceSelector();
	}
	
}
