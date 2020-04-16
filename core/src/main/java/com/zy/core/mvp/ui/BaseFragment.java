package com.zy.core.mvp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zy.core.mvp.BasePresenter;
import com.zy.core.mvp.IView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author:zhangyue
 * @date:2020/4/16
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IView {
    private P mPresenter;

    protected abstract P createPresenter();

    protected abstract int setLayout();

    protected abstract void initViews(@Nullable Bundle savedInstanceState);

    protected abstract void initData();

    protected abstract void initEvent();

    @SuppressWarnings("ConstantConditions")
    protected <T extends View> T $(@IdRes int viewId) {
        return this.getView().findViewById(viewId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), null);
        createPresenter();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews(savedInstanceState);
        initData();
        initEvent();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter=null;
    }
}
