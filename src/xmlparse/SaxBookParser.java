package xmlparse;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * 创建时间：2015年8月20日 下午5:24:14
 * 
 * 项目名称：XmlParseDemo
 * 
 * @author chenxx@hundsun.com
 * 
 * @version 1.0
 * 
 *          文件名称：SaxBookParser.java
 * 
 *          类说明：
 */

public class SaxBookParser implements BookParser {

	public List<Book> parse(InputStream is) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		BookHandler handler = new BookHandler();
		parser.parse(is, handler);
		return handler.getBooks();
	}

	@Override
	public String serialize(List<Book> books) throws Exception {
		SAXTransformerFactory factory = (SAXTransformerFactory) TransformerFactory.newInstance();
		TransformerHandler handler = factory.newTransformerHandler();// 从factory获取TransformerHandler实例
		Transformer transformer = handler.getTransformer();// 从handler获取Transformer
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");// 设置输出采用的编码方式
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");// 是否自动贪污额外的空白
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");// 是否忽略XML声明
		
		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		handler.setResult(result);
		
		String uri = "";
		String localName = "";
		
		handler.startDocument();
		handler.startElement(uri, localName, "books", null);
		AttributesImpl attrs = new AttributesImpl();//负责存放元素的属性信息
		char[] ch = null;
		for (Book book : books) {
			attrs.clear();
			attrs.addAttribute(uri, localName, "id", "string", String.valueOf(book.getId()));
			handler.startElement(uri, localName, "book", attrs);
		}
		
		return null;
	}

	class BookHandler extends DefaultHandler {
		private List<Book> books;
		private Book book;
		private StringBuilder builder;

		public List<Book> getBooks() {
			return books;
		}

		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			books = new ArrayList<Book>();
			builder = new StringBuilder();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			if (qName.equals("book")) {
				book = new Book();
			}
			builder.setLength(0);
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			super.characters(ch, start, length);
			builder.append(ch, start, length);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			super.endElement(uri, localName, qName);
			if (qName.equals("id")) {
				book.setId(Integer.parseInt(builder.toString()));
			} else if (qName.equals("name")) {
				book.setName(builder.toString());
			} else if (qName.equals("price")) {
				book.setPrice(Float.parseFloat(builder.toString()));
			} else if (qName.equals("book")) {
				books.add(book);
			}
		}
	}

	public static void main(String[] args) {
		SaxBookParser parser = new SaxBookParser();
		try {
			List<Book> list = parser.parse(new FileInputStream(new File("D:\\books.xml")));
			if (list!=null&&list.size()!=0) {
				for (int j = 0; j < list.size(); j++) {
					System.out.println(list.get(j));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
