package com.app.clean.domain.bean;

public class ArticleBean {


    /**
     * firstImg :
     * id : 3091014115_2652997418_1
     * mark :
     * source : 总裁商业思维课堂
     * title : 华山栈道男子跳崖内幕？男人都是骗子！
     */

    private String firstImg;
    private String id;
    private String mark;
    private String source;
    private String title;

    public String getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ArticleBean{" +
                "firstImg='" + firstImg + '\'' +
                ", id='" + id + '\'' +
                ", mark='" + mark + '\'' +
                ", source='" + source + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
