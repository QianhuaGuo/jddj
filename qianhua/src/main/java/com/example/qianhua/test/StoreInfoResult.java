package com.example.qianhua.test;

import lombok.Data;

@Data
public class StoreInfoResult {

//    @XmlElement(required = true)
//    @ApiModelProperty(value = "数据接收状态，0失败，1成功 Data receiving status, 0=failed, 1=succeed", dataType = "Integer", readOnly = true)
    protected Integer status;
//    @XmlElement(required = true)
//    @ApiModelProperty(value = "错误编码 Error code", dataType = "String", readOnly = false)
    protected String errorCode;
//    @XmlElement(required = true)
//    @ApiModelProperty(value = "错误编码 Error code", dataType = "String", readOnly = false)
    protected String errorMsg;
//    @XmlElement(required = true)
//    @ApiModelProperty(value = "错误编码 Error code", dataType = "String", readOnly = false)
    protected StoreInfoResult.StoreInfo storeInfo;
    /**
     * 获取status属性的值。
     *
     * @return possible object is
     * {@link String }
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * 设置status属性的值。
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStatus(Integer value) {
        this.status = value;
    }
    /**
     * 获取errorCode属性的值。
     *
     * @return possible object is
     * {@link String }
     */
    public String getErrorCode() {
        return errorCode;
    }
    /**
     * 设置errorCode属性的值。
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }
    /**
     * 获取message属性的值。
     *
     * @return possible object is
     * {@link String }
     */
    public String getMessage() {
        return errorMsg;
    }
    /**
     * 设置message属性的值。
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMessage(String value) {
        this.errorMsg = value;
    }
    /**
     * 获取storeInfo属性的值。
     *
     * @return possible object is
     * {@link StoreInfoResult.StoreInfo }
     */
    public StoreInfoResult.StoreInfo getStoreInfo() {
        return storeInfo;
    }
    /**
     * 设置storeInfo属性的值。
     *
     * @param value allowed object is
     *              {@link StoreInfoResult.StoreInfo }
     */
    public void setStoreInfo(StoreInfoResult.StoreInfo value) {
        this.storeInfo = value;
    }

    @Data
    public static class StoreInfo extends StoreInfoBase {
//        @XmlElement(required = true)
//        @ApiModelProperty(value = "平台店铺id", dataType = "String", readOnly = false)
        protected String platformShopId;
//        @XmlElement(required = true)
//        @ApiModelProperty(value = "平台应用唯一值", dataType = "String", readOnly = false)
        protected String appKey;
//        @XmlElement(required = true)
//        @ApiModelProperty(value = "平台应用秘钥", dataType = "String", readOnly = true)
        protected String appSecret;
//        @XmlElement(required = true)
//        @ApiModelProperty(value = "授权码", dataType = "String", readOnly = true)
        protected String accessToken;

    }
}
