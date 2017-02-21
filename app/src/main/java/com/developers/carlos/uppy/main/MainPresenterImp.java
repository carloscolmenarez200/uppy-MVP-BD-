package com.developers.carlos.uppy.main;


import android.view.View;

/**
 * Created by carlos on 16/02/17.
 */

public class MainPresenterImp implements IMainPresenter {

    private IMainView iMainView;


    public MainPresenterImp(IMainView iMainView){

        this.iMainView = iMainView;
    }

    @Override
    public void onClickSubirFoto(View v) {
        iMainView.mostrarSnack("No implementado",v);
    }
}
