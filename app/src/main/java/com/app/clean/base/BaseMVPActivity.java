package com.app.clean.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseMVPActivity<T extends IPresenter> extends AppCompatActivity implements IView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createView());

        mPresenter = createPresenter();
        if (null == mPresenter) {
            throw new IllegalStateException("Please call mPresenter in BaseMVPActivity(createPresenter) to create!");
        } else {
            mPresenter.attach(this);
        }

        viewCreated();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.detach();
        }
    }

    protected abstract int createView();

    protected abstract T createPresenter();

    protected abstract void viewCreated();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}
