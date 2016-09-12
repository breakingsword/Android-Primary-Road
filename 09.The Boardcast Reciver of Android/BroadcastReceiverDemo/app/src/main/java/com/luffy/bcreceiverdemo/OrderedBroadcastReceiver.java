package com.luffy.bcreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by luffy on 2016/7/29.
 */
public class OrderedBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"我是有序广播，我是动态注册的",Toast.LENGTH_SHORT).show();
        Log.i("receiver","ordered");
    }
}
