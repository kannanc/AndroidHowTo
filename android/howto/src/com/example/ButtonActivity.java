package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * A Simple activity to demonstrate button click.
 *
 * @author http://kannanchandrasekaran.com
 */
public class ButtonActivity extends BaseDemoActivity {
    /**
     * Go to the Main Demo activity
     */
    Button m_home;
    /**
     * Demo button
     */
    Button m_button;
    Random m_rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonactivity);
        m_button = (Button) findViewById(R.id.button);
        m_home = (Button) findViewById(R.id.home);
        m_rand = new Random();
    }

    /**
     * Onclick Handler. Gets called when the demo button is clicked.
     * Sets the text property of the demo button with a random number.
     *
     * @param view
     */
    public void clickHandler(View view) {
        m_button.setText("Setting random no to : " + m_rand.nextDouble());
    }

}
