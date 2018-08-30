package com.app.clean.presenter;

import com.app.clean.base.BasePresenter;
import com.app.clean.data.repository.ArticleRepositoryImpl;
import com.app.clean.domain.bean.ArticleBean;
import com.app.clean.domain.interactor.ArticleCase;
import com.app.clean.domain.observer.BaseObserver;
import com.app.clean.domain.interactor.UseCase;
import com.app.clean.view.ArticleView;

import java.util.List;

public class ArticlePresenter extends BasePresenter<ArticleView> {

    private ArticleCase mCase;

    public void getData(String key) {
        mCase.execute(key, new BaseObserver<List<ArticleBean>>() {
            @Override
            public void onSuccess(List<ArticleBean> articleBeanList) {
                getView().getArticleSuccess(articleBeanList);
            }

            @Override
            public void onFail(String failMsg) {
                getView().getArticleFail(failMsg);
            }
        });
    }

    @Override
    public List<UseCase> createCases() {
        mCase = new ArticleCase(new ArticleRepositoryImpl());
        mCaseList.add(mCase);
        return mCaseList;
    }
}
