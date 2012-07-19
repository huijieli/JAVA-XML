package com.sohu.suc.XML;

import java.util.Vector;

import com.sohu.suc.person.PersonBean;

import junit.framework.TestCase;

public class DefaultDealXMLTest extends TestCase {

	public static void main(String[] args) throws Exception {
		PersonBean person=new PersonBean();
		person.setAge(100);
		person.setName("2»õ");
		person.setPhone("15109265656");
		person.setSex(" ÄÐ");
		
		Vector<PersonBean> person_vector=new Vector<PersonBean>();
		DefaultDealXML xmltest=DefaultDealXMLFactory.getDefaultDealXML();
		try {
			person_vector=xmltest.readXMLFile("Input.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			xmltest.writeXMLFile("Output1.xml",xmltest.readXMLFile("Input.xml"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			person_vector.add(person);
			xmltest.writeXMLFile("Output.xml", person_vector);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
}
}
