package com.developers.carlos.uppy.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.developers.carlos.uppy.OnItemClickListener;
import com.developers.carlos.uppy.R;
import com.developers.carlos.uppy.modelos.Mascota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 13/10/16.
 */

public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.ViewHolder> {


    private List<Mascota> items;
    private OnItemClickListener<Mascota> mItemClickListener;
    private Context mContext;


    public MascotaPerfilAdaptador() {
        items = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (mContext == null)
            mContext = viewGroup.getContext();

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_mascota_perfil, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.bindMascota(items.get(i));

    }

    public void setItems(List<Mascota> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void setItemClickListener(OnItemClickListener<Mascota> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tv_me_gusta;
        public ImageView img_mascota;
        public ImageView ic_hueso;

        public Mascota mascota;


        public ViewHolder(View v) {
            super(v);

            tv_me_gusta = (TextView) v.findViewById(R.id.tv_me_gusta);
            img_mascota = (ImageView) v.findViewById(R.id.img_mascota);
            ic_hueso = (ImageView) v.findViewById(R.id.ic_hueso);

            v.setOnClickListener(this);
        }

        public void bindMascota(Mascota mascota){
            this.mascota = mascota;

            Glide.with(mContext)
                    .load(mascota.getFoto())
                    .centerCrop()
                    .into(img_mascota);
            tv_me_gusta.setText(String.valueOf(mascota.getCantidadMeGusta()));
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null){
                mItemClickListener.onItemClicked(getAdapterPosition(), mascota);
            }
        }
    }

}
