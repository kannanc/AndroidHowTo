package com.example;

import android.R;
import android.app.Activity;
import android.os.Bundle;

/**
 * Provides a demo for Virtual Keyboard.
 *
 * Note: This example code should only be run on a
 * AVD that has no physical keyboard.
 *
 * @author http://kannanchandrasekaran.com
 */
public class SoftKBDemo extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.R.layout.softkbdemo);
    }
}
