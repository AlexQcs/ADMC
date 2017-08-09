package com.hc.admc.bean.program;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by alex on 2017/8/9.
 */
@Root(name = "programItem", strict = false)
public class ProgramItemBean {
    @ElementList(required=true, inline=true, entry="matItem")
    public List<MatItemBean> matItems;
    @Element(name = "program")
    public ProgramBean program;
    @Element(name = "programTaskRelation")
    public ProgramTaskRelationBean programTaskRelation;

    public List<MatItemBean> getMatItems() {
        return matItems;
    }

    public void setMatItems(List<MatItemBean> matItems) {
        matItems = matItems;
    }

    public ProgramBean getProgramBean() {
        return program;
    }

    public void setProgramBean(ProgramBean programBean) {
        program = programBean;
    }

    public ProgramTaskRelationBean getProgramTaskRelationBean() {
        return programTaskRelation;
    }

    public void setProgramTaskRelationBean(ProgramTaskRelationBean programTaskRelationBean) {
        programTaskRelation = programTaskRelationBean;
    }

    @Override

    public String toString() {
        return "ProgramItemBean{" +
                "matItem=" + matItems +
                ", program=" + program +
                ", programTaskRelation=" + programTaskRelation +
                '}';
    }
}
