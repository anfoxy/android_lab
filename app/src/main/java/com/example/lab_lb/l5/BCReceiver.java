package com.example.lab_lb.l5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BCReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Lab57.INCREASE_ACTION)) {
            Intent i = new Intent(Lab57.INCREASE_ACTION);
            context.sendBroadcast(i);
        } else {
            Intent i = new Intent(Lab57.DECREASE_ACTION);
            context.sendBroadcast(i);
        }
    }
}
