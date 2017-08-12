package com.hc.admc.bean.program;

/**
 * Created by alex on 2017/8/9.
 */
public class MatItemBean {
    public String itemId;
    public String sortNum;
    public MaterialBean material;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getSortNum() {
        return sortNum;
    }

    public void setSortNum(String sortNum) {
        this.sortNum = sortNum;
    }

    public MaterialBean getBean() {
        return material;
    }

    public void setBean(MaterialBean bean) {
        material = bean;
    }
}
