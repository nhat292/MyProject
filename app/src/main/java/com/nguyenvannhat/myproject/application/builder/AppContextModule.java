package com.nguyenvannhat.myproject.application.builder;

import android.content.Context;
import android.content.SharedPreferences;

import com.nguyenvannhat.myproject.R;

import dagger.Module;
import dagger.Provides;

@Module
public class AppContextModule {

    private final Context context;

    public AppContextModule(Context aContext) {
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }

    @AppScope
    @Provides
    SharedPreferences provideSharePreference(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    }

}
