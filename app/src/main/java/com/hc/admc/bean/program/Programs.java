package com.hc.admc.bean.program;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * Created by alex on 2017/8/9.
 */
@Root(name = "programs", strict = false)
public class Programs {
    @ElementList(required=true, inline=true, entry="programItemBean")
    public ProgramItemBean programItemBean;

    public ProgramItemBean getProgramItemBean() {
        return programItemBean;
    }

    public void setProgramItemBean(ProgramItemBean programItemBean) {
        programItemBean = programItemBean;
    }
}
