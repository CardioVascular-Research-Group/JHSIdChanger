//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.09 at 11:46:28 AM EDT 
//


package org.cvrgrid.gemuse.jaxb.beans;

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
 *         &lt;element ref="{}LeadByteCountTotal"/>
 *         &lt;element ref="{}LeadTimeOffset"/>
 *         &lt;element ref="{}LeadSampleCountTotal"/>
 *         &lt;element ref="{}LeadAmplitudeUnitsPerBit"/>
 *         &lt;element ref="{}LeadAmplitudeUnits"/>
 *         &lt;element ref="{}LeadHighLimit"/>
 *         &lt;element ref="{}LeadLowLimit"/>
 *         &lt;element ref="{}LeadID"/>
 *         &lt;element ref="{}LeadOffsetFirstSample"/>
 *         &lt;element ref="{}FirstSampleBaseline"/>
 *         &lt;element ref="{}LeadSampleSize"/>
 *         &lt;element ref="{}LeadOff"/>
 *         &lt;element ref="{}BaselineSway"/>
 *         &lt;element ref="{}LeadDataCRC32"/>
 *         &lt;element ref="{}WaveFormData"/>
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
    "leadByteCountTotal",
    "leadTimeOffset",
    "leadSampleCountTotal",
    "leadAmplitudeUnitsPerBit",
    "leadAmplitudeUnits",
    "leadHighLimit",
    "leadLowLimit",
    "leadID",
    "leadOffsetFirstSample",
    "firstSampleBaseline",
    "leadSampleSize",
    "leadOff",
    "baselineSway",
    "leadDataCRC32",
    "waveFormData"
})
@XmlRootElement(name = "LeadData")
public class LeadData {

    @XmlElement(name = "LeadByteCountTotal", required = true)
    protected String leadByteCountTotal;
    @XmlElement(name = "LeadTimeOffset", required = true)
    protected String leadTimeOffset;
    @XmlElement(name = "LeadSampleCountTotal", required = true)
    protected String leadSampleCountTotal;
    @XmlElement(name = "LeadAmplitudeUnitsPerBit", required = true)
    protected String leadAmplitudeUnitsPerBit;
    @XmlElement(name = "LeadAmplitudeUnits", required = true)
    protected String leadAmplitudeUnits;
    @XmlElement(name = "LeadHighLimit", required = true)
    protected String leadHighLimit;
    @XmlElement(name = "LeadLowLimit", required = true)
    protected String leadLowLimit;
    @XmlElement(name = "LeadID", required = true)
    protected String leadID;
    @XmlElement(name = "LeadOffsetFirstSample", required = true)
    protected String leadOffsetFirstSample;
    @XmlElement(name = "FirstSampleBaseline", required = true)
    protected String firstSampleBaseline;
    @XmlElement(name = "LeadSampleSize", required = true)
    protected String leadSampleSize;
    @XmlElement(name = "LeadOff", required = true)
    protected String leadOff;
    @XmlElement(name = "BaselineSway", required = true)
    protected String baselineSway;
    @XmlElement(name = "LeadDataCRC32", required = true)
    protected String leadDataCRC32;
    @XmlElement(name = "WaveFormData", required = true)
    protected String waveFormData;

    /**
     * Gets the value of the leadByteCountTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadByteCountTotal() {
        return leadByteCountTotal;
    }

    /**
     * Sets the value of the leadByteCountTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadByteCountTotal(String value) {
        this.leadByteCountTotal = value;
    }

    /**
     * Gets the value of the leadTimeOffset property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadTimeOffset() {
        return leadTimeOffset;
    }

    /**
     * Sets the value of the leadTimeOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadTimeOffset(String value) {
        this.leadTimeOffset = value;
    }

    /**
     * Gets the value of the leadSampleCountTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadSampleCountTotal() {
        return leadSampleCountTotal;
    }

    /**
     * Sets the value of the leadSampleCountTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadSampleCountTotal(String value) {
        this.leadSampleCountTotal = value;
    }

    /**
     * Gets the value of the leadAmplitudeUnitsPerBit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadAmplitudeUnitsPerBit() {
        return leadAmplitudeUnitsPerBit;
    }

    /**
     * Sets the value of the leadAmplitudeUnitsPerBit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadAmplitudeUnitsPerBit(String value) {
        this.leadAmplitudeUnitsPerBit = value;
    }

    /**
     * Gets the value of the leadAmplitudeUnits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadAmplitudeUnits() {
        return leadAmplitudeUnits;
    }

    /**
     * Sets the value of the leadAmplitudeUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadAmplitudeUnits(String value) {
        this.leadAmplitudeUnits = value;
    }

    /**
     * Gets the value of the leadHighLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadHighLimit() {
        return leadHighLimit;
    }

    /**
     * Sets the value of the leadHighLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadHighLimit(String value) {
        this.leadHighLimit = value;
    }

    /**
     * Gets the value of the leadLowLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadLowLimit() {
        return leadLowLimit;
    }

    /**
     * Sets the value of the leadLowLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadLowLimit(String value) {
        this.leadLowLimit = value;
    }

    /**
     * Gets the value of the leadID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadID() {
        return leadID;
    }

    /**
     * Sets the value of the leadID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadID(String value) {
        this.leadID = value;
    }

    /**
     * Gets the value of the leadOffsetFirstSample property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadOffsetFirstSample() {
        return leadOffsetFirstSample;
    }

    /**
     * Sets the value of the leadOffsetFirstSample property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadOffsetFirstSample(String value) {
        this.leadOffsetFirstSample = value;
    }

    /**
     * Gets the value of the firstSampleBaseline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstSampleBaseline() {
        return firstSampleBaseline;
    }

    /**
     * Sets the value of the firstSampleBaseline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstSampleBaseline(String value) {
        this.firstSampleBaseline = value;
    }

    /**
     * Gets the value of the leadSampleSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadSampleSize() {
        return leadSampleSize;
    }

    /**
     * Sets the value of the leadSampleSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadSampleSize(String value) {
        this.leadSampleSize = value;
    }

    /**
     * Gets the value of the leadOff property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadOff() {
        return leadOff;
    }

    /**
     * Sets the value of the leadOff property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadOff(String value) {
        this.leadOff = value;
    }

    /**
     * Gets the value of the baselineSway property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaselineSway() {
        return baselineSway;
    }

    /**
     * Sets the value of the baselineSway property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaselineSway(String value) {
        this.baselineSway = value;
    }

    /**
     * Gets the value of the leadDataCRC32 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadDataCRC32() {
        return leadDataCRC32;
    }

    /**
     * Sets the value of the leadDataCRC32 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadDataCRC32(String value) {
        this.leadDataCRC32 = value;
    }

    /**
     * Gets the value of the waveFormData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaveFormData() {
        return waveFormData;
    }

    /**
     * Sets the value of the waveFormData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaveFormData(String value) {
        this.waveFormData = value;
    }

}