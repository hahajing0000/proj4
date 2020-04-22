package com.zy.usercenter.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zy.widget.BesselView;
import com.zy.usercenter.R;

public class TestActivity extends AppCompatActivity {
    private BesselView bvTest;
    private Button btnTest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        bvTest = (BesselView) findViewById(R.id.bv_test);
        int[] imgs={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
        bvTest.setImgs(imgs);
//        bvTest.startAnimator();
        btnTest = (Button) findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bvTest.startAnimator();
            }
        });

    }
}
