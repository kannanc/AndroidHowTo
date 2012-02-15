package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Main demo activity page intended to demo the individual android components.
 *
 * @author http://kannanchandrasekaran.com
 */
public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClickButtonDemoHandler(View view) {
        launchActivity(ButtonDemo.class);
    }

    public void labelDemoHandler(View view) {
        launchActivity(LabelDemo.class);
    }

    public void optionsDemoHandler(View view) {
        launchActivity(OptionsDemo.class);
    }

    public void linearLayoutDemoLauncher(View view) {
        launchActivity(LinearLayoutDemo.class);
    }

    public void tableLayoutDemoLauncher(View view) {
        launchActivity(TableLayoutDemo.class);
    }

    public void relLayoutDemoLauncher(View view) {
        launchActivity(RelativeLayoutDemo.class);
    }

    public void frameLayoutDemoLauncher(View view) {
        launchActivity(FrameLayoutDemo.class);
    }

    public void imfDemoLauncher(View view) {
        launchActivity(SoftKBDemo.class);
    }

    public void listviewDemoLauncher(View view) {
        launchActivity(ListViewDemo.class);
    }

    public void spinnerDemoLauncher(View view) {
        launchActivity(SpinnerDemo.class);
    }
    public void toastDemoLauncher(View view) {
        launchActivity(ToastDemo.class);
    }

    private <T> void launchActivity(Class<T> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

}


