package com.nguyenvannhat.myproject.application.builder;

import com.nguyenvannhat.myproject.utils.rx.AppRxSchedulers;
import com.nguyenvannhat.myproject.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;

@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}
