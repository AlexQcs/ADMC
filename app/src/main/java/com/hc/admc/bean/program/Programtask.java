package com.hc.admc.bean.program;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by alex on 2017/8/9.
 */
@Root(name = "programtask", strict = false)
public class Programtask {
    @Element(name = "programs")
    public Programs programs;

    public Programs getPrograms() {
        return programs;
    }

    public void setPrograms(Programs programs) {
        programs = programs;
    }
}
