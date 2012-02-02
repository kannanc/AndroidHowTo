package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Provides a demo for the spinner class
 *
 * @author http://kannanchandrasekaran.com
 */
public class SpinnerDemo extends Activity {
    private TextView m_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinnerdemo);
        m_tv = (TextView) findViewById(R.id.spin_tv1);
        Spinner spinner = (Spinner) findViewById(R.id.spin1);
        String[] platforms = getResources().getStringArray(R.array.dev_platforms);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, platforms);
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                m_tv.setText(tv.getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                m_tv.setText("");
            }
        });
    }
}
