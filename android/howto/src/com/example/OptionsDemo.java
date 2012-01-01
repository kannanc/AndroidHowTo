package com.example;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * A class to demo checkbox and radio button
 *
 * @author http://kannanchandrasekaran.com
 */
public class OptionsDemo extends BaseDemoActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionsdemo);
         m_home = (Button) findViewById(R.id.home);
        final CheckBox cb = (CheckBox) findViewById(R.id.checkbox);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String val = isChecked ? "Checked" : "Not Checked";
                cb.setText("I am " + val);
            }
        });

        final RadioButton rb = (RadioButton) findViewById(R.id.rbutton);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb.setText("I cannot be cleared once I am set");
            }
        });

        final TextView tv = (TextView) findViewById(R.id.tv);
        RadioGroup rg = (RadioGroup) findViewById(R.id.rgroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedBtn = (RadioButton) findViewById(checkedId);
                tv.setText(checkedBtn.getText());
            }
        });
    }
}
