package com.sohu.suc.XML;

public class DefaultDealXMLFactory {

		
		/**
		 * ˽�й�����
		 */
		private DefaultDealXMLFactory() {}
		
		/**
		 * ��ȡ����XML��
		 * @return ����XML��
		 */
		
		public static DefaultDealXML getDefaultDealXML() {
			return DefaultDealXML.INSTANCE;
		}

	

}
