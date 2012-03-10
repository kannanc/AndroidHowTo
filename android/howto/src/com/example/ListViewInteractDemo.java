package com.example;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Provides...
 *
 * @author http://kannanchandrasekaran.com
 */
public class ListViewInteractDemo extends ListActivity {

   private static final String[] s_dummyItems = new String[15];

   static {
      for (int i = 0; i < s_dummyItems.length; i++) {
         s_dummyItems[i] = "Test " + i;
      }
   }


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.listdemo);
      setListAdapter(new BoldViewAdapter());
   }


   @Override
   protected void onListItemClick(ListView l, View v, int position, long id) {
      State state = (State) v.getTag();
      if (state == null) {
         state = new State();
      }
      state.setCaps(position);
      v.setTag(state);
   }

   private class State {
      private boolean[] caps = new boolean[s_dummyItems.length];

      public void setCaps(int position) {
         if (position < caps.length) {
            caps[position] = true;
         }
      }

      public boolean isCaps(int position) {
         return caps[position];
      }
   }

   private class BoldViewAdapter extends ArrayAdapter<String> {
      public BoldViewAdapter() {

         super(ListViewInteractDemo.this,
                 R.layout.bold_text_adapter_view,
                 R.id.adapter_bold_text, s_dummyItems);
      }

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
         View customView = super.getView(position, convertView, parent);
         State state = (State) customView.getTag();
         TextView txtView = (TextView) customView.
                 findViewById(R.id.adapter_bold_text);
         String text = txtView.getText().toString();
         if (state != null && state.isCaps(position)) {
            txtView.setText("\' " + text.toUpperCase() + " \'");
         } else {
            // undo if any changes you make to the parent view also
         }
         return customView;
      }
   }
}
