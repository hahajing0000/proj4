package com.zy.home.presenter;

import com.zy.home.callback.IResultCallback;
import com.zy.home.contract.HomeContract;
import com.zy.home.net.repository.HomeRepository;

/**
 * @author:zhangyue
 * @date:2020/4/16
 */
public class HomePresenter extends HomeContract.HomePresenter {
    public HomePresenter(HomeContract.HomeView homeView){
        super(homeView);
    }

    @Override
    public void getValue() {
        mRepository.getValue(new IResultCallback<String>() {
            @Override
            public void getValue(String value) {
                if (mView!=null&&mView.get()!=null){
                    mView.get().setValue(value);
                }

            }
        });
    }

    @Override
    protected void createRepository() {
        mRepository=new HomeRepository();
    }

}
