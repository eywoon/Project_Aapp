package is.hi.project_aapp.Settings;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

import is.hi.project_aapp.MainActivity;
import is.hi.project_aapp.R;
import is.hi.project_aapp.TaskManager.TaskKeeper;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        prufa fyrir notifications
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        String text = "lol";

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");


        Intent resultIntent = new Intent(this, MainActivity.class);

        // Because clicking the notification opens a new ("special") activity, there's
        // no need to create an artificial back stack.
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );


        mBuilder.setContentIntent(resultPendingIntent);


    //    NotificationCompat.Builder mBuilder;
        // Sets an ID for the notification
       // Use the notify() method to issue the notification. When you call notify(), specify a notification ID. You can use
      //  this ID to update the notification later on. This is described in more detail in Managing Notifications.
        // http://developer.android.com/training/notify-user/managing.html
        int mNotificationId = 001;
// Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

    }
}
