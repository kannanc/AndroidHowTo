package com.example;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Provides a demo for Virtual Keyboard.
 * <p/>
 * Note: This example code should only be run on a
 * AVD that has no physical keyboard.
 *
 * @author http://kannanchandrasekaran.com
 */
public class SoftKBDemo extends BaseDemoActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.R.layout.soft_keyboard_demo);
        EditText et2 = (EditText) findViewById(com.example.R.id.imf_et2);
        et2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }
        });
    }
}
