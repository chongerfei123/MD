package com.example.zl.materialdesign.tablayoutwithviewpager_navigationwithtoolbar_snackbar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zl.materialdesign.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * 因为Fragment不能在构造方法中传递参数，所有通过fragment里面的setArguments 和getArguments方法
     * @param text
     * @return
     */
    public static BlankFragment getInstance(String text){
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text",text);
        blankFragment.setArguments(bundle);
        return blankFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView pager_text = (TextView) view.findViewById(R.id.pager_text);
        Bundle bundle = getArguments();
        String text = bundle.getString("text");
        pager_text.setText(text);
    }
}
