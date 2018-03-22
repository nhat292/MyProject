package com.nguyenvannhat.myproject.application;

import android.app.Application;

import com.nguyenvannhat.myproject.application.builder.AppComponent;
import com.nguyenvannhat.myproject.application.builder.AppContextModule;
import com.nguyenvannhat.myproject.application.builder.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import timber.log.BuildConfig;
import timber.log.Timber;


public class MyApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }

    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {

                }
            });
        }
    }

    public static AppComponent getNetComponent() {
        return appComponent;
    }

}
