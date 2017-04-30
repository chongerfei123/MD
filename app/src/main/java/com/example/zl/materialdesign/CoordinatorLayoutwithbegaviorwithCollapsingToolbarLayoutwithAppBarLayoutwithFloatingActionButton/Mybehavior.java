package com.example.zl.materialdesign.CoordinatorLayoutwithbegaviorwithCollapsingToolbarLayoutwithAppBarLayoutwithFloatingActionButton;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * Created by zl on 2017/4/30.
 */

public class Mybehavior extends CoordinatorLayout.Behavior {

    //返回值：是否關心滾動事件
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy < 0){
            ViewCompat.animate(child).scaleX(1).scaleX(1).start();
        }else {
            ViewCompat.animate(child).scaleX(0).scaleX(0).start();
        }
    }
}
