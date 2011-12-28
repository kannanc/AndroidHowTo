package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Base Activity that supports common functions for the demo
 *
 * @author http://kannanchandrasekaran.com
 */
public abstract class BaseDemoActivity extends Activity {

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
        Intent home = new Intent(this, MyActivity.class);
        startActivity(home);
    }
}
