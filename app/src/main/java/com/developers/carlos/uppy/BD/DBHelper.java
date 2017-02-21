package com.developers.carlos.uppy.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by carlos on 20/02/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "uppy";
    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear la tablas
        db.execSQL(Constante.CREAR_TABLA_MASCOTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+Constante.MASCOTA_TABLE_NAME);
        onCreate(db);
    }

}