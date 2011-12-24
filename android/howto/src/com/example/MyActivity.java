package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Date;

public class MyActivity extends Activity implements RadioGroup.OnCheckedChangeListener {
    TextView m_label;
    Button m_button;
    ImageView m_iv;
    EditText m_et;
    RadioGroup m_rg;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        m_label = (TextView) findViewById(R.id.label);
//        m_button = (Button) findViewById(R.id.button);
//        m_iv = (ImageView) findViewById(R.id.iv);
//        m_et = (EditText) findViewById(R.id.et);
//        m_rg = (RadioGroup) findViewById(R.id.rg);
//        m_rg.setOnCheckedChangeListener(this);
    }

    public void onClickHandler(View view) {
        updateTime();
    }

    private void updateTime() {
        m_button.setText(new Date().toString());
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int checkedButton = radioGroup.getCheckedRadioButtonId();
        System.out.println("CheckedButton: :" + checkedButton);
        System.out.println("i: :" + i);
        RadioButton button = (RadioButton) findViewById(checkedButton);
        if (button != null) {
            m_label.setText(button.getText());
        }
    }
}
