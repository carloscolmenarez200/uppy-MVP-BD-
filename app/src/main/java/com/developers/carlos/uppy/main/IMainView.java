package com.developers.carlos.uppy.main;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by carlos on 16/02/17.
 */

public interface IMainView {

    void setupViewPager();

    void mostrarToast(String msj);

    void mostrarSnack(String msj,View v);

    void launchActivity(Intent intent);

    void setIconoTabLayout(int tab,int icon);

}
