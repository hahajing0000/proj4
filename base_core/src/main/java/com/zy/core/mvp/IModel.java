package com.zy.core.mvp;

/**
 * @author:zhangyue
 * @date:2020/4/16
 * 业务层 提供数据业务处理 如：从网络 SP  Sqlite中存入/提取数据等
 */
public interface IModel {

    /**
     * 销毁不用的资源 避免内存泄漏
     */
    void destory();
}
