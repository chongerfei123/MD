package com.example.zl.materialdesign.SnackBarINCoordinatorLayout;

import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zl.materialdesign.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn = (Button) findViewById(R.id.btn);

        /**
         * SnackBar在CoordinatorLayout中会有滑动消失效果
         *      PS:ActivityCompat.finishAffinity(Main2Activity.this);退出应用
         */
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"SnackBarINCoordinatorLayout",Snackbar.LENGTH_LONG).setAction("xx", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityCompat.finishAffinity(Main2Activity.this);
                    }
                }).show();
            }
        });
    }
}
