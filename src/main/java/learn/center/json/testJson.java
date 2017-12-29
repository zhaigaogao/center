package learn.center.json;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
/**
 * 
 * @author zhaieryuan
 * @date 2017年9月21日 上午9:18:21
 */
public class testJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		String array[] = new String[10];
		for(int i=0;i<10;i++){
			paramList.add(i+"                                 *");
			array[i]="array"+i;
		}
		String testString=JSON.toJSONString(paramList);
		
		System.out.println("***********************************");
		for (Object xString:paramList) {
			System.out.println(xString);
		}
		System.out.println("***********************************");
		for(String mString:array){
			System.out.print(mString+" ,");
		}
	}
}
