package com.example.qianhua.test;

import lombok.Data;

@Data
public class StoreInfoQuery extends StoreInfoBase{
//    @XmlElement(required = true)
//    @ApiModelProperty(value="标识接收方系统的唯一值(Identification of the unique value of the docking system)",example="sourceMarkCode",dataType="String",readOnly=true)
    protected String sourceMarkCode;

    /**
     * 获取sourceMarkCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSourceMarkCode() {
        return sourceMarkCode;
    }
    /**
     * 设置sourceMarkCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSourceMarkCode(String value) {
        this.sourceMarkCode = value;
    }
}
