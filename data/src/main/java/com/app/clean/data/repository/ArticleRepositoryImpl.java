package com.app.clean.data.repository;

import com.app.clean.data.JDHttp;
import com.app.clean.data.JDTransformer;
import com.app.clean.data.api.ArticleApi;
import com.app.clean.domain.bean.ArticleBean;
import com.app.clean.domain.bean.BaseResponse;
import com.app.clean.domain.repository.ArticleRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class ArticleRepositoryImpl implements ArticleRepository {

    private ArticleApi mApi;

    public ArticleRepositoryImpl() {
        mApi = JDHttp.createApi(ArticleApi.class);
    }

    @Override
    public Observable<List<ArticleBean>> getArticleList(String param) {
        return mApi.getArticleList(param).compose(JDTransformer.<BaseResponse>switchSchedulers())
                .map(new Function<BaseResponse, List<ArticleBean>>() {
                    @Override
                    public List<ArticleBean> apply(BaseResponse baseResponse) throws Exception {
                        return baseResponse.getResult().getList();
                    }
                });
    }
}
