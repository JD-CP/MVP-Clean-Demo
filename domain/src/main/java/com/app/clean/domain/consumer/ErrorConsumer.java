package com.app.clean.domain.consumer;

import io.reactivex.functions.Consumer;

/**
 * Created by liujindong on 2018/7/14.
 */

public abstract class ErrorConsumer implements Consumer<Throwable>, ISubErrorConsumer {

    @Override
    public void accept(Throwable throwable) throws Exception {
        error(throwable.getMessage());
    }

}
