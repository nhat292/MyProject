package com.nguyenvannhat.myproject.screens.main.dagger;

import com.nguyenvannhat.myproject.api.AppApi;
import com.nguyenvannhat.myproject.screens.main.HeroesListActivity;
import com.nguyenvannhat.myproject.screens.main.core.HeroesModel;
import com.nguyenvannhat.myproject.screens.main.core.HeroesPresenter;
import com.nguyenvannhat.myproject.screens.main.core.HeroesView;
import com.nguyenvannhat.myproject.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

@Module
public class HeroesModule {

    HeroesListActivity heroesListContext;

    public HeroesModule(HeroesListActivity context) {
        this.heroesListContext = context;
    }

    @HeroesScope
    @Provides
    HeroesView provideView() {
        return new HeroesView(heroesListContext);
    }

    @HeroesScope
    @Provides
    HeroesPresenter providePresenter(RxSchedulers schedulers, HeroesView view, HeroesModel model) {
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new HeroesPresenter(schedulers, model, view, subscriptions);
    }

    @HeroesScope
    @Provides
    HeroesListActivity provideContext() {
        return heroesListContext;
    }

    @HeroesScope
    @Provides
    HeroesModel provideModel(AppApi api) {
        return new HeroesModel(heroesListContext, api);
    }
}
