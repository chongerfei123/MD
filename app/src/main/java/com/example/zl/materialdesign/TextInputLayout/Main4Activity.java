package com.example.zl.materialdesign.TextInputLayout;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.zl.materialdesign.R;

public class Main4Activity extends AppCompatActivity {

    private TextInputLayout textInputEditLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textInputEditLayout = (TextInputLayout) findViewById(R.id.textInputEditLayout);

        EditText text = textInputEditLayout.getEditText();

        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()<6){
                    textInputEditLayout.setError("错了");
                    textInputEditLayout.setErrorEnabled(true);
                }else{
                    textInputEditLayout.setErrorEnabled(false);
                }
            }
        });
    }
}
