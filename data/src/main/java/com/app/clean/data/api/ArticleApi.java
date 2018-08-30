package com.app.clean.data.api;

import com.app.clean.domain.bean.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticleApi {

    @GET("/weixin/query")
    Observable<BaseResponse> getArticleList(@Query("key") String appKey);

}
