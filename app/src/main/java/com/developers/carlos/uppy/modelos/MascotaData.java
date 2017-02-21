package com.developers.carlos.uppy.modelos;

import com.developers.carlos.uppy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 29/09/16.
 */

public class MascotaData {

    public static final List<Mascota> MASCOTAS_DATA = new ArrayList<>();
    public static final List<Mascota> MASCOTAS_DATA_PERFIL = new ArrayList<>();


    static {
        MASCOTAS_DATA.add(new Mascota("Mickey", R.drawable.perro_1,2,false));
        MASCOTAS_DATA.add(new Mascota("Doggy", R.drawable.perro_2,8,false));
        MASCOTAS_DATA.add(new Mascota("Bloy y Caty", R.drawable.perro_4,3,false));
        MASCOTAS_DATA.add(new Mascota("Luna", R.drawable.perro_6,4,false));
        MASCOTAS_DATA.add(new Mascota("Pepita", R.drawable.perro_7,11,false));
        MASCOTAS_DATA.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA.add(new Mascota("Pepita", R.drawable.perro_7,0,false));


        MASCOTAS_DATA_PERFIL.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA_PERFIL.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA_PERFIL.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA_PERFIL.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA_PERFIL.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA_PERFIL.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA_PERFIL.add(new Mascota("Pepita", R.drawable.perro_7,0,false));
        MASCOTAS_DATA_PERFIL.add(new Mascota("Pepita", R.drawable.perro_7,0,false));

    }
}
