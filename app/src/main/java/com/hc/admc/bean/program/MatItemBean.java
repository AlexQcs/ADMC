package com.hc.admc.bean.program;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by alex on 2017/8/9.
 */
@Root(name = "matItem", strict = false)
public class MatItemBean {
    @Attribute(name="itemId")
    public String itemId;
    @Attribute(name="sortNum")
    public String sortNum;
    @Element(name = "material")
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
