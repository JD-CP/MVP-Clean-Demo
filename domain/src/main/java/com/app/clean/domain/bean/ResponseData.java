package com.app.clean.domain.bean;

import java.util.ArrayList;
import java.util.List;

public class ResponseData {

    private List<ArticleBean> list;

    public List<ArticleBean> getList() {
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    public void setList(List<ArticleBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "list=" + list +
                '}';
    }
}
