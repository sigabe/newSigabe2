package com.sigabe.sigabe.Emergency;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Service Stop", "Oh");
        context.startService(new Intent(context, BackgroundService.class));

    }
}
