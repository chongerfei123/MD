package com.example.zl.materialdesign.CoordinatorLayoutwithbegaviorwithCollapsingToolbarLayoutwithAppBarLayoutwithFloatingActionButton;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.zl.materialdesign.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main3Activity extends AppCompatActivity {

    private TextView main3_text;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        main3_text = (TextView) findViewById(R.id.main3_text);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Toolbar toolbarInAppBarLayout = (Toolbar) findViewById(R.id.toolbarInAppBarLayout);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);

        /**
         * CoordinatorLayout AND Behavior
         */
 /*       CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) main3_text.getLayoutParams();
        SwipeDismissBehavior<TextView> behavior = new SwipeDismissBehavior<>();
        behavior.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
                view.setVisibility(View.GONE);
                Snackbar.make(view,"刪除了一個控件",Snackbar.LENGTH_LONG).setAction("撤銷", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        main3_text.setVisibility(View.VISIBLE);
                        ViewCompat.animate(main3_text).alpha(1).start();
                    }
                }).show();
            }

            @Override
            public void onDragStateChanged(int state) {

            }
        });
        params.setBehavior(behavior);*/

        /**
         * 自定义Behavior，实现recyclerView上下滑动是Textview控件消失和显示
         */
        list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            String format = String.format(Locale.CHINA, "第%02d個",i);
            list.add(format);
        }
        recyclerView.setAdapter(new MyRecyclerViewAdapter(Main3Activity.this,list));
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) main3_text.getLayoutParams();
        Mybehavior mybehavior = new Mybehavior();
        params.setBehavior(mybehavior);


        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

