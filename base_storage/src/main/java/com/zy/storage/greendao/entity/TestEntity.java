package com.zy.storage.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author:zhangyue
 * @date:2020/4/20
 */
@Entity
public class TestEntity {
    @Id(autoincrement = true)
    private long id;

    private String name;

    @Generated(hash = 1408321195)
    public TestEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1020448049)
    public TestEntity() {
    }
    
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
