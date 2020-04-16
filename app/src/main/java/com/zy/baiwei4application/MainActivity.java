package com.zy.baiwei4application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zy.commonlib.arouter.RouterPath;

public class MainActivity extends AppCompatActivity {
    private Button btnTestArouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTestArouter = (Button) findViewById(R.id.btn_test_arouter);
        btnTestArouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RouterPath.HOME_ACTIVITY).navigation();
            }
        });
    }

}
