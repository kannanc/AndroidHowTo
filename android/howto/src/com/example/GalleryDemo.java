package com.example;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * Provides...
 *
 * @author http://kannanchandrasekaran.com
 */
public class GalleryDemo extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.gallerydemo);
      Gallery gallery = (Gallery) findViewById(R.id.gallery);
      final CustomAdapter adapter = new CustomAdapter(this);
      gallery.setAdapter(adapter);

      gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String name = getResources().getString((Integer) adapter.getItem(position));
            int startIndex = name.lastIndexOf("/");
            name = name.substring(startIndex + 1);
            Toast.makeText(GalleryDemo.this,name,Toast.LENGTH_LONG).show();
         }
      });

   }

private class CustomAdapter extends BaseAdapter {

   private Context m_context;

   /**
    * An array of input resource ids
    */
   private final Integer[] m_imgs = {
           R.drawable.autumn,
           R.drawable.creek,
           R.drawable.desert
   };

   public CustomAdapter(Context context) {
      m_context = context;

   }

   @Override
   public int getCount() {
      return m_imgs.length;
   }

   @Override
   public Object getItem(int position) {
      return m_imgs[position];
   }

   @Override
   public long getItemId(int position) {
      return position;
   }

   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
      ImageView imgView = new ImageView(m_context);
      imgView.setImageResource(m_imgs[position]);
      imgView.setScaleType(ImageView.ScaleType.FIT_XY);
      imgView.setLayoutParams(new Gallery.LayoutParams(200, 300));
      return imgView;
   }
}
}
