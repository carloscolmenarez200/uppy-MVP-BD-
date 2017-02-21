package com.developers.carlos.uppy.mascota_perfil;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.developers.carlos.uppy.OnItemClickListener;
import com.developers.carlos.uppy.R;
import com.developers.carlos.uppy.adaptadores.MascotaPerfilAdaptador;
import com.developers.carlos.uppy.mascotas.IMascotaPresenter;
import com.developers.carlos.uppy.mascotas.MascotaIteractorImp;
import com.developers.carlos.uppy.mascotas.MascotaPresenterImp;
import com.developers.carlos.uppy.modelos.Mascota;
import com.developers.carlos.uppy.modelos.MascotaData;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaPerfilFragment extends Fragment implements IMascotaPerfilView{

    private MascotaPerfilAdaptador perfilAdaptador;
    private IMascotaPerfilPresenter mascotaPresenter;


    public MascotaPerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mi_mascota, container, false);

        inicializarPerfil(v);

        RecyclerView miRecycler = (RecyclerView) v.findViewById(R.id.mi_recycler_perfil);
        perfilAdaptador = crearAdaptador();
        setupRecycler(miRecycler,perfilAdaptador);

        mascotaPresenter = new MascotaPerfilPresenterImp(this,new MascotaPerfilIteractorImp());

        return v;
    }

    private void inicializarPerfil(View v){
        CircularImageView fotoMacota = (CircularImageView) v.findViewById(R.id.img_miMascota);
        TextView nombreMacota = (TextView) v.findViewById(R.id.tv_nombre_perfil);

        Glide.with(this.getContext())
                .load(MascotaData.MASCOTAS_DATA_PERFIL.get(0).getFoto())
                .centerCrop()
                .into(fotoMacota);
        nombreMacota.setText(MascotaData.MASCOTAS_DATA_PERFIL.get(0).getNombre());
    }

    @Override
    public void onResume() {
        super.onResume();
        mascotaPresenter.onResume();
    }

    @Override
    public void setData(List<Mascota> mascotas) {
        perfilAdaptador.setItems(mascotas);
    }

    @Override
    public void mostrarToast(String msj) {
        Toast.makeText(getActivity(),msj,Toast.LENGTH_SHORT).show();
    }

    private void setupRecycler(RecyclerView miRecycler, RecyclerView.Adapter adapter) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        miRecycler.setLayoutManager(gridLayoutManager);
        miRecycler.setAdapter(adapter);
    }

    private MascotaPerfilAdaptador crearAdaptador(){
        MascotaPerfilAdaptador perfilAdaptador = new MascotaPerfilAdaptador();
        perfilAdaptador.setItemClickListener(new OnItemClickListener<Mascota>() {
            @Override
            public void onItemClicked(int position, Mascota item) {
                mascotaPresenter.onClickItem(position,item);
            }
        });
        return perfilAdaptador;

    }
}
