package com.nguyenvannhat.myproject.application.builder;

import android.content.Context;
import android.content.SharedPreferences;

import com.nguyenvannhat.myproject.R;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Nhat on 9/20/17.
 */

@Module
public class AppDataModule {

    @AppScope
    @Provides
    SharedPreferences provideSharePreference(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    }
}
