package com.nguyenvannhat.myproject.screens.base;

import android.app.Activity;

import com.nguyenvannhat.myproject.api.AppApi;
import com.nguyenvannhat.myproject.utils.NetworkUtils;

import rx.Observable;

/**
 * Created by Nhat on 9/17/17.
 */

public class BaseModel {

    public AppApi api;
    public Activity context;

    public BaseModel(Activity context, AppApi api) {
        this.api = api;
        this.context = context;
    }

    public Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }
}
