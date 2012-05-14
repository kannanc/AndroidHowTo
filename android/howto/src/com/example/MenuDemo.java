package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Provides...
 *
 * @author Kannan Chandrasekaran
 */
public class MenuDemo extends Activity {

    private TextView m_tv1;
    private final Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menudemo);
        m_tv1 = (TextView) findViewById(R.id.contextmenutxt);
        TextView tv2 = (TextView) findViewById(R.id.resetMenu);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invalidateOptionsMenu();
            }
        });
        registerForContextMenu(m_tv1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(
                Menu.NONE, // Group ID
                Menu.FIRST + 1, // ItemId
                Menu.NONE,  // ordering
                "Option " + rand.nextInt());// title
        return super.onCreateOptionsMenu(menu);
    }
    //todo: provide a onMenuClickListener

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        int size = menu.size();
        MenuItem lastItem = menu.getItem(size - 1);
        int itemId = lastItem.getItemId() + 1;
        menu.add(lastItem.getGroupId(), itemId, lastItem.getOrder(), "option " + itemId);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String text = item.getTitle() + ":" + item.getItemId();
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.color_menu, menu);
        menu.setHeaderTitle("Choose a Color");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_red:
                m_tv1.setBackgroundResource(R.color.LightRed);
                return true;
            case R.id.menu_blue:
                m_tv1.setBackgroundResource(R.color.DullBlue);
                return true;
            case R.id.menu_green:
                m_tv1.setBackgroundResource(R.color.LightGreen);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}
