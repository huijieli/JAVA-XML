package com.sohu.suc.XML;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Vector;

import javax.xml.parsers.*;

import org.apache.crimson.tree.XmlDocument;
import org.w3c.dom.*;

import com.sohu.suc.XMlUtils.XMLUtils;
import com.sohu.suc.person.PersonBean;


/**
 * @author Bob
 * XML处理类
 */

public enum DefaultDealXML implements DealXML {
	INSTANCE;
	
	
	/**
	 * 读取XML文件，返回 Vector<PersonBean>
	 */
	public Vector<PersonBean> readXMLFile(String inFile) throws Exception {
	    Vector<PersonBean> person_vector=new Vector<PersonBean>();
	    XMLUtils xmlutils=new XMLUtils();
		Element root =xmlutils.getRoot(inFile);
		person_vector=xmlutils.getElementInfo(root);
		return person_vector;

	}

	/**
	 * 将Vector<PersonBean>对象写入XML
	 */
	public void writeXMLFile(String outFile,Vector<PersonBean> person_vector)throws Exception {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=null;
		XMLUtils xmlutils=new XMLUtils();
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
			xmlutils.createElement("name", doc, person, personBean);
			xmlutils.createElement("age", doc, person, personBean);
			xmlutils.createElement("phone", doc, person, personBean);
				
		}
		
		FileOutputStream outStream=new FileOutputStream(outFile);
		OutputStreamWriter outWriter =new OutputStreamWriter(outStream);
	
		((XmlDocument)doc).write(outWriter,"GB2312");
		outWriter.close();
		outStream.close();
		

	}

		
	}
	


