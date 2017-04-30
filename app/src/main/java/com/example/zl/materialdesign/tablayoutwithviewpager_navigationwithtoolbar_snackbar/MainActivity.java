package com.example.zl.materialdesign.tablayoutwithviewpager_navigationwithtoolbar_snackbar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.zl.materialdesign.SnackBarINCoordinatorLayout.Main2Activity;
import com.example.zl.materialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tab = (TabLayout) findViewById(R.id.tab);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        Button btn_SnackBar = (Button) findViewById(R.id.btn_SnackBar);


        /**
         * tabLayout与viewpager部分
         */
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(i+"");
        }
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));
        tab.setupWithViewPager(pager);


        /**
         * 让NavigationView与Toolbar有一个联系的动画
         * 这几句代码的顺序很重要，不然可能Toolbar上的按钮没反应
         */
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        /**
         * 侧边栏的条目点击事件
         * drawerLayout.closeDrawer(GravityCompat.START);//关闭侧边栏
         */
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId){
                    case R.id.item_4: finish();
                        break;
                }
                //drawerLayout.closeDrawer(GravityCompat.START);//关闭侧边栏
                return true;
            }
        });


        /**
         * SnackBar部分
         */
        btn_SnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//               Snackbar.make(v,"SnackBar",Snackbar.LENGTH_LONG).show();

                Snackbar.make(v,"SnackBar",Snackbar.LENGTH_LONG).setAction("去另一个activity", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, "点击了undo", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,Main2Activity.class));
                    }
                }).show();
            }
        });
    }
}
