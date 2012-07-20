package com.sohu.suc.XMlUtils;

import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.sohu.suc.person.PersonBean;

/**
 * XML解析工具类
 * 
 * @author Bob
 * @version2012-7-20
 */
public class XMLUtils {
	
	
	 /**
	 * 取XML根元素
	 * @returnElement
	 */
	public  Element getRoot(String fileName){  
		 DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=null; 
		 try {
				db=dbf.newDocumentBuilder();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Document doc=null;
			
			try {
				doc=db.parse(fileName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Element root=doc.getDocumentElement();
	        return root;  
	    }  
	
	
	
		 /**
		 * 取文件元素信息,返回Vector<PersonBean>
		 */
		public Vector<PersonBean> getElementInfo(Element root){
			Vector<PersonBean> person_vector=new Vector<PersonBean>();
			 NodeList persons=root.getElementsByTagName("person");
				
				for(int i=0;i<persons.getLength();i++){
				Element person=(Element)persons.item(i);
				PersonBean personBean=new PersonBean();
				
				personBean.setSex(person.getAttribute("sex"));
				
				NodeList names=person.getElementsByTagName("name");
				if(names.getLength()==1){
					Element e=(Element)names.item(0);
					Text t=(Text)e.getFirstChild();
					personBean.setName(t.getNodeValue());	
				}
				NodeList ages=person.getElementsByTagName("age");
				if(names.getLength()==1){
					Element e=(Element)ages.item(0);
					Text t=(Text)e.getFirstChild();
					personBean.setAge(Integer.parseInt(t.getNodeValue()));
				}
				NodeList phones=person.getElementsByTagName("phone");
				if(phones.getLength()==1){
					Element e=(Element)ages.item(0);
					Text t=(Text)e.getFirstChild();
					personBean.setPhone(t.getNodeValue());
				} 
				person_vector.add(personBean);
				
				
				}
				return person_vector;
		 }
		
		public void createElement(String elementname,Document doc,Element person,PersonBean personBean){
			Element ele=doc.createElement(elementname);
			person.appendChild(ele);
			Text eletext=doc.createTextNode(String.valueOf(personBean.getAge()));
			ele.appendChild(eletext);
		}
		
		
		
	}


