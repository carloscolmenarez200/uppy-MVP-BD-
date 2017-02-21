package com.developers.carlos.uppy.BD;

import android.provider.BaseColumns;

/**
 * Created by carlos on 20/02/17.
 */

public class Constante {

    public static final String MASCOTA_TABLE_NAME = "mascota";

    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";


    //Campos de la tabla mascota
    public static class ColumnasMascota{

        public static final String C_ID = BaseColumns._ID;
        public static final String C_NOMBRE = "nombre";
        public static final String C_FOTO = "foto";
        public static final String C_CANTIDAD_ME_GUSTA = "cantidad_me_gusta";
        public static final String C_ME_GUSTA = "me_gusta"; // 1 true y 0 false

        public static final int C_ID_INDEX = 0;
        public static final int C_NOMBRE_INDEX = 1;
        public static final int C_FOTO_INDEX = 2;
        public static final int C_CANTIDAD_ME_GUSTA_INDEX = 3;
        public static final int C_ME_GUSTA_INDEX = 4;
    }


    //Script de Creación de la tabla mascota
    public static final String CREAR_TABLA_MASCOTA =
            "create table "+MASCOTA_TABLE_NAME+"(" +
                    ColumnasMascota.C_ID+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnasMascota.C_NOMBRE+" "+STRING_TYPE+" not null," +
                    ColumnasMascota.C_FOTO+" "+INT_TYPE+" not null," +
                    ColumnasMascota.C_CANTIDAD_ME_GUSTA+" "+INT_TYPE+" not null," +
                    ColumnasMascota.C_ME_GUSTA+" "+INT_TYPE+")";

}
