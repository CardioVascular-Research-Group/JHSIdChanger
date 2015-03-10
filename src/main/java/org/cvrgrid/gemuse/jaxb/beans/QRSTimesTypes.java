//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.09 at 11:46:28 AM EDT 
//


package org.cvrgrid.gemuse.jaxb.beans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}QRS" maxOccurs="unbounded"/>
 *         &lt;element ref="{}GlobalRR"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "qrs",
    "globalRR"
})
@XmlRootElement(name = "QRSTimesTypes")
public class QRSTimesTypes {

    @XmlElement(name = "QRS", required = true)
    protected List<QRS> qrs;
    @XmlElement(name = "GlobalRR", required = true)
    protected String globalRR;

    /**
     * Gets the value of the qrs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the qrs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQRS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QRS }
     * 
     * 
     */
    public List<QRS> getQRS() {
        if (qrs == null) {
            qrs = new ArrayList<QRS>();
        }
        return this.qrs;
    }

    /**
     * Gets the value of the globalRR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlobalRR() {
        return globalRR;
    }

    /**
     * Sets the value of the globalRR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlobalRR(String value) {
        this.globalRR = value;
    }

}