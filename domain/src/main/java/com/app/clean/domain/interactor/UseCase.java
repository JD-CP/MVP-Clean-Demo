package com.app.clean.domain.interactor;

import android.annotation.SuppressLint;

import com.app.clean.domain.observer.BaseObserver;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Case 基类
 *
 * @param <T>      返回数据
 * @param <Params> 请求参数
 */
public abstract class UseCase<T, Params> {

    private final CompositeDisposable mDisposables;

    public UseCase() {
        this.mDisposables = new CompositeDisposable();
    }

    @SuppressLint("CheckResult")
    public void execute(Params params, Consumer nextConsumer, Consumer errorConsumer) {
        Observable<T> observable = this.buildObservable(params);
        addDisposable(observable.subscribe(nextConsumer, errorConsumer));
    }

    protected abstract Observable<T> buildObservable(Params params);

    private void addDisposable(Disposable disposable) {
        mDisposables.add(disposable);
    }

    @SuppressLint("CheckResult")
    public void execute(Params params, BaseObserver<T> observer) {
        Observable<T> observable = this.buildObservable(params);
        observable.subscribe(observer);
        addDisposable(observer.getDisposable());
    }

    public void dispose() {
        if (!mDisposables.isDisposed()) {
            mDisposables.dispose();
        }
    }

}
