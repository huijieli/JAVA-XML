package com.sohu.suc.XMlUtils;

import static org.junit.Assert.*;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.sohu.suc.JAXB.MessageTemplate;
import com.sohu.suc.JAXB.MessageTemplateInfo;

/**
 * @author Bob
 * @version2012-7-23
 */
public class JaxbUtilsTest {
	 public static void main( String[] args ) throws JAXBException
	    {
	        
		
		
		JaxbUtils ju=new JaxbUtils();
		//ju.javaToXml();
		
		
		MessageTemplateInfo mti=ju.XmlTojava();
		List<MessageTemplate> list =mti.getMessageTemplate();
		System.out.println(list.get(0).getParent());
	
	}


}
