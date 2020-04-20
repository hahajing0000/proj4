package com.zy.storage.greendao.manager;

import com.zy.storage.greendao.BaseBeanManager;
import com.zy.storage.greendao.entity.TestEntity;

import org.greenrobot.greendao.AbstractDao;

/**
 * @author:zhangyue
 * @date:2020/4/20
 */
public class TestManager extends BaseBeanManager<TestEntity,Long> {
    public TestManager(AbstractDao dao) {
        super(dao);
    }
}
