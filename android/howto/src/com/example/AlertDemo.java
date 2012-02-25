package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Provides...
 *
 * @author http://kannanchandrasekaran.com
 */
public class AlertDemo extends Activity {

   /* Set the Ids for identifying the types of  dialog */
   private static final int DIALOG_SIMPLE = 1;
   private static final int DIALOG_LIST = 2;
   private static final int DIALOG_MULTI_LIST = 3;

   /* Dummy Input list for list based dialogs */
   private static final CharSequence[] itemList = {"Android", "Iphone", "Windows"};

   @Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.alert_demo);
   /* 1. Standard alert Dialog with 2 buttons*/
   Button simpleAlert = (Button) findViewById(R.id.alert_simple);
   simpleAlert.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
         showDialog(DIALOG_SIMPLE);
      }
   });

   /* 2. Dialog with a list of items. Single selection only */
   Button listAlert = (Button) findViewById(R.id.alert_list);
   listAlert.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
         removeDialog(DIALOG_LIST);
         showDialog(DIALOG_LIST);
      }
   });

   /* 3. Dialog with a list of items. Multiple selections */
   Button multiListAlert = (Button) findViewById(R.id.alert_multi_list);
   multiListAlert.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
         showDialog(DIALOG_MULTI_LIST);
      }
   });
}

/* onCreateDialog() gets called the first time the dialog needs to be created */
@Override
protected Dialog onCreateDialog(int id) {
   Dialog dialog = null;
   switch (id) {
      case DIALOG_SIMPLE: {
         dialog = createSimpleDialog();
         break;
      }
      case DIALOG_LIST: {
         dialog = createListDialog();
         break;
      }
      case DIALOG_MULTI_LIST: {
         dialog = createMultiListDialog();
         break;
      }
      default:
         dialog = super.onCreateDialog(id);
   }
   return dialog;
}

/*  Uses the setMultipleChoiceItems() to handle multiple selections */
private Dialog createMultiListDialog() {
   AlertDialog.Builder builder = new AlertDialog.Builder(this);
   builder.setCancelable(true)
           .setMultiChoiceItems(itemList, null, new DialogInterface.OnMultiChoiceClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                 CharSequence item = itemList[which];
                 String message = itemList[which] + " is " + (isChecked ? "selected" : "deselected");
                 createToast(message);
              }
           });

   return builder.create();
}

/* Uses the setSinglechoiceItems() to handle single selections */
private Dialog createListDialog() {
   AlertDialog.Builder builder = new AlertDialog.Builder(this);
   builder.setCancelable(true)
           .setSingleChoiceItems(itemList, -1, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                 createToast(itemList[which].toString());

              }
           });
   return builder.create();
}

/* Simple alert dialog with 2 buttons */
private Dialog createSimpleDialog() {
   AlertDialog.Builder builder = new AlertDialog.Builder(this);
   builder.setMessage("I am a simple Dialog with 2 buttons")
           .setCancelable(false)
                   /* Set the positive button ("YES"/ "OK")*/
           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                 createToast("You clicked OK Button");
              }
           })
                   /* Set the negative button ("NO"/ "CANCEL")*/
           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                 createToast("You clicked the Cancel  Button");
              }
           });
   return builder.create();
}

   /* Helper for creating the toast */
   private void createToast(String message) {
      Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
   }
}
