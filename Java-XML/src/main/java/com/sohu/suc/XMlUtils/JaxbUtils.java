package com.sohu.suc.XMlUtils;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;   
import java.io.FileNotFoundException;
import java.io.FileOutputStream;   
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
  
import javax.xml.bind.JAXBContext;   
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;   
import javax.xml.bind.Unmarshaller; 

import com.sohu.suc.JAXB.MessageTemplate;
import com.sohu.suc.JAXB.MessageTemplateInfo;
import com.sohu.suc.JAXB.ObjectFactory;
import com.sohu.suc.JAXB.Pattern;
import com.sohu.suc.JAXB.Patterns;



/**
 * @author Bob
 * @version2012-7-23
 */
public class JaxbUtils {
	
	public static final String DEFAULT_CHARSET_NAME = "GBK";

 void javaToXml() {
 try {

            JAXBContext jc = JAXBContext.newInstance(MessageTemplateInfo.class);    //参数为JAXB生成的java文件所在包名

            ObjectFactory objFactory = new ObjectFactory(); //生成对象工厂

    		MessageTemplateInfo msgTemplates = new MessageTemplateInfo();

            MessageTemplate mt = objFactory.createMessageTemplate();
            
            mt.setConverter("converter");
            mt.setMatcherClass("matcher");
            mt.setParent("parent");
            mt.setParentType("parenttype");
            
            List<Pattern> patterns = new ArrayList<Pattern>();
    		Pattern pattern = new Pattern();
    		pattern.setId("default");
    		pattern.setMatcherMethod("match");
    		pattern.setContent("这是第{0}个测试——{1}。");
    		patterns.add(pattern);
    		

    		mt.setPatternList(patterns);
    		msgTemplates.getMessageTemplate().add(mt);



            Marshaller marshaller = jc.createMarshaller(); 
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
             marshaller.marshal( msgTemplates,new FileOutputStream("test.xml"));

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
 
 @SuppressWarnings("unchecked")
MessageTemplateInfo XmlTojava() throws JAXBException{
	 URL xmlUrl = this.getClass().getResource("/test.xml");
		File demoFile = null;
		try {
			demoFile = new File(xmlUrl.toURI());
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		
			String xml=new String();
			try {
				xml = inputStreamToString(new FileInputStream(demoFile));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(xml);
	        BufferedReader bufferedReader = new BufferedReader(new StringReader(xml));
			
			JAXBContext jc = JAXBContext.newInstance(MessageTemplateInfo.class);    //参数为JAXB生成的java文件所在包名

			Unmarshaller unmarshaller = jc.createUnmarshaller();
			return (MessageTemplateInfo) unmarshaller.unmarshal(bufferedReader);
		 
	 
 }
 
 
 public static String inputStreamToString(InputStream inputStream) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, DEFAULT_CHARSET_NAME));
		StringWriter stringWriter = new StringWriter();
		String lineStr = bufferedReader.readLine();
		boolean readEnd = false;
		while(!readEnd) {
			if(lineStr != null) {
				stringWriter.write(lineStr);
				lineStr = bufferedReader.readLine();
			} else {
				readEnd = true;
			}
		}
		return stringWriter.toString();
	}


}
