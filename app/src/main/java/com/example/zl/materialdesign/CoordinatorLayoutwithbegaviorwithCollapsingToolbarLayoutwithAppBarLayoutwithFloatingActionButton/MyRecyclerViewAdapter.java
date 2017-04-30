package com.example.zl.materialdesign.CoordinatorLayoutwithbegaviorwithCollapsingToolbarLayoutwithAppBarLayoutwithFloatingActionButton;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zl on 2017/4/30.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyMyRecyclerViewHolder> {
    private Context context;
    private List<String> list;

    public MyRecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyMyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = new TextView(context);
        return new MyMyRecyclerViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(MyMyRecyclerViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

 class MyMyRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public MyMyRecyclerViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView;
    }
}
