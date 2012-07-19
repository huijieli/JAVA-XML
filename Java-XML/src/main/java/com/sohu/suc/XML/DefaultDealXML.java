package com.sohu.suc.XML;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Vector;

import javax.xml.parsers.*;

import org.apache.crimson.tree.XmlDocument;
import org.w3c.dom.*;

import com.sohu.suc.person.PersonBean;


/**
 * @author Bob
 * XML¥¶¿Ì¿‡
 */

public enum DefaultDealXML implements DealXML {
	INSTANCE;
	
	
	public Vector<PersonBean> readXMLFile(String inFile) throws Exception {
	    Vector<PersonBean> person_vector=new Vector<PersonBean>();
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
			doc=db.parse(inFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root=doc.getDocumentElement();
		
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

	/* (non-Javadoc)
	 * @see com.sohu.suc.XML.DealXML#writeXMLFile(java.lang.String, java.util.Vector)
	 */
	public void writeXMLFile(String outFile,Vector<PersonBean> person_vector)throws Exception {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=null;
		try {
			db=dbf.newDocumentBuilder();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Document doc=null;
		
	
			doc=db.newDocument();
		
		Element root=doc.createElement("personinformation");
		doc.appendChild(root);
		for(int i=0;i<person_vector.size();i++){
			PersonBean personBean=(PersonBean)person_vector.get(i);
			
			Element person=doc.createElement("person");
			person.setAttribute("sex", personBean.getSex());
			root.appendChild(person);
			
			Element name=doc.createElement("name");
			person.appendChild(name);
			
			Text tName=doc.createTextNode(personBean.getName());
			name.appendChild(tName);
			
			Element age=doc.createElement("age");
			person.appendChild(age);
			Text tAge=doc.createTextNode(String.valueOf(personBean.getAge()));
			age.appendChild(tAge);
			
			Element phone=doc.createElement("phone");
			person.appendChild(phone);
			Text tPhone=doc.createTextNode(personBean.getPhone());
			phone.appendChild(tPhone);
				
		}
		
		FileOutputStream outStream=new FileOutputStream(outFile);
		OutputStreamWriter outWriter =new OutputStreamWriter(outStream);
	
		((XmlDocument)doc).write(outWriter,"GB2312");
		outWriter.close();
		outStream.close();
		

	}

		
	}
	


