package com.example.demo3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
   @Override
   public IBinder onBind(Intent arg0) {
      return null;
   }

   @Override
   public int onStartCommand(Intent intent, int flags, int startId) {
    
      Toast.makeText(this, "Demo background service", Toast.LENGTH_SHORT).show();
      return START_STICKY;
   }

   
}
