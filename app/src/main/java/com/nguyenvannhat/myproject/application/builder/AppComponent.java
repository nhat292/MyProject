package com.nguyenvannhat.myproject.application.builder;

import com.nguyenvannhat.myproject.api.AppApi;
import com.nguyenvannhat.myproject.utils.rx.RxSchedulers;

import dagger.Component;


@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, AppApiServiceModule.class})
public interface AppComponent {
    RxSchedulers rxSchedulers();
    AppApi apiService();
}
