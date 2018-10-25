package com.ravi.w3schools;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Ravi on 30-03-2018.
 */

public class ConnectionDetect {
    Context context;
    public ConnectionDetect(Main2Activity context){
        this.context=context;
    }
    public boolean isConnected(){
        ConnectivityManager connectivity=(ConnectivityManager)context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if(connectivity!=null){
            NetworkInfo info=connectivity.getActiveNetworkInfo();
            if(info!=null){
                if(info.getState()==NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }
}
