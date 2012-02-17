package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Provides...
 *
 * @author http://kannanchandrasekaran.com
 */
public class ToastDemo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toastdemo);

        Button toastBtn = (Button) findViewById(R.id.toast_btn);
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(ToastDemo.this, "Here is a toast..to Android !!!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 10,10);
                toast.show();
            }
        });

        Button toastBtn2 = (Button) findViewById(R.id.toast_btn2);
        final View toastView = getLayoutInflater().inflate(R.layout.toastview_layout, null);

        toastBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(ToastDemo.this);
                toast.setView(toastView);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}