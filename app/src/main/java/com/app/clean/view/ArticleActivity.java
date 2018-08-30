package com.app.clean.view;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.app.clean.R;
import com.app.clean.base.BaseMVPActivity;
import com.app.clean.domain.bean.ArticleBean;
import com.app.clean.presenter.ArticlePresenter;

import java.util.List;

public class ArticleActivity extends BaseMVPActivity<ArticlePresenter> implements ArticleView {

    private static final String KEY = "dbb6893ab0913b02724696504181fe39";

    private TextView textView;

    @Override
    protected int createView() {
        return R.layout.activity_article;
    }

    @Override
    protected ArticlePresenter createPresenter() {
        return new ArticlePresenter();
    }

    @Override
    protected void viewCreated() {
        textView = findViewById(R.id.textView);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        findViewById(R.id.btnGet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getData(KEY);
            }
        });
    }

    @Override
    public void getArticleSuccess(List<ArticleBean> articleBeanList) {
        textView.setText(articleBeanList.toString());
    }

    @Override
    public void getArticleFail(String failMsg) {
        Toast.makeText(this, failMsg, Toast.LENGTH_SHORT).show();
    }
}
