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
 * Provides a demo for Android Menus
 *
 * @author Kannan Chandrasekaran
 */
public class MenuDemo extends Activity {

   private TextView m_contextColor;
   private final Random rand = new Random();

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.menudemo);
      m_contextColor = (TextView) findViewById(R.id.context_color);
      /**
       * Resets the options menu to start from scratch
       */
      TextView tv2 = (TextView) findViewById(R.id.resetMenu);
      tv2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            invalidateOptionsMenu();
         }
      });
      /**
       * Register the View elements in the activity to generate
       * Context menus
       */
      registerForContextMenu(m_contextColor);
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
      /**
       * Add a new manu item each time the android menu button is clicked
       */
      menu.add(lastItem.getGroupId(), itemId, lastItem.getOrder(), "option " + itemId);
      return true;
   }

   /**
    * Handle Options menu selections  by displaying a toast message
    * @param item
    * @return
    */
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      String text = item.getTitle() + ":" + item.getItemId();
      Toast.makeText(this, text, Toast.LENGTH_LONG).show();
      return true;
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

   /**
    * Handle context Menu item selections.
    * @param item
    * @return
    */
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
