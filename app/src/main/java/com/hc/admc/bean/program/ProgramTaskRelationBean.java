package com.hc.admc.bean.program;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by alex on 2017/8/9.
 */
@Root(name = "programTaskRelation", strict = false)
public class ProgramTaskRelationBean {
    @Attribute(name="beginDate")
    public String beginDate;
    @Attribute(name="beginTime")
    public String beginTime;
    @Attribute(name="endDate")
    public String endDate;
    @Attribute(name="endTime")
    public String endTime;
    @Attribute(name="playNum")
    public String playNum;
    @Attribute(name="week")
    public String week;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPlayNum() {
        return playNum;
    }

    public void setPlayNum(String playNum) {
        this.playNum = playNum;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
