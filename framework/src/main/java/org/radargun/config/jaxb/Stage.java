//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.10 at 06:49:47 PM EET 
//


package org.radargun.config.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}property" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
      "property"
})
@XmlRootElement(name = "stage")
public class Stage {

   protected List<Property> property;
   @XmlAttribute
   protected Boolean enabled;
   @XmlAttribute(required = true)
   @XmlJavaTypeAdapter(Adapter1.class)
   protected String name;

   /**
    * Gets the value of the property property.
    * <p/>
    * <p/>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the property property.
    * <p/>
    * <p/>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getProperty().add(newItem);
    * </pre>
    * <p/>
    * <p/>
    * <p/>
    * Objects of the following type(s) are allowed in the list {@link Property }
    */
   public List<Property> getProperty() {
      if (property == null) {
         property = new ArrayList<Property>();
      }
      return this.property;
   }

   /**
    * Gets the value of the enabled property.
    *
    * @return possible object is {@link Boolean }
    */
   public Boolean isEnabled() {
      return enabled;
   }

   /**
    * Sets the value of the enabled property.
    *
    * @param value allowed object is {@link Boolean }
    */
   public void setEnabled(Boolean value) {
      this.enabled = value;
   }

   /**
    * Gets the value of the name property.
    *
    * @return possible object is {@link String }
    */
   public String getName() {
      return name;
   }

   /**
    * Sets the value of the name property.
    *
    * @param value allowed object is {@link String }
    */
   public void setName(String value) {
      this.name = value;
   }

}
