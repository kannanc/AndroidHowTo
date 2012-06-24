package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Provides...
 *
 * @author Kannan Chandrasekaran
 */
public class MenuDemo extends Activity {

   private TextView m_contextColor;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.menudemo);
      m_contextColor = (TextView) findViewById(R.id.context_color);
      /**
       * Register the View elements in the activity to generate
       * Context menus
       */
      registerForContextMenu(m_contextColor);
   }

@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
   switch (v.getId()) {
      case R.id.context_color:
         createMenu(R.menu.color_menu, menu, "Choose a color");
         break;
      default:
         super.onCreateContextMenu(menu, v, menuInfo);
   }
}
   private void createMenu(int menuID, ContextMenu menu, String title) {
      /**
       * Use a MenuInflater associated with the activity to
       * inflate the Menu layout
       */
      getMenuInflater().inflate(menuID, menu);
      menu.setHeaderTitle(title);
   }

   @Override
   public boolean onContextItemSelected(MenuItem item) {
      switch (item.getItemId()) {
         case R.id.menu_red:
            m_contextColor.setBackgroundResource(R.color.LightRed);
            return true;
         case R.id.menu_blue:
            m_contextColor.setBackgroundResource(R.color.DullBlue);
            return true;
         case R.id.menu_green:
            m_contextColor.setBackgroundResource(R.color.LightGreen);
            return true;
         default:
            return super.onContextItemSelected(item);
      }
   }
}
