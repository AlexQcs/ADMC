package com.hc.admc.bean.program;

import java.util.List;

/**
 * Created by alex on 2017/8/9.
 */
public class ProgramItemBean {
    public List<MatItemBean> matItems;
    public ProgramBean program;
    public ProgramTaskRelationBean programTaskRelation;

    public List<MatItemBean> getMatItems() {
        return matItems;
    }

    public void setMatItems(List<MatItemBean> matItems) {
        this.matItems = matItems;
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
        this.programTaskRelation = programTaskRelationBean;
    }

    @Override

    public String toString() {
        return "ProgramItemBean{" +
                "matItems=" + matItems +
                ", program=" + program +
                ", programTaskRelation=" + programTaskRelation +
                '}';
    }
}
