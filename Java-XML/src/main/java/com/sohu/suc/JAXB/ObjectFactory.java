//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.20 at 05:28:26 ���� CST 
//


package com.sohu.suc.JAXB;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hello package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Pattern_QNAME = new QName("http://i.sohu.com/message/message_template_info", "pattern");
    private final static QName _MessageTemplateInfo_QNAME = new QName("http://i.sohu.com/message/message_template_info", "message_template_info");
    private final static QName _MessageTemplate_QNAME = new QName("http://i.sohu.com/message/message_template_info", "message_template");
    private final static QName _Patterns_QNAME = new QName("http://i.sohu.com/message/message_template_info", "patterns");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hello
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MessageTemplateInfo }
     * 
     */
    public MessageTemplateInfo createMessageTemplateInfo() {
        return new MessageTemplateInfo();
    }

    /**
     * Create an instance of {@link Pattern }
     * 
     */
    public Pattern createPattern() {
        return new Pattern();
    }

    /**
     * Create an instance of {@link MessageTemplate }
     * 
     */
    public MessageTemplate createMessageTemplate() {
        return new MessageTemplate();
    }

    /**
     * Create an instance of {@link Patterns }
     * 
     */
    public Patterns createPatterns() {
        return new Patterns();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pattern }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://i.sohu.com/message/message_template_info", name = "pattern")
    public JAXBElement<Pattern> createPattern(Pattern value) {
        return new JAXBElement<Pattern>(_Pattern_QNAME, Pattern.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageTemplateInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://i.sohu.com/message/message_template_info", name = "message_template_info")
    public JAXBElement<MessageTemplateInfo> createMessageTemplateInfo(MessageTemplateInfo value) {
        return new JAXBElement<MessageTemplateInfo>(_MessageTemplateInfo_QNAME, MessageTemplateInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageTemplate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://i.sohu.com/message/message_template_info", name = "message_template")
    public JAXBElement<MessageTemplate> createMessageTemplate(MessageTemplate value) {
        return new JAXBElement<MessageTemplate>(_MessageTemplate_QNAME, MessageTemplate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Patterns }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://i.sohu.com/message/message_template_info", name = "patterns")
    public JAXBElement<Patterns> createPatterns(Patterns value) {
        return new JAXBElement<Patterns>(_Patterns_QNAME, Patterns.class, null, value);
    }

}
