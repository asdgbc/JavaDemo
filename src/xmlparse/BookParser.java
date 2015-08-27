package xmlparse;
import java.io.InputStream;
import java.util.List;

import org.xml.sax.InputSource;

/**
 * 
 * 创建时间：2015年8月20日 下午5:22:48
 * 
 * 项目名称：XmlParseDemo
 * 
 * @author chenxx@hundsun.com
 * 
 * @version 1.0
 * 
 *          文件名称：BookParser.java
 * 
 *          类说明：
 */

public interface BookParser {
	public List<Book> parse(InputStream is) throws Exception;

	public String serialize(List<Book> books) throws Exception;
}
