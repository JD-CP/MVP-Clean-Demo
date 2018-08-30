package com.app.clean.base;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.app.clean.domain.interactor.UseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class BasePresenter<V extends IView> implements IPresenter<V> {

    private V mView;

    private CPBridge mBridge = new CPBridge();

    protected List<UseCase> mCaseList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void attach(V view) {
        this.mView = view;
        createCases();
        mCaseList.forEach(new Consumer<UseCase>() {
            @Override
            public void accept(UseCase useCase) {
                mBridge.addCase(useCase);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void detach() {
        this.mView = null;
        mBridge.removeCase();
    }

    protected abstract List<UseCase> createCases();

    public V getView() {
        if (isViewAttached()) {
            return mView;
        } else {
            throw new IllegalStateException("Please call IPresenter.attach(IView view) before requesting data");
        }
    }

    private boolean isViewAttached() {
        return null != mView;
    }

}
