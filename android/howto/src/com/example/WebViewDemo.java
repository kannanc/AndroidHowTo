package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.*;
import android.widget.Toast;

/**
 * Provides a demo for using the WebView browser element
 *
 * @author http://kannanchandrasekaran.com
 */
public class WebViewDemo extends Activity {

   private static final String URL_TO_LOAD = "http://google.com";
   private static final String LOCAL_RESOURCE = "file:///android_asset/html/HelloWorld.html";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.browser_demo);
      WebView wv = (WebView) findViewById(R.id.browser1);
      loadResource(wv, URL_TO_LOAD);
//      loadResource(wv, LOCAL_RESOURCE);
   }


   private void loadResource(WebView wv, String resource) {
      wv.loadUrl(resource);
      wv.getSettings().setJavaScriptEnabled(true);
      wv.setWebChromeClient(new CustomChromeclient());
      wv.setWebViewClient(new CustomWebViewclient(this));
      wv.addJavascriptInterface(new JavaScriptInterface(wv), "JSI");
      wv.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
   }

   private class CustomChromeclient extends WebChromeClient {
      @Override
      public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
         AlertDialog dialog = new AlertDialog.Builder(view.getContext()).
                 setMessage(message).
                 setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       //do nothing
                    }
                 }).create();
         dialog.show();
         result.confirm();
         return true;
      }
   }


   private static class CustomWebViewclient extends WebViewClient {
      private static int refreshCount;

      private Context m_context;
      private long m_start;

      private CustomWebViewclient(Context context) {
         m_context = context;
      }

      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
         return false;
      }


      @Override
      public void onPageStarted(WebView view, String url, Bitmap favicon) {
         m_start = System.currentTimeMillis();
         refreshCount++;
      }

      @Override
      public void onPageFinished(WebView view, String url) {
         long interval = System.currentTimeMillis() - m_start;
         Toast.makeText(m_context, "Loaded this webpage [" + refreshCount + "] " +
                 "times in [" + interval + "] ms", Toast.LENGTH_SHORT).show();
      }
   }

   private class JavaScriptInterface {
      private final WebView m_wv;

      public JavaScriptInterface(WebView wv) {
         m_wv = wv;
      }

      public void reload() {
         m_wv.reload();
      }
   }
}
