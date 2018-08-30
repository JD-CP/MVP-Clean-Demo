package com.app.clean.domain.observer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {

    private Disposable mDisposable;

    public Disposable getDisposable() {
        return mDisposable;
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.mDisposable = d;
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        onFail(e.getMessage());
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T t);
    public abstract void onFail(String failMsg);

}
