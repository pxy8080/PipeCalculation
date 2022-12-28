package com.pyy;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;


public class MainApplication extends Application {
    public static MainApplication mContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = MainApplication.this;
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public static void showToast(ShowToastEvent showToastEvent) {
//        Toast.makeText(mContext, showToastEvent.getToast(), Toast.LENGTH_SHORT).show();
//    }

}
