package learn.center.thinkInJava.unit18.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * IO读写工具类
 * @author zhaieryuan
 * @date 2017年9月18日 下午12:35:18
 */
public class IOUtils {
	
	/**
	 * 字节输入流
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @author zhaieryuan
	 * @date 2017年9月18日 下午12:34:54
	 */
	public static Map<String , Object> byteRead(String fileName) throws IOException{
		Map<String , Object> result = new HashMap<String, Object>();
		File file = new File(fileName);
		try {
			FileInputStream in = new FileInputStream(file);	
			int index;
			byte[] buf = new byte[23];
			List<String> list = new LinkedList<String>();
			while((index=in.read(buf))!=-1){
				System.out.print(new String(buf,0,index));
				list.add(buf.toString());
			}
			in.close();
			result.put("message", "读取成功");
			result.put("success", "true");
			result.put("data", list.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			result.put("message", "指定文件不存在");
			result.put("success", "false");
		}
		return result;
	}
	
	/**
	 * 字节输出流
	 * @param fileName
	 * @param content
	 * @return
	 * @throws IOException
	 * @author zhaieryuan
	 * @date 2017年9月18日 下午12:34:39
	 */
	public static Map<String , Object> byteWrite(String fileName,String content) throws IOException{
		Map<String , Object> result = new HashMap<String, Object>();
		File file = new File(fileName);
		try {
			FileOutputStream out = new FileOutputStream(file,true);
			byte[] buf = content.getBytes();
			System.out.println(buf.length);
			out.write(buf);
			out.close();
			result.put("message", "读取成功");
			result.put("success", "true");
			result.put("data", new String(buf));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			result.put("message", "指定文件不存在");
			result.put("success", "false");
		}
		return result;
	}
	
	/**
	 * ioWriter
	 * @param filename
	 * @param content
	 * @return
	 * @throws IOException
	 * @author zhaieryuan
	 * @date 2017年9月18日 下午12:34:24
	 */
	public static Map<String , Object> ioWriter(String filename,String content) throws IOException{
		Map<String , Object> result = new HashMap<String, Object>();
		File file = new File(filename);
		FileWriter fileWriter = new FileWriter(file,true);
		fileWriter.write(content+"\r\n");
		fileWriter.close();
		result.put("message", "读取成功");
		result.put("success", "true");
		result.put("data", content);
		return result;
	}
	
	/**
	 * ioreader
	 * @param filename
	 * @return
	 * @throws IOException
	 * @author zhaieryuan
	 * @date 2017年9月18日 下午12:33:57
	 */
	public static Map<String , Object> ioReader(String filename) throws IOException{
		Map<String , Object> result = new HashMap<String, Object>();
		File file = new File(filename);
		FileReader fileReader = new FileReader(file);
		String line;
		BufferedReader br = new BufferedReader(fileReader);
		List<PropertyData> dataKey = new LinkedList<PropertyData>();
		while((line=br.readLine())!=null){
			if(line.indexOf("=")!=-1){
				PropertyData param = new PropertyData();
				String subStr[] = line.split("="); 
				String key = subStr[0];
				String value = subStr[1];
				param.setKey(key);
				param.setValue(value);
				dataKey.add(param);
			}else {
				System.out.println(line+":不规则字符串跳过！");
			}
		}
		fileReader.close();
		result.put("message", "读取成功");
		result.put("success", "true");
		result.put("data", dataKey);
		return result;
	}
	
	/**
	 * 按照行读取
	 * @param filename
	 * @return
	 * @throws IOException
	 * @author zhaieryuan
	 * @date 2017年9月18日 下午12:33:26
	 */
	@SuppressWarnings("deprecation")
	public static Map<String , Object> ioLineNumberInputSreeam(String filename) throws IOException{
		Map<String , Object> result = new HashMap<String, Object>();
		File file = new File(filename);
		FileInputStream in = new FileInputStream(file);
		LineNumberInputStream lineNumberInputStream = new LineNumberInputStream(in);
		int length;
		StringBuilder sb = new StringBuilder();
		while((length=lineNumberInputStream.read())!=-1){
			System.out.println((char)length);
			sb.append((char)length);
		}
		lineNumberInputStream.close();
		result.put("message", "读取成功");
		result.put("success", "true");
		result.put("data", sb.toString());
		return result;
	}
	
	/**
	 * 比较两边key值是佛存在
	 * @param zhDataKey
	 * @param enDataKey
	 * @return
	 * @author zhaieryuan
	 * @date 2017年9月20日 下午3:02:27
	 */
	public static List<String> compareKey(List<PropertyData> zhDataKey,List<PropertyData> enDataKey){
		List<String> noExitsKeys = new ArrayList<String>();
		List<String> zhList = new ArrayList<String>();
		for (PropertyData item : zhDataKey) {
			zhList.add(item.getKey());
		}
		for (PropertyData item : enDataKey) {
			if(zhList.contains(item.getKey())){
				
			}else {
				noExitsKeys.add(item.getKey());
			}
		}
		return noExitsKeys;
	}
	
	
	/**
	 * 判断哪些key是重复的
	 * @param args
	 * @throws IOException
	 * @author zhaieryuan
	 * @date 2017年9月20日 下午4:37:55
	 */
	public static List<String> against(List<PropertyData> zhDataKey){
		List<String> noExitsKeys = new ArrayList<String>();
		List<String> zhList = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		for (PropertyData item : zhDataKey) {
			if(builder.indexOf(","+item.getKey()+",") > -1) {  
                System.out.println("重复的有："+item.getKey());
                noExitsKeys.add(item.getKey());
            } else {  
                builder.append(",").append(item.getKey()).append(",");  
            }  
		}
		return noExitsKeys;
	}
	
	public static void main(String[] args) throws IOException {
		//读取英文文件内容
		Map<String , Object> enData = ioReader("C:/Users/Administrator/Desktop/mybatisXML/messages_en_US.properties");
		//读取中文文件内容
		Map<String , Object> zhData = ioReader("C:/Users/Administrator/Desktop/mybatisXML/messages_zh_CN.properties");
		
		//获取中文返回给过的数据实体
		@SuppressWarnings("unchecked")
		List<PropertyData> zhDataKey = (List<PropertyData>) zhData.get("data");
		//获取英文返回给过的数据实体
		@SuppressWarnings("unchecked")
		List<PropertyData> enDataKey = (List<PropertyData>) enData.get("data");
		
		
		/**
		 * 业务逻辑处理
		 * 按照中文给出的等号左侧字符串进行遍历排序
		 */
		List<PropertyData> outPutData = new LinkedList<PropertyData>();   //定义要排序号的返回数据类型
		for(PropertyData zhItem : zhDataKey){
			for(PropertyData enItem : enDataKey){
				if(zhItem.getKey().equals(enItem.getKey())){
					outPutData.add(enItem);
				}
			}
		}
		//执行写入操作
		for(PropertyData write : outPutData){
			String writeLine = write.getKey()+"="+write.getValue();
			Map<String , Object> result = ioWriter("C:/Users/Administrator/Desktop/mybatisXML/write.properties", writeLine);
			System.out.println(result);
		}
		
	}
}
