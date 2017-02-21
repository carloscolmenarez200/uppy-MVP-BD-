package com.developers.carlos.uppy.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.developers.carlos.uppy.modelos.Mascota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 20/02/17.
 */

public class MascotaDB {

    private DBHelper openHelper;
    private SQLiteDatabase database;

    public MascotaDB(Context context) {
        openHelper = new DBHelper(context);
        database = openHelper.getWritableDatabase();
    }

    private ContentValues getValues(Mascota mascota){

        ContentValues values = new ContentValues();

        values.put(Constante.ColumnasMascota.C_NOMBRE,mascota.getNombre());
        values.put(Constante.ColumnasMascota.C_FOTO,mascota.getFoto());
        values.put(Constante.ColumnasMascota.C_CANTIDAD_ME_GUSTA,mascota.getCantidadMeGusta());
        values.put(Constante.ColumnasMascota.C_ME_GUSTA,mascota.isMeGusta()?1:0);

        return values;
    }

    public void guardarMascota(Mascota mascota){

        database.insert(Constante.MASCOTA_TABLE_NAME, null, getValues(mascota));
    }

    public  void  updateMascota(Mascota mascota){

        //Clausula WHERE
        String selection = Constante.ColumnasMascota.C_ID + " = ?";
        String[] selectionArgs = { String.valueOf(mascota.getId()) };

        database.update(Constante.MASCOTA_TABLE_NAME, getValues(mascota), selection, selectionArgs);
    }

    public List<Mascota> getMascotas(){

        List<Mascota> mascotas = new ArrayList<>();
        String query = "select * from "+ Constante.MASCOTA_TABLE_NAME+" order by "+Constante.ColumnasMascota.C_CANTIDAD_ME_GUSTA+" desc";

        Cursor filas = database.rawQuery(query, null);
        while (filas.moveToNext()){
            Mascota mascota = new Mascota();
            mascota.setId(filas.getInt(Constante.ColumnasMascota.C_ID_INDEX));
            mascota.setNombre(filas.getString(Constante.ColumnasMascota.C_NOMBRE_INDEX));
            mascota.setFoto(filas.getInt(Constante.ColumnasMascota.C_FOTO_INDEX));
            mascota.setCantidadMeGusta(filas.getInt(Constante.ColumnasMascota.C_CANTIDAD_ME_GUSTA_INDEX));
            mascota.setMeGusta(filas.getInt(Constante.ColumnasMascota.C_ME_GUSTA_INDEX)==1?true:false);

            mascotas.add(mascota);
        }
        return mascotas;
    }
}
