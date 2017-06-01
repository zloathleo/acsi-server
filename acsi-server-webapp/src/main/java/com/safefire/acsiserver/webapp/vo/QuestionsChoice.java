package com.safefire.acsiserver.webapp.vo;

/**
 * Created by Leo on 2017/5/16.
 */
public class QuestionsChoice {

    private Integer id;
    private String q;
    private Integer v;

    public QuestionsChoice() {
    }

    public QuestionsChoice(Integer id, String q, Integer v) {
        this.id = id;
        this.q = q;
        this.v = v;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
