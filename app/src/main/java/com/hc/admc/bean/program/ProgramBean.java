package com.hc.admc.bean.program;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by alex on 2017/8/9.
 */
@Root(name = "program", strict = false)
public class ProgramBean {
    @Attribute(name="height")
    public String height;
    @Attribute(name="width")
    public String width;
    @Element(name = "items")
    public String items;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
