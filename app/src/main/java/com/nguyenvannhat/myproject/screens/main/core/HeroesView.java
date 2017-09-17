package com.nguyenvannhat.myproject.screens.main.core;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.nguyenvannhat.myproject.R;
import com.nguyenvannhat.myproject.models.Hero;
import com.nguyenvannhat.myproject.screens.base.BaseView;
import com.nguyenvannhat.myproject.screens.main.HeroesListActivity;
import com.nguyenvannhat.myproject.screens.main.list.HeroesAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;


public class HeroesView extends BaseView {

    @BindView(R.id.activity_heroes_list_recycleview)
    RecyclerView list;
    View view;
    HeroesAdapter adapter;

    public HeroesView(HeroesListActivity context) {
        super(context);
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_heroes_list, parent, true);
        ButterKnife.bind(this, view);

        adapter = new HeroesAdapter();

        list.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        list.setLayoutManager(mLayoutManager);
    }

    @Override
    public View getView() {
        return view;
    }

    public Observable<Integer> itemClicks() {
        return adapter.observeClicks();
    }

    public void swapAdapter(ArrayList<Hero> heroes) {
        adapter.swapAdapter(heroes);
    }

}
