package com.sohu.suc.XML;

import java.util.Vector;

import com.sohu.suc.person.PersonBean;

public interface DealXML {
	
	
Vector<PersonBean> readXMLFile(String inFile) throws Exception;
void writeXMLFile(String outFile,Vector<PersonBean> person_vector)throws Exception;


}
