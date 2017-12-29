package learn.center.thinkInJava.unit12;

import javax.management.RuntimeErrorException;

public class DynamicFields {
	
	private Object[][] fields;
	
	public DynamicFields(int initialSize){
		fields=new Object[initialSize][2];
		for(int i=0;i<initialSize;i++){
			fields[i]=new Object[] {null,null};
		}
	}
	public String toString(){
		StringBuilder result=new StringBuilder();
		for(Object[] obj:fields){
			result.append(obj[0]);
			result.append(": ");
			result.append(obj[1]);
			result.append("\n");
		}
		return result.toString();
	}
	public int hasFields(String id){
		for(int i=0;i<fields.length;i++){
			if(id.equals(fields[i][0])){
				return i;
			}
		}
		return -1;
	}
	public int getFieldNumber(String id) throws NoSuchFieldException{
		int fieldnum=hasFields(id);
		if(fieldnum==-1){
			throw new NoSuchFieldException();
		}
		return fieldnum;
	}
	public int makeField(String id){
		for (int i = 0; i < fields.length; i++) {
			if(fields[i][0] == null){
				fields[i][0]=id;
			}
			return i;
		}
		Object[][] tmp=new Object[fields.length][2];
		for (int i = 0; i < fields.length; i++) {
			tmp[i] = fields[i];
		}
		for (int i = fields.length; i < tmp.length; i++) {
			tmp[i]=new Object[]{null,null};
		}
		fields = tmp;
		return makeField(id);
	}
	
	public Object getField(String id) throws NoSuchFieldException{
		return fields[getFieldNumber(id)][1];
	}
	
	public Object setField(String id,Object value) throws DynamicFieldException{
		if(value == null){
			DynamicFieldException dfe=new DynamicFieldException();
			dfe.initCause(new NullPointerException());
			throw dfe;
		}
		int fieldNumber = hasFields(id);
		if(fieldNumber == -1){
			fieldNumber =makeField(id);
		}
		Object result =null;
		try {
			result=getField(id);
		} catch (NoSuchFieldException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		fields[fieldNumber][1] = value;
		return result;
	}
	
	public static void main(String[] args) {}
}
