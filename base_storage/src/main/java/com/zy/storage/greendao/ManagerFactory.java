package com.zy.storage.greendao;

import com.zy.commonlib.app.AppUtils;
import com.zy.storage.greendao.manager.TestManager;

/**
 * @author:zhangyue
 * @date:2020/4/20
 */
public class ManagerFactory {
    private static ManagerFactory instance=new ManagerFactory();
    private ManagerFactory(){}
    public static ManagerFactory getInstance(){
        return instance;

    }


    TestManager testManager;

    public synchronized TestManager getTestManager(){
        if (null==testManager){
            testManager=new TestManager(DaoManager.getInstance(AppUtils.getAppContext()).getDaoSession().getTestEntityDao());

        }
        return testManager;
    }
}
