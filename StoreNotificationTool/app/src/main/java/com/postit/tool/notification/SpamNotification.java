package com.postit.tool.notification;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;

import java.text.SimpleDateFormat;

/**
 * Created by hieuapp on 28/06/2016.
 */
public class SpamNotification {
    private String packageName;
    private String ticker;
    private String groupKey;
    private String timestamp;
    private  String tag;
    private boolean isOngoing;
    private boolean isclearabnle;
    private String title;
    private String subText;
    private String text;
    private boolean showChronometer;
    private int originatingUserId;
    private int progressMax;
    private String action;
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public SpamNotification(StatusBarNotification sbn){
        packageName = sbn.getPackageName();
        CharSequence charTicker = sbn.getNotification().tickerText;

        if(charTicker != null){
            ticker = charTicker.toString();
        }
        timestamp = getDate(sbn.getPostTime());
        tag = sbn.getTag();
        isOngoing = sbn.isOngoing();
        isclearabnle = sbn.isClearable();

        Bundle bundle = sbn.getNotification().extras;
        title = bundle.getString("android.title");
        subText = bundle.getString("android.subText");
        text = bundle.getString("android.text");
        showChronometer = bundle.getBoolean("android.showChronometer");
        originatingUserId = bundle.getInt("android.originatingUserId");
        progressMax = bundle.getInt("android.progressMax");
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isOngoing() {
        return isOngoing;
    }

    public void setOngoing(boolean ongoing) {
        isOngoing = ongoing;
    }

    public boolean isclearabnle() {
        return isclearabnle;
    }

    public void setIsclearabnle(boolean isclearabnle) {
        this.isclearabnle = isclearabnle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isShowChronometer() {
        return showChronometer;
    }

    public void setShowChronometer(boolean showChronometer) {
        this.showChronometer = showChronometer;
    }

    public int getOriginatingUserId() {
        return originatingUserId;
    }

    public void setOriginatingUserId(int originatingUserId) {
        this.originatingUserId = originatingUserId;
    }

    public int getProgressMax() {
        return progressMax;
    }

    public void setProgressMax(int progressMax) {
        this.progressMax = progressMax;
    }

    public String getDate(long timestamp){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return dateFormat.format(timestamp);
    }
}
