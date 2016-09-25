package com.postit.notification;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import com.firebase.client.Firebase;

/**
 * Created by hieuapp on 26/06/2016.
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class NotificationListener extends NotificationListenerService {
    Context context;
    public static final String TAG = "NotificationListener";
    Firebase root, notiRef;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        root = new Firebase(FireBaseNotification.ROOT);
        notiRef = root.child(FireBaseNotification.NOTIFICATION_CHILD);

    }
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        NotiStack notiStack = new NotiStack(sbn);

        String sbnId = String.valueOf(sbn.getId());
        notiRef.child(sbnId).setValue(notiStack);
        Log.i(TAG,"have a new Notification");
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        int idRemoved = sbn.getId();
        notiRef.child(String.valueOf(idRemoved)).setValue(null);
        Log.i(TAG,"Remove a notification");
    }

}
