package com.safefire.acsiserver.webapp.vo;

import java.util.List;

/**
 * Created by Leo on 2017/5/22.
 */
public class QuestionsCategory {

    private Integer id;

    private String desc;

    private List<QuestionsChoice> qs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<QuestionsChoice> getQs() {
        return qs;
    }

    public void setQs(List<QuestionsChoice> qs) {
        this.qs = qs;
    }
}
