package com.google.android.gms.samples.vision.face.googlyeyes;

import android.app.IntentService;
import android.content.Intent;

public class Background_service extends IntentService
{

    public Background_service()
    {
        super("Background_service");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        final YourTask yourTask = new YourTask();
        final Thread thread = new Thread(yourTask);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public class YourTask implements Runnable {
        @Override
        public void run()
        {
         try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(DeviceControlActivity.Broadcasr_recievre.PROCESS_RESPONSE);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            sendBroadcast(broadcastIntent);



            final Intent mServiceIntent = new Intent(Background_service.this,Background_service.class);

            startService(mServiceIntent);
        }
    }
}
