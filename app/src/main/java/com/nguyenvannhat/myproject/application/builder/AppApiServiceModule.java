package com.nguyenvannhat.myproject.application.builder;

import com.nguyenvannhat.myproject.api.AppApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class AppApiServiceModule {

    private static final String BASE_URL = "http://coemygroup.fr/";
    @AppScope
    @Provides
    AppApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter)
    {
        Retrofit retrofit =   new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson).
                        addCallAdapterFactory(rxAdapter).build();

        return  retrofit.create(AppApi.class);
    }


}
