package com.app.clean.domain.consumer;

import com.app.clean.domain.bean.BaseResponse;

import io.reactivex.functions.Consumer;

/**
 * Created by liujindong on 2018/7/14.
 */

public abstract class NextConsumer implements Consumer<BaseResponse>, ISubNextConsumer {

    @Override
    public void accept(BaseResponse tBaseResponse) throws Exception {

    }

}
