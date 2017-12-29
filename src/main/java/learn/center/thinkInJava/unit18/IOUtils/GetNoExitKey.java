package learn.center.thinkInJava.unit18.IOUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 生成在中文内不存在的key
 * @author zhaieryuan
 * @date 2017年9月21日 上午9:02:35
 */
public class GetNoExitKey {
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
		 * 判断英文里面是否有key值
		 * 如果没有将在英文中不存在的key填写到enNoExitsKeys.properties文件中
		 */
		List<String> enNoExitsKeys =IOUtils.compareKey(zhDataKey,enDataKey);
		if(enNoExitsKeys!=null){
			for (String item : enNoExitsKeys) {
				String writeLine = item+"="+"null";
				Map<String , Object> result = IOUtils.ioWriter("C:/Users/Administrator/Desktop/mybatisXML/enNoExitsKeys.properties", writeLine);
				System.out.println(result);
			}
		}
		
		/**
		 * 判断中文里面是否有key值
		 * 如果没有将在英文中不存在的key填写到zhNoExitsKeys.properties文件中
		 */
		List<String> zhNoExitsKeys = IOUtils.compareKey(enDataKey,zhDataKey);
		if(zhNoExitsKeys!=null){
			for (String item : zhNoExitsKeys) {
				String writeLine = item+"="+"null";
				Map<String , Object> result = IOUtils.ioWriter("C:/Users/Administrator/Desktop/mybatisXML/zhNoExitsKeys.properties", writeLine);
				System.out.println(result);
			}
		}
	}
}
