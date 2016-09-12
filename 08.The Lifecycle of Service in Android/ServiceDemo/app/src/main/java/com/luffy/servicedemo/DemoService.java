package com.luffy.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by luffy on 2016/7/22.
 */
public class DemoService extends Service{


    private static final String TAG ="ServiceStatus " ;
    private LocalBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {

        public DemoService getService() {
            return DemoService.this;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "====onBind=====",Toast.LENGTH_LONG).show();
        return null;
    }
    @Override
    public boolean onUnbind(Intent intent){
        Toast.makeText(this, "====onUnbind=====",Toast.LENGTH_LONG).show();
        return  super.onUnbind(intent);
    }

    @Override
    public void onCreate(){
        Toast.makeText(this, "====onCreate=====",Toast.LENGTH_LONG).show();

        super.onCreate();
    }

    @Override
    public  int onStartCommand(Intent intent,int flags,int startId){
        Toast.makeText(this, "====onStartConmmand=====",Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this, "====onDestroy=====",Toast.LENGTH_LONG).show();

        super.onDestroy();
    }
}
