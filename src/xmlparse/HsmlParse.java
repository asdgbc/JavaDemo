package xmlparse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXTransformerFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * 创建时间：2015年8月20日 下午7:12:10
 * 
 * 项目名称：JavaDemo
 * 
 * @author chenxx@hundsun.com
 * 
 * @version 1.0
 * 
 *          文件名称：HsmlParse.java
 * 
 *          类说明：
 */

public class HsmlParse extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("list")) {
			System.err.println("Start Element:list");
			if (attributes != null) {
				System.err.println("id=" + attributes.getValue("id"));
			}
		} else if (qName.equals("param")) {
			System.out.println("Start Element:param");
			if (attributes != null) {
				System.out.println("id=" + attributes.getValue("id"));
				System.out.println("accBank=" + attributes.getValue("accBank"));
				System.out.println("accName=" + attributes.getValue("accName"));
				System.out.println("accType=" + attributes.getValue("accType"));
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if (qName.equals("list")) {
			System.err.println("End Element:list");
		} else if (qName.equals("param")) {
			System.err.println("End Element:param");
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
	}

	public static void main(String[] args) {
		try {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			parser.parse(new FileInputStream(new File("D:\\hsml.xml")), new HsmlParse());
		} catch (TransformerFactoryConfigurationError | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
