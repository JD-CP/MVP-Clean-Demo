package com.app.clean.view;

import com.app.clean.base.IView;
import com.app.clean.domain.bean.ArticleBean;

import java.util.List;

public interface ArticleView extends IView {

    void getArticleSuccess(List<ArticleBean> articleBeanList);

    void getArticleFail(String failMsg);

}
