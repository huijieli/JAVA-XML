package com.sohu.suc.XML;

public class DefaultDealXMLFactory {

		
		/**
		 * 私有构造器
		 */
		private DefaultDealXMLFactory() {}
		
		/**
		 * 获取处理XML类
		 * @return 处理XML类
		 */
		
		public static DefaultDealXML getDefaultDealXML() {
			return DefaultDealXML.INSTANCE;
		}

	

}
