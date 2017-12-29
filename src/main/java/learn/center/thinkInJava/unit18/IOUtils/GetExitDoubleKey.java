package learn.center.thinkInJava.unit18.IOUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 获取读取内容中有哪些key是重复的
 * @author zhaieryuan
 * @date 2017年9月21日 上午9:09:05
 */
public class GetExitDoubleKey {
	public static void main(String[] args) throws IOException {
		//读取英文文件内容
		Map<String , Object> enData = IOUtils.ioReader("C:/Users/Administrator/Desktop/mybatisXML/messages_en_US.properties");
		//读取中文文件内容
		Map<String , Object> zhData = IOUtils.ioReader("C:/Users/Administrator/Desktop/mybatisXML/messages_zh_CN.properties");
		
		//获取中文返回给过的数据实体
		@SuppressWarnings("unchecked")
		List<PropertyData> zhDataKey = (List<PropertyData>) zhData.get("data");
		//获取英文返回给过的数据实体
		@SuppressWarnings("unchecked")
		List<PropertyData> enDataKey = (List<PropertyData>) enData.get("data");
		
		/**
		 * 获取中文中重复的集合
		 */
		List<String> zhAgainst = IOUtils.against(zhDataKey);
		
		/**
		 * 获取英文中重复的集合
		 */
		List<String> enAgainst = IOUtils.against(enDataKey);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
		
		System.out.println("中文中重复的有："+zhAgainst.toString());
		System.out.println("--------------------------------");
		System.out.println("英文中重复的有："+enAgainst.toString());
	}
}
