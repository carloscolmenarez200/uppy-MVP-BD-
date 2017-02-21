package com.developers.carlos.uppy.mascotas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.developers.carlos.uppy.OnItemClickListener;
import com.developers.carlos.uppy.R;
import com.developers.carlos.uppy.adaptadores.MascotaAdaptador;
import com.developers.carlos.uppy.modelos.Mascota;
import com.developers.carlos.uppy.modelos.MascotaData;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragment extends Fragment implements IMascotaView{

    private IMascotaPresenter mascotaPresenter;
    private MascotaAdaptador mascotaAdaptador;


    public MascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascota, container, false);

        RecyclerView miRecycler = (RecyclerView) v.findViewById(R.id.mi_recycler);
        mascotaAdaptador = crearAdaptador();
        setupRecycler(miRecycler,mascotaAdaptador);

        mascotaPresenter = new MascotaPresenterImp(this,new MascotaIteractorImp(),getContext());
        mascotaPresenter.insertarDB();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mascotaPresenter.onResume();
    }

    @Override
    public void setData(List<Mascota> mascotas) {
        mascotaAdaptador.setItems(mascotas);
    }

    @Override
    public void mostrarToast(String msj) {
        Toast.makeText(getActivity(),msj,Toast.LENGTH_SHORT).show();
    }

    private void setupRecycler(RecyclerView miRecycler, RecyclerView.Adapter adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        miRecycler.setLayoutManager(linearLayoutManager);
        miRecycler.setAdapter(adapter);
    }

    private MascotaAdaptador crearAdaptador(){
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador();
        mascotaAdaptador.setItemClickListener(new OnItemClickListener<Mascota>() {
            @Override
            public void onItemClicked(int position, Mascota item) {
                mascotaPresenter.onClickMeGusta(item);
            }
        });
        return mascotaAdaptador;

    }
}
