package com.developers.carlos.uppy.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by carlos on 20/02/17.
 */

public class Prefs{

        private static final String BD_BANDERA = "bd_bandera";
        private static final String PREFS_NAME = "prefs";
        private static Prefs instance;
        private final SharedPreferences sharedPreferences;

        public Prefs(Context context) {

            sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        }

        public static Prefs with(Context context) {

            if (instance == null) {
                instance = new Prefs(context);
            }
            return instance;
        }

        public void setBdBandera(boolean bandera) {

            sharedPreferences
                    .edit()
                    .putBoolean(BD_BANDERA, bandera)
                    .apply();
        }


        public boolean isBdBandera(){
            return sharedPreferences.getBoolean(BD_BANDERA, false);
        }

}
