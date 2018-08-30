package com.app.clean.base;

public interface IPresenter<V extends IView> {

    void attach(V view);

    void detach();

}
