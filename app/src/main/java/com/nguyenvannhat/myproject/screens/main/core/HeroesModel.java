package com.nguyenvannhat.myproject.screens.main.core;


import com.nguyenvannhat.myproject.api.AppApi;
import com.nguyenvannhat.myproject.models.Hero;
import com.nguyenvannhat.myproject.models.Heroes;
import com.nguyenvannhat.myproject.screens.main.HeroesListActivity;
import com.nguyenvannhat.myproject.utils.NetworkUtils;

import rx.Observable;

public class HeroesModel {

    HeroesListActivity context;
    AppApi api;

    public HeroesModel(HeroesListActivity context, AppApi api) {
        this.api = api;
        this.context = context;
    }

    Observable<Heroes> provideListHeroes() {
        return api.getHeroes();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }

    public void gotoHeroDetailsActivity(Hero hero) {
        context.goToHeroDetailsActivity(hero);
    }


}
