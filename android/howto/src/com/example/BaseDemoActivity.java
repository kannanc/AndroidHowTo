package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Base Activity that supports common functions for the demo
 *
 * @author http://kannanchandrasekaran.com
 */
public abstract class BaseDemoActivity extends Activity {
    /**
     * Button for returning to the main demo page
     */
    protected Button m_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Go to the main activityPage
     *
     * @param view
     */
    public void goHome(View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
}
