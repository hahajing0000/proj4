package com.zy.home.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zy.commonlib.arouter.RouterPath;
import com.zy.core.mvp.ui.BaseActivity;
import com.zy.home.R;
import com.zy.home.contract.HomeContract;
import com.zy.home.presenter.HomePresenter;

@Route(path = RouterPath.HOME_ACTIVITY)
public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {
    private Button btnTestMvp;
    private TextView tvContent;

    @Override
    protected void createProsenter() {
        mPresenter= new HomePresenter(this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        btnTestMvp = (Button) findViewById(R.id.btn_test_mvp);
        tvContent = (TextView) findViewById(R.id.tv_content);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        btnTestMvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getValue();
            }
        });
    }

    @Override
    public void setValue(String requestResult) {
        tvContent.setText(requestResult);
    }

    @Override
    public LifecycleOwner getOwner() {
        return this;
    }
}
