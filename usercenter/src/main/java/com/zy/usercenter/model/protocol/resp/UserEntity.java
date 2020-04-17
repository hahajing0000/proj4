package com.zy.usercenter.model.protocol.resp;

/**
 * @author:zhangyue
 * @date:2020/4/17
 */
public class UserEntity {
    /**
     * 出生日期
     */
    private String calendar;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 介绍
     */
    private String introduction;
    /**
     * 性别
     */
    private String sex;
    /**
     * 住址
     */
    private String userAddress;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 电话号码
     */
    private int phoneNum;
    /**
     * 密码
     */
    private String userPassWord;


    @Override
    public String toString() {
        return "UserEntity{" +
                "calendar='" + calendar + '\'' +
                ", headImg='" + headImg + '\'' +
                ", introduction='" + introduction + '\'' +
                ", sex='" + sex + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userId=" + userId +
                ", phoneNum=" + phoneNum +
                ", userPassWord='" + userPassWord + '\'' +
                '}';
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }
}
