package com.nguyenvannhat.myproject.screens.base;

import android.content.Context;
import android.view.View;

/**
 * Created by Nhat on 9/17/17.
 */

public abstract class BaseView {

    public Context context;
    public BaseView(Context context) {
        this.context = context;
    }
    public abstract View getView();
}
