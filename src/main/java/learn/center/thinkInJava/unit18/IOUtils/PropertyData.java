package learn.center.thinkInJava.unit18.IOUtils;

import java.io.Serializable;

/**
 * 数据存储类
 * @author zhaieryuan
 * @date 2017年9月18日 下午12:46:30
 */
public class PropertyData implements Serializable{

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = -3676904405282784004L;
	
	private String Key;
	
	private String Value;

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	/**
	 * toString方法
	 */
	@Override
	public String toString() {
		return "PropertyData [Key=" + Key + ", Value=" + Value + "]";
	}
	
}
