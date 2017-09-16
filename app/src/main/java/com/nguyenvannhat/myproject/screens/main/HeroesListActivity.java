package com.nguyenvannhat.myproject.screens.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.nguyenvannhat.myproject.application.AppController;
import com.nguyenvannhat.myproject.models.Hero;
import com.nguyenvannhat.myproject.screens.main.core.HeroesPresenter;
import com.nguyenvannhat.myproject.screens.main.core.HeroesView;
import com.nguyenvannhat.myproject.screens.main.dagger.DaggerHereosComponent;
import com.nguyenvannhat.myproject.screens.main.dagger.HeroesModule;

import javax.inject.Inject;


public class HeroesListActivity extends AppCompatActivity {
    @Inject
    HeroesView view;
    @Inject
    HeroesPresenter presenter;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerHereosComponent.builder().appComponent(AppController.getNetComponent()).heroesModule(new HeroesModule(this)).build().inject(this);
        setContentView(view.view());
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void goToHeroDetailsActivity(Hero hero) {
        Toast.makeText(getApplicationContext(), "Detail", Toast.LENGTH_LONG).show();
    }

}
