package com.nguyenvannhat.myproject.application.builder;

import android.content.SharedPreferences;

import com.nguyenvannhat.myproject.api.AppApi;
import com.nguyenvannhat.myproject.utils.rx.RxSchedulers;

import dagger.Component;


@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, AppDataModule.class, AppApiServiceModule.class})
public interface AppComponent {
    //Provides to sub component
    RxSchedulers rxSchedulers();
    AppApi apiService();
    SharedPreferences sharedPreferences();
}
