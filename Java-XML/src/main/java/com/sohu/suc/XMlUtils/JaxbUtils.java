package com.sohu.suc.XMlUtils;
import java.io.FileInputStream;   
import java.io.FileOutputStream;   
import java.util.ArrayList;
import java.util.List;
  
import javax.xml.bind.JAXBContext;   
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
	


public void javaToXml() {

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


}
