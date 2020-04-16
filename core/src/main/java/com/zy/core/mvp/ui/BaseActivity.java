package com.zy.core.mvp.ui;

import android.os.Bundle;

import com.zy.core.mvp.BasePresenter;
import com.zy.core.mvp.IView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author:zhangyue
 * @date:2020/4/16
 * Activity基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IView {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        createProsenter();
        initView(savedInstanceState);
        initData();
        initEvent();
    }

    /**
     * 创建P层实例
     * @return
     */
    protected abstract void createProsenter();

    /**
     * 获取布局ID
     * @return
     */
    protected abstract int getLayoutID();

    /**
     * 初始化视图
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化事件
     */
    protected abstract void initEvent();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter=null;
        }
    }
}
