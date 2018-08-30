package com.app.clean.domain.interactor;

import com.app.clean.domain.bean.ArticleBean;
import com.app.clean.domain.repository.ArticleRepository;

import java.util.List;

import io.reactivex.Observable;

public class ArticleCase extends UseCase<List<ArticleBean>, String> {

    private ArticleRepository articleRepository;

    public ArticleCase(ArticleRepository repository) {
        this.articleRepository = repository;
    }

    @Override
    protected Observable<List<ArticleBean>> buildObservable(String s) {
        return articleRepository.getArticleList(s);
    }

}
