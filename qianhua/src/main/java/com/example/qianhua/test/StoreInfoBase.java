package com.example.qianhua.test;

import lombok.Data;

@Data
public class StoreInfoBase {
//    @XmlElement(required = true)
//    @ApiModelProperty(value="平台编码(同平台多应用由后面的数字代替,如TOP-OMS,TOP2-OMS4)",dataType="String",readOnly=true)
    protected String platformCode;
//    @XmlElement(required = true)
//    @ApiModelProperty(value="宝尊系统店铺id(以baozun-pacs系统为准)，同shopCode与shopName三个参数必填其一",dataType="Long",readOnly=false)
    protected Long shopId;
//    @XmlElement(required = true)
//    @ApiModelProperty(value="店铺编码，同shopId与shopName三个参数必填其一",dataType="String",readOnly=false)
    protected String shopCode;
//    @XmlElement(required = true)
//    @ApiModelProperty(value="平台店铺名称，同shopCode与shopId三个参数必填其一",dataType="String",readOnly=false)
    protected String shopName;

    /**
     * 获取platformCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPlatformCode() {
        return platformCode;
    }
    /**
     * 设置platformCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPlatformCode(String value) {
        this.platformCode = value;
    }
    /**
     * 获取shopId属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public Long getShopId() {
        return shopId;
    }
    /**
     * 设置shopId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setShopId(Long value) {
        this.shopId = value;
    }
    /**
     * 获取shopCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getShopCode() {
        return shopCode;
    }
    /**
     * 设置shopCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setShopCode(String value) {
        this.shopCode = value;
    }
    /**
     * 获取shopName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getShopName() {
        return shopName;
    }
    /**
     * 设置shopName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setShopName(String value) {
        this.shopName = value;
    }
}
