package com.example;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Demo for TextView and EditText
 *
 * @author http://kannanchandrasekaran.com
 */
public class TextViewActivity extends BaseDemoActivity {
    Button m_home;
    TextView m_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tvactivity);

        m_tv = (TextView) findViewById(R.id.textview);
        m_tv.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
        m_home = (Button) findViewById(R.id.home);

    }
}
