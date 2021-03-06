package com.safefire.acsiserver.webapp.vo;

/**
 * Created by Leo on 2017/5/16.
 */
public class QuestionsAnswer {

    private Integer id;
    private String q;
    private String v;

    public QuestionsAnswer() {
    }

    public QuestionsAnswer(Integer id, String q, String v) {
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

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }
}
