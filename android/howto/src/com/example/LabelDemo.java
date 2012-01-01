package com.example;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Demo for TextView and EditText
 *
 * @author http://kannanchandrasekaran.com
 */
public class LabelDemo extends BaseDemoActivity {
    TextView m_tv;
    EditText m_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.labeldemo);
        // Get the item references by ID
        m_tv = (TextView) findViewById(R.id.textview);
        m_tv.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
        m_home = (Button) findViewById(R.id.home);
        m_et = (EditText) findViewById(R.id.editText);
        //Add a Listener to update the textview text with the user entered input
        m_et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    boolean keyResult = v.onKeyDown(keyCode, event);
                    m_tv.setAllCaps(true);
                    m_tv.setText(m_et.getText());
                    return keyResult;
                }
                return false;
            }
        });
    }
}
