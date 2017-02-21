package com.developers.carlos.uppy.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.developers.carlos.uppy.OnItemClickListener;
import com.developers.carlos.uppy.R;
import com.developers.carlos.uppy.modelos.Mascota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 29/09/16.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaHolder> {


    private List<Mascota> items;
    private OnItemClickListener<Mascota> mItemClickListener;
    private Context mContext;


    public MascotaAdaptador() {
        items = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public MascotaHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (mContext == null)
            mContext = viewGroup.getContext();

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_mascota, viewGroup, false);
        return new MascotaHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaHolder viewHolder, int i) {

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


    public class MascotaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv_nombre_mascota;
        public TextView tv_me_gusta;
        public ImageView img_mascota;
        public ImageView ic_hueso;

        public Mascota mascota;


        public MascotaHolder(View v) {
            super(v);

            tv_nombre_mascota = (TextView) v.findViewById(R.id.tv_nombre_mascota);
            tv_me_gusta = (TextView) v.findViewById(R.id.tv_me_gusta);
            img_mascota = (ImageView) v.findViewById(R.id.img_mascota);
            ic_hueso = (ImageView) v.findViewById(R.id.ic_hueso);
            ic_hueso.setOnClickListener(this);
        }

        public void bindMascota(Mascota mascota){
            this.mascota = mascota;

            Glide.with(mContext)
                    .load(mascota.getFoto())
                    .centerCrop()
                    .into(img_mascota);
            tv_nombre_mascota.setText(mascota.getNombre());
            tv_me_gusta.setText(String.valueOf(mascota.getCantidadMeGusta()));
            ic_hueso.setImageResource(mascota.isMeGusta()?R.drawable.dog_bone_48_color:R.drawable.dog_bone_48);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null){

                if(mascota.isMeGusta()){
                    mascota.setCantidadMeGusta(mascota.getCantidadMeGusta()-1);
                    ic_hueso.setImageResource(R.drawable.dog_bone_48);
                }
                else{
                    ic_hueso.setImageResource(R.drawable.dog_bone_48_color);
                    mascota.setCantidadMeGusta(mascota.getCantidadMeGusta()+1);
                }

                mascota.setMeGusta(!mascota.isMeGusta());
                mItemClickListener.onItemClicked(getAdapterPosition(), mascota);
                tv_me_gusta.setText(String.valueOf(mascota.getCantidadMeGusta()));
            }

        }
    }

}
