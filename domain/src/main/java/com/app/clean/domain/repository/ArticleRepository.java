package com.app.clean.domain.repository;

import com.app.clean.domain.bean.ArticleBean;

import java.util.List;

import io.reactivex.Observable;

public interface ArticleRepository {

    Observable<List<ArticleBean>> getArticleList(String param);

}
