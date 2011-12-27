package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Main demo activity page intended to demo the individual android components.
 *
 * @author http://kannanchandrasekaran.com
 */
public class MyActivity extends Activity {
    Button m_demoBtn;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        m_demoBtn = (Button) findViewById(R.id.btnDemo);
    }

    /**
     * Start the {@code ButtonActivity}
     *
     * @param view
     */
    public void onClickButtonDemoHandler(View view) {
        Intent btnDemoIntent = new Intent(this, ButtonActivity.class);
        startActivity(btnDemoIntent);
    }
}
