package com.nguyenvannhat.myproject.screens.main.core;


import android.app.Activity;

import com.nguyenvannhat.myproject.api.AppApi;
import com.nguyenvannhat.myproject.models.Hero;
import com.nguyenvannhat.myproject.models.Heroes;
import com.nguyenvannhat.myproject.screens.base.BaseModel;
import com.nguyenvannhat.myproject.screens.main.HeroesListActivity;

import rx.Observable;

public class HeroesModel extends BaseModel {

    public HeroesModel(Activity context, AppApi api) {
        super(context, api);
    }

    public Observable<Heroes> provideListHeroes() {
        return api.getHeroes();
    }

    public void gotoHeroDetailsActivity(Hero hero) {
        ((HeroesListActivity) context).goToHeroDetailsActivity(hero);
    }


}
