package com.example.demo3;

import android.support.v4.app.NotificationCompat;

import android.support.v7.app.ActionBarActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	

	public static final String EXTRA_MESSAGE = "com.example.demo3.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void sendMessage(View view) {
		
		   startService(view);
		   stopService(view);
		
		
		  EditText editText = (EditText) findViewById(R.id.text_input);
		  String message = editText.getText().toString();
		  
		  
		 
 
		  
		  NotificationCompat.Builder mBuilder =
				    new NotificationCompat.Builder(this)
				    .setSmallIcon(R.drawable.ic_launcher)
				    .setContentTitle("Demo")
				    .setContentText(message)
		            .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
		            .setAutoCancel(true);
			Intent resultIntent = new Intent(this, MainActivity.class);

			PendingIntent resultPendingIntent =
			    PendingIntent.getActivity(
			    this,
			    0,
			    resultIntent,
			    PendingIntent.FLAG_UPDATE_CURRENT
			);
			 mBuilder.setContentIntent(resultPendingIntent);
			//NotificationCompat.Builder mBuilder;

		 	
			int mNotificationId = 001;
			// Gets an instance of the NotificationManager service
			NotificationManager mNotifyMgr = 
			        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
			// Builds the notification and issues it.
			mNotifyMgr.notify(mNotificationId, mBuilder.build());


		
	    
	}
		      public void startService(View view) {
			      startService(new Intent(getBaseContext(), MyService.class));
		      }


		      // Method to stop the service
		      public void stopService(View view) {
		         stopService(new Intent(getBaseContext(), MyService.class));
		      } 
		    
}
