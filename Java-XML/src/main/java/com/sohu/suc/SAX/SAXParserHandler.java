package com.sohu.suc.SAX;

import java.io.InputStream;
import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sohu.suc.person.PersonBean;

/**
 * @author Bob
 * @version2012-7-19
 */
public class SAXParserHandler extends DefaultHandler{
	private Vector<PersonBean> person_vector=null;
	private PersonBean person = null;  
    private String preTag = null;//作用是记录解析时的上一个节点名称 
    
    public Vector<PersonBean> getPersons(InputStream xmlStream) throws Exception{  
        SAXParserFactory factory = SAXParserFactory.newInstance();  
        SAXParser parser = factory.newSAXParser();  
        SAXParserHandler handler = new SAXParserHandler();  
        parser.parse(xmlStream, handler);  
        return handler.person_vector;  
    }  
    @Override  
    
    public void startDocument() throws SAXException {  
    	person_vector = new Vector<PersonBean>();  
    }  
    
    @Override  
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {  
        if("person".equals(qName)){  
            person = new PersonBean();  
            person.setSex(String.valueOf(attributes.getValue(0)));
        }  
        preTag = qName;//将正在解析的节点名称赋给preTag  
    }  
    
    @Override  
    public void endElement(String uri, String localName, String qName)  
            throws SAXException {  
        if("person".equals(qName)){  
            person_vector.add(person);  
            person = null;  
        }  
        preTag = null;//一定要有
    }
        
    @Override  
    public void characters(char[] ch, int start, int length) throws SAXException {  
        if(preTag!=null){  
            String content = new String(ch,start,length);  
            if("name".equals(preTag)){  
                person.setName(content);  
            }else if("age".equals(preTag)){  
                person.setAge(Integer.parseInt(content));  
            }else if("phone".equals(preTag)){  
                person.setPhone(content);  
        }  
        
        
        
    }  
    
    }
}
