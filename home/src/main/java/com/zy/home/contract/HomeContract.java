package com.zy.home.contract;

import com.zy.core.mvp.BasePresenter;
import com.zy.core.mvp.IModel;
import com.zy.core.mvp.IView;
import com.zy.core.mvp.Repository;
import com.zy.home.callback.IResultCallback;

/**
 * @author:zhangyue
 * @date:2020/4/16
 */
public interface HomeContract {
    interface HomeView extends IView{
        void setValue(String requestResult);
    }

    interface HomeModel extends IModel{
        void getValue(IResultCallback<String> resultCallback);
    }

    abstract class HomeRepository extends Repository<HomeModel>{
        public abstract void getValue(IResultCallback<String> resultCallback);
    }

    abstract class HomePresenter extends BasePresenter<HomeRepository,HomeView>{

        public HomePresenter(HomeView homeView) {
            super(homeView);
        }

        public abstract void getValue();
    }
}
