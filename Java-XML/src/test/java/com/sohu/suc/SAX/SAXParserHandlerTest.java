
package com.sohu.suc.SAX;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Vector;

import com.sohu.suc.SAX.SAXParserHandler;
import com.sohu.suc.XML.DefaultDealXML;
import com.sohu.suc.XML.DefaultDealXMLFactory;
import com.sohu.suc.person.PersonBean;

import junit.framework.TestCase;

/**
 * @author Bob
 * @version2012-7-19
 */
public class SAXParserHandlerTest extends TestCase {
	
	public void testSAX() throws Throwable{  
		SAXParserHandler sax = new SAXParserHandler();  
		
		
		
        InputStream input =new FileInputStream("Input.xml"); 
    	 Vector<PersonBean> person_vector=sax.getPersons(input); 
    	 DefaultDealXML xmltest=DefaultDealXMLFactory.getDefaultDealXML();
    	 xmltest.writeXMLFile("Output4.xml", person_vector);
        }  
    }  

