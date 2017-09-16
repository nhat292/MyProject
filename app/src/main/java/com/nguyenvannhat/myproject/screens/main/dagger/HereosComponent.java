package com.nguyenvannhat.myproject.screens.main.dagger;

import com.nguyenvannhat.myproject.application.builder.AppComponent;
import com.nguyenvannhat.myproject.screens.main.HeroesListActivity;

import dagger.Component;

@HeroesScope
@Component(dependencies = {AppComponent.class} , modules = {HeroesModule.class})
public interface HereosComponent {
    void inject(HeroesListActivity heroesActivity);
}
