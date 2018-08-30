package com.app.clean.domain.consumer;

import com.app.clean.domain.bean.ResponseData;

/**
 * Created by liujindong on 2018/4/24.
 */

public interface ISubNextConsumer {

    void success(ResponseData response);

    void fail(String failMsg);

}
