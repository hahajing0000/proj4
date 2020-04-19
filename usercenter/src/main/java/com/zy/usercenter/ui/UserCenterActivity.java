package com.zy.usercenter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.zy.commonlib.log.ZLog;
import com.zy.core.mvp.ui.BaseActivity;
import com.zy.imageloader.ImageLoader;
import com.zy.imageloader.impl.GlideStrategy;
import com.zy.imageloader.setting.NormalImageSetting;
import com.zy.storage.ResultCallback;
import com.zy.storage.chain.StorageChainManager;
import com.zy.usercenter.R;
import com.zy.usercenter.contract.UserCenterContract;
import com.zy.usercenter.model.protocol.resp.UserEntity;
import com.zy.usercenter.model.storage.Test1StorageChain;
import com.zy.usercenter.model.storage.TestStorageChain;
import com.zy.usercenter.presenter.UserCenterPresenter;

public class UserCenterActivity extends BaseActivity<UserCenterPresenter> implements UserCenterContract.UserCenterView {

    private EditText etUserPhone;
    private EditText etUserPwd;
    private EditText etUserPwd2;
    private Button btnUserRegister;
    private ImageView ivTest;

    @Override
    protected void createProsenter() {
        mPresenter=new UserCenterPresenter(this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_user_center;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        etUserPhone = (EditText) findViewById(R.id.et_user_phone);
        etUserPwd = (EditText) findViewById(R.id.et_user_pwd);
        etUserPwd2 = (EditText) findViewById(R.id.et_user_pwd2);
        btnUserRegister = (Button) findViewById(R.id.btn_user_register);
        ivTest = (ImageView) findViewById(R.id.iv_test);
    }

    @Override
    protected void initData() {

        String key="111";
        StorageChainManager.getInstance().addChain(key,new TestStorageChain());

        UserEntity userEntity=new UserEntity();
        userEntity.setUserPassWord("123");
        userEntity.setPhoneNum(100);
        StorageChainManager.getInstance().saveData(key,userEntity);



        StorageChainManager.getInstance().getData(key, new ResultCallback<UserEntity>() {

            @Override
            public void getData(UserEntity result) {
                if (null!=result){
                    ZLog.d(result.toString());
                }
            }
        });


        String key2="222";
        StorageChainManager.getInstance().addChain(key2,new Test1StorageChain());

        UserEntity userEntity2=new UserEntity();
        userEntity2.setUserPassWord("234");
        userEntity2.setPhoneNum(400);
        StorageChainManager.getInstance().saveData(key2,userEntity2);



        StorageChainManager.getInstance().getData(key2, new ResultCallback<UserEntity>() {

            @Override
            public void getData(UserEntity result) {
                if (null!=result){
                    ZLog.d(result.toString());
                }
            }
        });
        ImageLoader.getInstance().loadImage(this,NormalImageSetting.builder().url("http://imgsa.baidu.com/exp/w=500/sign=9de34c5481b1cb133e693c13ed5556da/bba1cd11728b47101059da77cfcec3fdfc032312.jpg").imageRadius(150).imageView(ivTest).build());
    }

    @Override
    protected void initEvent() {
        btnUserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone=etUserPhone.getText().toString();
                String pwd=etUserPwd.getText().toString();
                String pwd2=etUserPwd2.getText().toString();
                if (TextUtils.isEmpty(phone)){
                    showMsg("请输入电话号码");
                    return;
                }
                if (TextUtils.isEmpty(pwd)){
                    showMsg("请输入密码");
                    return;
                }
                if (TextUtils.isEmpty(pwd2)){
                    showMsg("请再次输入密码");
                    return;
                }
                if (!pwd.equals(pwd2)){
                    showMsg("两次密码输入不一致");
                    return;
                }
                UserEntity userEntity=new UserEntity();
                userEntity.setPhoneNum(Integer.parseInt(phone));
                userEntity.setUserPassWord(pwd);
                mPresenter.register(userEntity);

            }
        });
    }

    @Override
    public void registerSuccess() {
        showMsg("注册成功");
    }

    @Override
    public void registerFailed() {
        showMsg("注册失败");
    }

    @Override
    public LifecycleOwner getOwner() {
        return this;
    }
}
