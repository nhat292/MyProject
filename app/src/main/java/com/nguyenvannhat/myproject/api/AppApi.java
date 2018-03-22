package com.nguyenvannhat.myproject.api;


import com.nguyenvannhat.myproject.models.Heroes;

import retrofit2.http.GET;
import rx.Observable;


public interface AppApi {

    @GET("test-mobile/iOS/json/test2.json")
    Observable<Heroes> getHeroes();
}
