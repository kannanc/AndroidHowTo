package com.example;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Provides...
 *
 * @author http://kannanchandrasekaran.com
 */
public class ListViewCustomLayout extends ListActivity{
   private TextView m_clickTracker;

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.listdemo);
           m_clickTracker = (TextView) findViewById(R.id.listdemo_tv1);
           String[] platforms = getResources().getStringArray(R.array.dev_platforms);
           ListAdapter listAdapter = new ArrayAdapter<String>(this,
                                                       R.layout.img_text_adapter_view,
                                                       R.id.adapter_tv, platforms);
           setListAdapter(listAdapter);
       }

       @Override
       protected void onListItemClick(ListView l, View v, int position, long id) {
           StringBuilder text = new StringBuilder(m_clickTracker.getText());
           if (text.length() > 0) {
               text.append(", ");
           }
           TextView tv = (TextView) v.findViewById(R.id.adapter_tv);
           text.append(tv.getText());
           m_clickTracker.setText(text.toString());
       }
}
